package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotePiston;
import org.usfirst.frc.team1165.robot.commands.piston.TotePistonLowPressureAir;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PickupTote extends CommandGroup
{
	public PickupTote()
	{
		addSequential(new DisengageToteLifterStops());
		addSequential(new MovePickupWheelsIn());
		addSequential(new SuckInTote(),1.25);
		addSequential(new TotePistonLowPressureAir());
		addSequential(new WaitCommand(RobotMap.WAIT_BETWEEN_PNEUMATIC_ACTIONS));
		addSequential(new MovePickupWheelsOut());
		addSequential(new LiftTotePiston());
	}
}