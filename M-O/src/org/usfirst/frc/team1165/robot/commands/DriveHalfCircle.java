package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveHalfCircle extends Command
{
	private String forwardSpeedKey;
	private double currentHeading;
	private double originalHeading;

	private double forwardSpeed;
	
	private DriveHalfCircle()
	{
		requires(Robot.driveTrain);
	}
	
	public DriveHalfCircle(String forwardSpeedKey) 
	{
		this();
		this.forwardSpeedKey = forwardSpeedKey;
	}

	public DriveHalfCircle(double forwardSpeed) 
	{
		this();
		this.forwardSpeed = forwardSpeed;
	}

	protected void initialize()
	{
		originalHeading = Robot.gyroscope.getHeading();
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
		}
	}

	protected void execute()
	{
		double twistCorrection = 0.165;
		SmartDashboard.putNumber("TwistCorrection", twistCorrection);
		Robot.driveTrain.driveCartesian(forwardSpeed , 0, twistCorrection, 0);
	}
 
	protected boolean isFinished()
	{
		// Is one degree close enough???
		currentHeading = Robot.gyroscope.getHeading();
		return currentHeading >= 45 ;
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
