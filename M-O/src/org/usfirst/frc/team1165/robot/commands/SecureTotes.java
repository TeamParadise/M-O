package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SecureTotes extends CommandGroup
{

	public SecureTotes()
	{
		addSequential(new EngageToteLifterStops());
		addSequential(new LowerTotes());
		addSequential(new WaitCommand(0.4));
		addSequential(new MovePickupWheelsIn());
	}
}