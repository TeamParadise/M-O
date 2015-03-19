package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickupContainer extends CommandGroup
{

	public PickupContainer()
	{
		addSequential(new MovePickupArmsDown());
		addSequential(new MovePickupArmsUp());
	}
}
