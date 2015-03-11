package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PickUpToteAndMoveToAutoZone extends CommandGroup
{

	public PickUpToteAndMoveToAutoZone()
	{
		addSequential(new PickupTote());
		addSequential(new WaitCommand(0.8));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 90, RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE)); //give gyro and encoder a chance to reset
		addSequential(new DriveStraightDistance(0.5 , RobotMap.DISTANCE_TO_AUTO_ZONE ));
	}
}
