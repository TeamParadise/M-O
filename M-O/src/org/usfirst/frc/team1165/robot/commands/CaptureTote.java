package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CaptureTote extends Command
{

	public CaptureTote()
	{
		requires(Robot.boxPickupWheels);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.boxPickupWheels.spinIn(1.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return Robot.rangeFinder.getRange() < 7.5;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.boxPickupWheels.idle();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}