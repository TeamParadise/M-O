package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightDistance extends Command
{
	private double forwardSpeed;
	private double driveInches;
	
	private String forwardSpeedKey;
	private String driveInchesKey;
	
	private DriveStraightDistance()
	{
		requires(Robot.driveTrain);
	}
	
	public DriveStraightDistance(String forwardSpeedKey, String driveInchesKey) 
	{
		this();
		this.forwardSpeedKey = forwardSpeedKey;
		this.driveInchesKey = driveInchesKey;
	}

	public DriveStraightDistance(double forwardSpeed, double driveInches) 
	{
		this();
		this.forwardSpeed = forwardSpeed;
		this.driveInches = driveInches;
	}

	protected void initialize()
	{
		if (forwardSpeedKey != null)
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
		return Math.abs(Robot.quadEncoder.getInches()) > Math.abs(driveInches);
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
