package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1165.robot.commands.DoNothing;
import org.usfirst.frc.team1165.robot.commands.MoveRobotAndContainerToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotAndToteToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotToteAndContainerToAutoZone;
import org.usfirst.frc.team1165.robot.commands.PickupToteAndContainer;
import org.usfirst.frc.team1165.robot.subsystems.BoxPickupWheels;
import org.usfirst.frc.team1165.robot.subsystems.Camera;
import org.usfirst.frc.team1165.robot.subsystems.Camera.CameraMode;
import org.usfirst.frc.team1165.robot.subsystems.CanPickupArms;
import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.robot.subsystems.QuadEncoder;
import org.usfirst.frc.team1165.robot.subsystems.Gyroscope;
import org.usfirst.frc.team1165.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1165.robot.subsystems.ToteLifterStops;

public class Robot extends IterativeRobot
{
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final RangeFinder rangeFinder = new RangeFinder();
	public static final Gyroscope gyroscope = new Gyroscope();
	public static final QuadEncoder quadEncoder = new QuadEncoder();
	public static final BoxPickupWheels boxPickupWheels = new BoxPickupWheels();
	public static Camera camera;
	public static final ToteLifterStops toteLifterStops = new ToteLifterStops();
	public static OI oi;
	public static final CanPickupArms canPickupArms = new CanPickupArms();
	
	SendableChooser autoChooser;
	Command autonomousCommand;
	
	public void robotInit()
	{
		oi = new OI();
				
		autoChooser = new SendableChooser();
		autoChooser.addObject("Do Nothing", new DoNothing());
		autoChooser.addObject("Move Robot To Auto Zone", new MoveRobotToAutoZone(0.5,RobotMap.DISTANCE_TO_AUTO_ZONE, RobotMap.DRIVE_CREEP_SPEED, RobotMap.CREEP_DISTANCE)); //"Auto Speed", "Auto Inches"));
		autoChooser.addObject("Single Tote", new MoveRobotAndToteToAutoZone());
		autoChooser.addDefault("Single Container", new MoveRobotAndContainerToAutoZone());
		autoChooser.addObject("Single Tote AND Container To Auto Zone", new MoveRobotToteAndContainerToAutoZone());
		autoChooser.addObject("PICKUP Tote And Container", new PickupToteAndContainer());
		SmartDashboard.putData("Auto:", autoChooser);
		
		//Use this to use just the primary camera:
		camera = new Camera(CameraMode.THREAD);
		
		// Use this to use both cameras with the secondary camera being enabled in conjunction with control of the container pickup arm:
		//camera = new Camera(CameraMode.THREAD, RobotMap.primaryCameraName, RobotMap.secondaryCameraName);
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
		{
			autonomousCommand.cancel();
		}
	}

	public void disabledInit()
	{
	}

	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
