package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.commands.piston.LiftTotePiston;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SetDefaultRobotPositions extends CommandGroup
{

	public SetDefaultRobotPositions()
	{
		addSequential(new DisengageToteLifterStops());
		addSequential(new LiftTotePiston());
		addSequential(new MovePickupWheelsOut());
	}
}
