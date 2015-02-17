package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunAutonomous1 extends CommandGroup
{

	public RunAutonomous1()
	{
		addSequential(new SetDefaultRobotPositions()); 
		
		addSequential(new PickupTote(), 3);
		
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 30, -90, RobotMap.ROTATE_CREEP_SPEED), 1);
		addSequential(new DriveStraightDistanceWithTcas(RobotMap.DRIVE_SPEED, RobotMap.DISTANCE_TO_AUTO_ZONE, RobotMap.TCAS_DISTANCE, 30), 1);

	}
}
