package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveRobotContainerAndTwoTotesToAutoZone extends CommandGroup
{

	public MoveRobotContainerAndTwoTotesToAutoZone()
	{
		addSequential(new PickupTote());
		addSequential(new MovePickupArmsUp());
		addSequential(new DriveToObject(RobotMap.DRIVE_SPEED , 40 , 6 , RobotMap.DRIVE_CREEP_SPEED , 84 ));
		addSequential(new PickupTote());//Pickup 2nd Tote
		addParallel(new MovePickupWheelsIn());
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , -90 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,  RobotMap.DISTANCE_TO_AUTO_ZONE ));
	
	}
}
