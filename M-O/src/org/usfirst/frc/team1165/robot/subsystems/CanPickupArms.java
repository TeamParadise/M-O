package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.RunPickupArmsFromJoystick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanPickupArms extends Subsystem
{
	Talon leftPickupArm = new Talon(RobotMap.lefCanPickupArm);
	Talon rightPickupArm = new Talon(RobotMap.rightCanPickupArm);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void spinOut(double speed)
	{
		speed = Math.min(Math.abs(speed), 1);
		leftPickupArm.set(-speed);
		rightPickupArm.set(speed);
	}
	
	public void spinIn(double speed)
	{
		speed = Math.min(Math.abs(speed), 1);
		leftPickupArm.set(speed);
		rightPickupArm.set(-speed);
	}
	
	public void spinRight(double speed)
	{
		speed = Math.min(Math.abs(speed), 1);
		leftPickupArm.set(speed);
		rightPickupArm.set(speed);
	}
	
	public void spinLeft(double speed)
	{
		speed = Math.min(Math.abs(speed), 1);
		leftPickupArm.set(-speed);
		rightPickupArm.set(-speed);
	}
	
	public void idle()
	{
		leftPickupArm.set(0);
		rightPickupArm.set(0);
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new RunPickupArmsFromJoystick());
	}
}
