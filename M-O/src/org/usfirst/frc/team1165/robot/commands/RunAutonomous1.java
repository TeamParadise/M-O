package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunAutonomous1 extends CommandGroup
{

	public RunAutonomous1()
	{
		addSequential(new RotateToHeading(RobotMap.ROTATE_SPEED, 15, -45, RobotMap.ROTATE_CREEP_SPEED), 1);
		addSequential(new DriveHalfCircle(0.2));
	}
}
