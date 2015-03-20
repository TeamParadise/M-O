package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.TotePistonLowPressureAir;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ExcreteOnStep extends CommandGroup
{

	public ExcreteOnStep()
	{
		//Drive to step (USER CONTROLLED)
		//addSequential(new DriveToObject(RobotMap.DRIVE_SPEED/2,40,20,RobotMap.DRIVE_SPEED/4,1000));
		addSequential(new MovePickupWheelsOut());
		addSequential(new EngageToteLifterStops());
		addSequential(new TotePistonLowPressureAir());
		addSequential(new WaitCommand(RobotMap.WAIT_BETWEEN_PNEUMATIC_ACTIONS));
		addSequential(new MovePickupWheelsIn());
		addSequential(new PickupWheelsSpinOut(RobotMap.PICKUP_WHEELS_SPEED, RobotMap.PICKUP_WHEELS_SPIN_OUT_TIME, true)); // magnitude, seconds
		addSequential(new SetDefaultRobotPositions());
	}
}
