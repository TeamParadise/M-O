package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command
{
	private String forwardSpeedKey;

	private double forwardSpeed;
	
	private DriveStraight(double timeout)
	{
		super(timeout);
		requires(Robot.driveTrain);
	}
	
	public DriveStraight(String forwardSpeedKey, double timeout) 
	{
		this(timeout);
		this.forwardSpeedKey = forwardSpeedKey;
	}

	public DriveStraight(double forwardSpeed, double timeout) 
	{
		this(timeout);
		this.forwardSpeed = forwardSpeed;
	}

	protected void initialize()
	{
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
		}
		
		Robot.gyroscope.reset();
	}

	protected void execute()
	{
		double twistCorrection = Robot.gyroscope.getTwistCorrection();
		
		Robot.driveTrain.driveCartesian(forwardSpeed, 0, twistCorrection, 0);
	}

	protected boolean isFinished()
	{
		return isTimedOut();
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
