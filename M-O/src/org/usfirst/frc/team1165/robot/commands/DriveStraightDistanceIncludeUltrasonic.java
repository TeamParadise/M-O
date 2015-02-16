package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightDistanceIncludeUltrasonic extends Command
{
	private String forwardSpeedKey;
	private String driveInchesKey;

	private double forwardSpeed;
	private double driveInches;
	
	public DriveStraightDistanceIncludeUltrasonic(String forwardSpeedKey, String driveInchesKey) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeedKey = forwardSpeedKey;
		this.driveInchesKey = driveInchesKey;
	}

	public DriveStraightDistanceIncludeUltrasonic(double forwardSpeed, double driveInches) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeed = forwardSpeed;
		this.driveInches = driveInches;
		forwardSpeedKey = null;
	}

	protected void initialize()
	{
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
			driveInches = SmartDashboard.getNumber(driveInchesKey);
		}
		
		Robot.gyroscope.reset();
		Robot.quadEncoder.reset();
	}

	protected void execute()
	{
		double twistCorrection = Robot.gyroscope.getTwistCorrection();
		
		Robot.driveTrain.driveCartesian(forwardSpeed, 0, twistCorrection, 0);
	}
 
	protected boolean isFinished()
	{
		return Math.abs(Robot.quadEncoder.getInches()) > driveInches || Math.abs(Robot.rangeFinder.getRange()) > driveInches;
	}

	protected void end()
	{
		Robot.driveTrain.driveCartesian(0, 0, 0, 0);
	}

	protected void interrupted()
	{
		end();
	}
}
