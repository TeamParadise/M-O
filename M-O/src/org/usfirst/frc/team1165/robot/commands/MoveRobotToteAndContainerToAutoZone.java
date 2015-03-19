package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;

/**
 *
 */
public class MoveRobotToteAndContainerToAutoZone extends CommandGroup
{

	public MoveRobotToteAndContainerToAutoZone()
	{
		addSequential(new PickupTote());
		//addSequential(new WaitCommand(0.8));
		addSequential(new MovePickupArmsUp());
		addSequential(new MovePickupWheelsIn());
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, 90, RobotMap.ROTATE_CREEP_SPEED));
		addSequential(new WaitCommand(RobotMap.WAIT_FOR_SUBSYSTEM_TO_COMPLETE)); //give gyro and encoder a chance to reset
		addSequential(new DriveStraightDistance(0.5 , RobotMap.DISTANCE_TO_AUTO_ZONE ));
	}
}
