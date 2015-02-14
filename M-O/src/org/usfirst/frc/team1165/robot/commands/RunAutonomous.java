package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunAutonomous extends CommandGroup
{

	public RunAutonomous()
	{
		addSequential(new SetDefaultRobotPositions());
		//addSequential(new PickUpTote());
		addSequential(new RotateToHeading(.6, 15, -45, 0.2));
		addSequential(new DriveStraightDistance(-1, 53));
		addSequential(new RotateToHeading(.6, 30, 75, 0.2));
		addSequential(new DriveStraightDistance(-1, 65));
		//addSequential(new PickUpTote());

		addSequential(new RotateToHeading(.6, 15, 45, 0.2));
		addSequential(new DriveStraightDistance(-1, 53));
		addSequential(new RotateToHeading(.6, 30, -75, 0.2));
		addSequential(new DriveStraightDistance(-1, 65));
		//addSequential(new PickUpTote());
		
		addSequential(new RotateToHeading(.6, 30, -75, 0.2));
		addSequential(new DriveStraightDistanceWithTcas(-0.4, 125, 60, 30));
	}
}
