package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisengageToteLifterStops extends Command
{
	public DisengageToteLifterStops()
	{
		requires(Robot.toteLifterStops);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.toteLifterStops.disengage();
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
