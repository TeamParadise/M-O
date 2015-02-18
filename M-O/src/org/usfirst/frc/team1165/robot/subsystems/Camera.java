package org.usfirst.frc.team1165.robot.subsystems;

import java.io.File;
import java.io.PrintWriter;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ProcessCameraFrames;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem implements Runnable
{
	public enum CameraMode { SUBSYSTEM, RUNNABLE };

	private int session;
	private Image frame;
	private CameraMode mode;
	
	/**
	 * 
	 * @param mode Indicates if should run Camera as a SUBSYSTEM or a RUNNABLE
	 */
	public Camera(CameraMode mode)
	{
		this.mode = mode;
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		session = NIVision.IMAQdxOpenCamera(RobotMap.cameraName,
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxSetAttributeString(session, "AcquisitionAttributes::VideoMode", "640 x 480 YUY 2 30.00 fps");
		
		try
		{
			new File("/home/lvuser/data").mkdirs();
			
			PrintWriter pw = new PrintWriter("/home/lvuser/data/NIVision_VideoModes.txt");
			NIVision.dxEnumerateVideoModesResult result = NIVision.IMAQdxEnumerateVideoModes(session);
			pw.println("Current: \"" + result.videoModeArray[result.currentMode].Name + '"');
			pw.println();
			for (NIVision.IMAQdxEnumItem item : result.videoModeArray)
			{
				pw.println('"' + item.Name + '"');
			}
			pw.close();
			
			NIVision.IMAQdxWriteAttributes(session, "/home/lvuser/data/NIVision_Attributes.txt");
		}
		catch (Exception ex)
		{
			// do nothing
		}
		
		NIVision.IMAQdxConfigureGrab(session);
		NIVision.IMAQdxStartAcquisition(session);
		CameraServer.getInstance().setQuality(50);
		
		if (mode == CameraMode.RUNNABLE)
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
		NIVision.IMAQdxGrab(session, frame, 1);
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