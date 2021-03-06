package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotePiston;
import org.usfirst.frc.team1165.robot.commands.piston.TotePistonLowPressureAir;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ExcreateOnScoringPlatformWithoutDefaultPositions extends CommandGroup
{

	public ExcreateOnScoringPlatformWithoutDefaultPositions()
	{
		addSequential(new MovePickupWheelsOut());
		addSequential(new LiftTotePiston());
		addSequential(new DisengageToteLifterStops());
		addSequential(new WaitCommand(RobotMap.WAIT_BETWEEN_PNEUMATIC_ACTIONS/2));
		addSequential(new TotePistonLowPressureAir());
		addSequential(new WaitCommand(RobotMap.WAIT_BETWEEN_PNEUMATIC_ACTIONS));
		addSequential(new DriveStraightDistanceIncludeUltrasonic(-RobotMap.DRIVE_SPEED*.6667, RobotMap.ROBOT_BACKUP_FROM_SCORING_PLATFORM), .5);

	}
}
