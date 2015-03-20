package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RotateToPushContainerOutOfWay extends CommandGroup
{

	public RotateToPushContainerOutOfWay()
	{
		addSequential(new PickupTote());
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,15));
		addSequential(new WaitCommand(0.3));
		//by turning and driving
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , -90 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,24));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new WaitCommand(0.3));
		//drive to next crate
		addSequential(new DriveToObject(RobotMap.DRIVE_SPEED , 40 , 6 , RobotMap.DRIVE_CREEP_SPEED , 55 ));
		addSequential(new PickupTote());
		addSequential(new WaitCommand(0.3));
 		//To auto Zone
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 90 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,  RobotMap.DISTANCE_TO_AUTO_ZONE ));
		
	}
}
