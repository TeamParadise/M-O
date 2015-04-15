package org.usfirst.frc.team1165.robot.subsystems;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.shape.Path;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ProcessCameraFrames;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem implements Runnable
{
	public enum CameraMode { SUBSYSTEM, THREAD };

	private int primarySession;
	private int secondarySession;
	private int currentSession;
	private boolean hasSecondaryCamera;
	private Image frame;
	private CameraMode mode;
	
	private final static String exceptionLogFile = "/home/lvuser/data/CameraException.txt";
	private final static String videoMode = "640 x 480 YUY 2 30.00 fps";
	
	/**
	 * 
	 * @param mode Indicates if should run Camera as a SUBSYSTEM or a RUNNABLE
	 */
	public Camera(CameraMode mode)
	{
		this(mode, RobotMap.cameraName, null);
	}
	
	public Camera(CameraMode mode, String primaryCameraName, String secondaryCameraName)
	{
		try
		{
			Files.deleteIfExists(Paths.get(exceptionLogFile));
		}
		catch (Exception ex)
		{
		}
		
		this.mode = mode;
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		
		primarySession = NIVision.IMAQdxOpenCamera(primaryCameraName,
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxSetAttributeString(primarySession, "AcquisitionAttributes::VideoMode", videoMode);
		
		if (null != secondaryCameraName)
		{
			try
			{
				secondarySession = NIVision.IMAQdxOpenCamera(secondaryCameraName,
						NIVision.IMAQdxCameraControlMode.CameraControlModeController);
				NIVision.IMAQdxSetAttributeString(secondarySession, "AcquisitionAttributes::VideoMode", videoMode);
				hasSecondaryCamera = true;
			}
			catch (Exception ex)
			{
				try
				{
					PrintWriter pw = new PrintWriter(exceptionLogFile);
					pw.println("Error creating secondary session");
					ex.printStackTrace(pw);
					pw.close();
				}
				catch (Exception ex2)
				{
					// do nothing
				}
			}
		}
		
		try
		{
			new File("/home/lvuser/data").mkdirs();
			
			PrintWriter pw = new PrintWriter("/home/lvuser/data/NIVision_VideoModes.txt");
			NIVision.dxEnumerateVideoModesResult result = NIVision.IMAQdxEnumerateVideoModes(primarySession);
			pw.println("Current: \"" + result.videoModeArray[result.currentMode].Name + '"');
			pw.println();
			for (NIVision.IMAQdxEnumItem item : result.videoModeArray)
			{
				pw.println('"' + item.Name + '"');
			}
			pw.close();
			
			NIVision.IMAQdxWriteAttributes(primarySession, "/home/lvuser/data/NIVision_Attributes.txt");
		}
		catch (Exception ex)
		{
			// do nothing
		}
				
		NIVision.IMAQdxConfigureGrab(primarySession);
		NIVision.IMAQdxStartAcquisition(primarySession);
		currentSession = primarySession;
				
		CameraServer.getInstance().setQuality(50);
		
		if (mode == CameraMode.THREAD)
		{
			new Thread(this).start();
		}
	}

	public void initDefaultCommand()
	{
		if (mode == CameraMode.SUBSYSTEM)
		{
			setDefaultCommand(new ProcessCameraFrames(this));
		}
	}

	public void processFrame()
	{
		if (currentSession == primarySession)
		{
			if (hasSecondaryCamera && Robot.oi.useSecondaryCamera())
			{
				try
				{
					NIVision.IMAQdxStopAcquisition(currentSession);
					NIVision.IMAQdxConfigureGrab(secondarySession);
					NIVision.IMAQdxStartAcquisition(secondarySession);
					currentSession = secondarySession;
				}
				catch (Exception ex)
				{
					try
					{
						PrintWriter pw = new PrintWriter(exceptionLogFile);
						pw.println("Error switching to secondary session");
						ex.printStackTrace(pw);
						pw.close();
					}
					catch (Exception ex2)
					{
						// do nothing
					}

				}
			}
		}
		else if (!Robot.oi.useSecondaryCamera())
		{
			try
			{
				NIVision.IMAQdxStopAcquisition(currentSession);
				NIVision.IMAQdxConfigureGrab(primarySession);
				NIVision.IMAQdxStartAcquisition(primarySession);
				currentSession = primarySession;
			}
			catch (Exception ex)
			{
				try
				{
					PrintWriter pw = new PrintWriter(exceptionLogFile);
					pw.println("Error switching to primary session");
					ex.printStackTrace(pw);
					pw.close();
				}
				catch (Exception ex2)
				{
					// do nothing
				}

			}
		}
		
		try
		{
			NIVision.IMAQdxGrab(currentSession, frame, 1);
		}
		catch (Exception ex)
		{
			try
			{
				PrintWriter pw = new PrintWriter(exceptionLogFile);
				pw.println("Error calling IMAQdxGrab");
				ex.printStackTrace(pw);
				pw.close();
			}
			catch (Exception ex2)
			{
				// do nothing
			}
		}
		//NIVision.imaqSetImageSize(frame, 320, 240);
		CameraServer.getInstance().setImage(frame);
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			processFrame();
			try
			{
				Thread.sleep(20);
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}