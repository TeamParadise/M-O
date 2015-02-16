package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SuckInTote extends Command
{
	private boolean useSonar;
	
	public SuckInTote()
	{
		requires(Robot.boxPickupWheels);
	}

	protected void initialize()
	{
		Robot.boxPickupWheels.spinIn(RobotMap.PICKUP_WHEELS_SPEED);
		useSonar = Robot.rangeFinder.getRange() > RobotMap.SONIC_TOTE_IN && Robot.rangeFinder.getRange() < RobotMap.ROBOT_BACKUP_FROM_SCORING_PLATFORM;
	}

	protected void execute()
	{
	}

	protected boolean isFinished()
	{
		return useSonar && Robot.rangeFinder.getRange() < RobotMap.SONIC_TOTE_IN;
	}

	protected void end()
	{
		Robot.boxPickupWheels.idle();
	}

	protected void interrupted()
	{
	}
}
