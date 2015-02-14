package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ExcreteOnScoringPlatform extends CommandGroup
{

	public ExcreteOnScoringPlatform()
	{
		//Drive to Platform
		addSequential(new MovePickupWheelsOut());
		addSequential(new WaitCommand(0.5));
		addSequential(new LowerTotes());
		addSequential(new WaitCommand(1));
		//addSequential(new DriveStraightDistance(-30));
		//addSequential(new SetDefaultRobotPositions());
	}
}
