package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveHalfCircle extends Command
{
	private String forwardSpeedKey;
	//private String twistCorrectionKey;

	private double forwardSpeed;
	
	public DriveHalfCircle(String forwardSpeedKey) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeedKey = forwardSpeedKey;
	}

	public DriveHalfCircle(double forwardSpeed) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeed = forwardSpeed;
		forwardSpeedKey = null;
	}

	protected void initialize()
	{
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
		}
	}

	protected void execute()
	{
		double twistCorrection = Robot.gyroscope.getTwistCorrection();
		
		Robot.driveTrain.driveCartesian(forwardSpeed, 0, twistCorrection, 0);
	}
 
	protected boolean isFinished()
	{
		return Math.abs(Robot.gyroscope.getHeading()) <= 1; // Is one degree close enough???
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
