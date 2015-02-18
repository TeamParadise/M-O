package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickupWheelsStop extends Command
{
	public PickupWheelsStop()
	{
		requires(Robot.boxPickupWheels);
	}

	protected void initialize()
	{
		Robot.boxPickupWheels.idle();
	}

	protected void execute()
	{
		Robot.boxPickupWheels.idle();
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
		Robot.boxPickupWheels.idle();
	}

	protected void interrupted()
	{
		end();
	}
}
