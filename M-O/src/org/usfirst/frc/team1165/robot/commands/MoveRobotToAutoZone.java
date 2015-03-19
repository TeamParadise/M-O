package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveRobotToAutoZone extends CommandGroup
{

	public MoveRobotToAutoZone(String speedKey, String inchesDistanceKey)
	{
		addSequential(new DriveStraightDistance(speedKey, inchesDistanceKey));
	}
}
