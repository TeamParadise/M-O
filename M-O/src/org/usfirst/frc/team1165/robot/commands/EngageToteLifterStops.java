package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EngageToteLifterStops extends Command
{

	public EngageToteLifterStops()
	{
		requires(Robot.toteLifterStops);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.toteLifterStops.engage();
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}
}
