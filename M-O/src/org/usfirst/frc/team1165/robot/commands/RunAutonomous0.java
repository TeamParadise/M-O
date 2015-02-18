package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RunAutonomous0 extends CommandGroup
{

	public RunAutonomous0()
	{
		addSequential(new PickupTote());
		addSequential(new WaitCommand(0.8));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 90, RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE)); //give gyro and encoder a chance to reset
		addSequential(new DriveStraightDistance(0.5 , RobotMap.DISTANCE_TO_AUTO_ZONE ));
		//addSequential(new DriveStraightDistanceWithTcas(0.3, RobotMap.DISTANCE_TO_AUTO_ZONE, RobotMap.TCAS_DISTANCE, RobotMap.TCAS_SITANDSPIN), 1);
//		/*addSequential(new SetDefaultRobotPositions()); 
//		
//		addSequential(new PickupTote(), 3);
//		
//		//addSequential(new DriveStraightDistance(-RobotMap.DRIVE_SPEED, 10), 1);
//		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, -45, RobotMap.ROTATE_CREEP_SPEED), 1);
//		addSequential(new DriveStraight(RobotMap.DRIVE_SPEED, 2), 1);
//		//addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 53), 1);
//		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 25, 75, RobotMap.ROTATE_CREEP_SPEED), 1);
//		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 65), 1);
//		
//		addSequential(new PickupTote(),3);
//
//		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 45, RobotMap.ROTATE_CREEP_SPEED), 1);
//		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 53), 1);
//		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 25, -75, RobotMap.ROTATE_CREEP_SPEED), 1);
//		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 65), 1);
//		
//		addSequential(new PickupTote(), 3);
//		
//		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 25, -75, RobotMap.ROTATE_CREEP_SPEED), 1);
//		addSequential(new DriveStraightDistanceWithTcas(RobotMap.DRIVE_SPEED, RobotMap.DISTANCE_TO_AUTO_ZONE, RobotMap.TCAS_DISTANCE, 30), 1);

	}
}
