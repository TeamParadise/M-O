package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ExcreteOnStep extends CommandGroup
{

	public ExcreteOnStep()
	{
		addSequential(new MovePickupWheelsOut());
		//Drive to step using range finder
		addSequential(new EngageToteLifterStops());
		addSequential(new LowerTotes());
		addSequential(new WaitCommand(0.5));
		addSequential(new MovePickupWheelsIn());
		addSequential(new PickupWheelsSpinOut(1.0, 2.0)); // magnitude, seconds
		addSequential(new WaitCommand(0.5));
		// Back up
		//addSequential(new DriveStraightDistance(-30));
		//addSequential(new SetDefaultRobotPositions());
	}
}
