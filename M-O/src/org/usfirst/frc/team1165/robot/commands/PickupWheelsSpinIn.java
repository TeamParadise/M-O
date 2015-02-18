package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PickupWheelsSpinIn extends Command
{

	private double magnitude = RobotMap.PICKUP_WHEELS_SPEED;
	private boolean idle = true;

	public PickupWheelsSpinIn()
	{
		requires(Robot.boxPickupWheels);
	}

	public PickupWheelsSpinIn(double magnitude, double timeout, boolean idle)
	{
		requires(Robot.boxPickupWheels);
		this.magnitude = magnitude;
		this.idle = idle;
		setTimeout(timeout);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.boxPickupWheels.spinIn(magnitude);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isTimedOut();
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
