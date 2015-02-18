package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.Gyroscope;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightDistance extends Command
{
	private double forwardSpeed;
	private double driveInches;
	
	public DriveStraightDistance(String forwardSpeedKey, String driveInchesKey) 
	{
		requires(Robot.driveTrain);
		requires(Robot.gyroscope);
		forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
		driveInches = SmartDashboard.getNumber(driveInchesKey);
	}

	public DriveStraightDistance(double forwardSpeed, double driveInches) 
	{
		requires(Robot.driveTrain);
		requires(Robot.gyroscope);
		this.forwardSpeed = forwardSpeed;
		this.driveInches = driveInches;
	}

	protected void initialize()
	{
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
		return Math.abs(Robot.quadEncoder.getInches()) > driveInches;
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
