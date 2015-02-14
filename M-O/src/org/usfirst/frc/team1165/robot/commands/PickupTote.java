package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.commands.piston.LiftTotes;
import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PickupTote extends CommandGroup
{
	public PickupTote()
	{
		addSequential(new SetDefaultRobotPositions());
		//Drive to tote
		addSequential(new MovePickupWheelsIn());
		addSequential(new CaptureTote());
		addSequential(new LowerTotes());
		addSequential(new WaitCommand(1));
		addSequential(new MovePickupWheelsOut());
		addSequential(new LiftTotes());
	}
}