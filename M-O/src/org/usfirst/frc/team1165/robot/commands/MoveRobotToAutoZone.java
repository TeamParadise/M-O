package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
