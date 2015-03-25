package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;

/**
 *
 */
public class MoveRobotAndContainerToAutoZone extends CommandGroup
{

	public MoveRobotAndContainerToAutoZone()
	{
		
		addSequential(new MovePickupArmsUp());
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 90, RobotMap.ROTATE_CREEP_SPEED));
		//addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE)); //give gyro and encoder a chance to reset
		addSequential(new WaitCommand(0.3));
		addSequential(new DriveStraightDistance(0.5 , RobotMap.DISTANCE_TO_AUTO_ZONE, RobotMap.DRIVE_CREEP_SPEED, RobotMap.CREEP_DISTANCE ));
	}
}
