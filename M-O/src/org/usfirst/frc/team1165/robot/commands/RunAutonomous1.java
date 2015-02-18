package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotes;
import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RunAutonomous1 extends CommandGroup
{

	public RunAutonomous1()
	{
		addSequential(new PickupTote());
		addSequential(new WaitCommand(0.7));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, -45, RobotMap.ROTATE_CREEP_SPEED), 1);
		addSequential(new MovePickupWheelsIn());
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 20 ));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 60, RobotMap.ROTATE_CREEP_SPEED), 1);
		addParallel(new PickupWheelsSpinIn(RobotMap.PICKUP_WHEELS_SPEED,0.2));
		addSequential(new MovePickupWheelsOut());
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED , 52));
		addSequential(new WaitCommand(0.5));
		addSequential(new PickupTote());
	}
}
