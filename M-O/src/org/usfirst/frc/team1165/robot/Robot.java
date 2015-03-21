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
import org.usfirst.frc.team1165.robot.commands.MoveRobotANDTwoTotesToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotContainerAndTwoTotesToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotToAutoZone;
import org.usfirst.frc.team1165.robot.commands.MoveRobotToteAndContainerToAutoZone;
import org.usfirst.frc.team1165.robot.commands.RotateToPushContainerOutOfWay;
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
	public static final Camera camera = new Camera(CameraMode.THREAD);
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
		autoChooser.addObject("Move Robot To Auto Zone", new MoveRobotToAutoZone("Auto Speed", "Auto Inches"));
		autoChooser.addObject("Single Tote", new MoveRobotAndToteToAutoZone());
		autoChooser.addDefault("Single Container", new MoveRobotAndContainerToAutoZone());
		autoChooser.addObject("Single Tote AND Container", new MoveRobotToteAndContainerToAutoZone());
		autoChooser.addObject("Move Two Totes to Auto Zone", new RotateToPushContainerOutOfWay());
		autoChooser.addObject("Move Two Totes And Container To AutoZone", new MoveRobotContainerAndTwoTotesToAutoZone());
		SmartDashboard.putData("Auto:", autoChooser);
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
