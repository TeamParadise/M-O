package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1165.robot.RobotMap;

/**
 *
 */
public class PickupToteAndContainer extends CommandGroup
{

	public PickupToteAndContainer()
	{
		addSequential(new PickupTote());
		//addSequential(new WaitCommand(0.8));
		addSequential(new MovePickupArmsUp());
		addSequential(new DriveStraightDistance(0.5 , 12 , RobotMap.DRIVE_CREEP_SPEED, RobotMap.CREEP_DISTANCE ));
	}
}
