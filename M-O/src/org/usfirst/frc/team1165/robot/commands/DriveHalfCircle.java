package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveHalfCircle extends Command
{
	private String forwardSpeedKey;
	private String driveInchesKey;
	//private String twistCorrectionKey;

	private double forwardSpeed;
	private double driveInches;
	//private double twistCorrection;
	private double startHeading;
	
	public DriveHalfCircle(String forwardSpeedKey, String driveInchesKey) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeedKey = forwardSpeedKey;
		this.driveInchesKey = driveInchesKey;
		//this.twistCorrectionKey = twistCorrectionKey;
	}

	public DriveHalfCircle(double forwardSpeed, double driveInches) 
	{
		requires(Robot.driveTrain);
		this.forwardSpeed = forwardSpeed;
		this.driveInches = Math.PI*driveInches/2; // Half a circle of diameter driveInches
		//this.twistCorrection = twistCorrection;
		forwardSpeedKey = null;
	}

	protected void initialize()
	{
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
			driveInches = SmartDashboard.getNumber(driveInchesKey);
		}
		Robot.quadEncoder.reset();
		startHeading = Robot.gyroscope.getHeading();
	}

	protected void execute()
	{
		double twistCorrection = Robot.gyroscope.getTwistCorrection();
		
		Robot.driveTrain.driveCartesian(forwardSpeed, 0, twistCorrection, 0);
	}
 
	protected boolean isFinished()
	{
		return Robot.gyroscope.getHeading() > 0;
		// return Math.abs(Robot.quadEncoder.getInches()) > driveInches;
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
