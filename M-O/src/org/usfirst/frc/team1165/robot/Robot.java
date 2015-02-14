package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1165.robot.subsystems.BoxPickupWheels;
import org.usfirst.frc.team1165.robot.subsystems.Camera;
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
	public static final Camera camera = new Camera();
	public static final ToteLifterStops toteLifterStops = new ToteLifterStops();
	public static OI oi;
	
	Command autonomousCommand;

	public void robotInit()
	{
		oi = new OI();

		//autonomousCommand = new RunAutonomous();
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		if (autonomousCommand != null)
		{
			autonomousCommand.start();
		}
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
