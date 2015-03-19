package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickupWheelsSpinLeft extends Command
{

	private double magnitude = RobotMap.PICKUP_WHEELS_SPEED;
	private boolean idle = true;

	public PickupWheelsSpinLeft()
	{
		requires(Robot.boxPickupWheels);
	}

	public PickupWheelsSpinLeft(double magnitude, double timeout, boolean idle)
	{
		this();
		this.magnitude = magnitude;
		this.idle = idle;
		setTimeout(timeout);
	}

	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.boxPickupWheels.spinLeft(magnitude);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		if(idle)
		{
			Robot.boxPickupWheels.idle();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
