package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotes;
import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MoveRobotAndThreeTotesToAutoZone extends CommandGroup
{

	public MoveRobotAndThreeTotesToAutoZone()
	{
		addSequential(new PickupTote());
		addSequential(new WaitCommand(RobotMap.WAIT_BETWEEN_PNEUMATIC_ACTIONS));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 20, -40, 0.25));
		addSequential(new MovePickupWheelsIn());
		addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 15 ));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 20, 60, 0.25));
		addSequential(new MovePickupWheelsOut());
		addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED , 20));
		addParallel(new PickupWheelsSpinIn(RobotMap.PICKUP_WHEELS_SPEED, 1, false));
		addSequential(new WaitCommand(0.2));
		addSequential(new PickupTote());
	}
}
