package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveRobotANDTwoTotesToAutoZone extends CommandGroup
{

	public MoveRobotANDTwoTotesToAutoZone()
	{
		addSequential(new PickupTote());
		//addSequential(new MovePickupArmsDown());
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED, 7.5));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , -45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new StrafeWithTimeout(RobotMap.DRIVE_SPEED , 1));
		addSequential(new DriveToObject(RobotMap.DRIVE_SPEED , 40 , 6 , RobotMap.DRIVE_CREEP_SPEED , 84 ));
		addSequential(new PickupTote());//Pickup 2nd Tote
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,7.5));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , -45 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new StrafeWithTimeout(-RobotMap.DRIVE_SPEED , 1));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , -90 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new DriveStraightDistance(RobotMap.DRIVE_SPEED,  RobotMap.DISTANCE_TO_AUTO_ZONE ));
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED , 15 , 90 , RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new ExcreteOnScoringPlatform());
	}
}
