package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.RunServoMotorFromJoystick;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ServoMotor extends Subsystem
{
	Servo servoMotor;
	
	public ServoMotor(int channel)
	{
		servoMotor = new Servo(channel);
	}
	
	public void setPosition(double position)
	{
		servoMotor.set(position);
	}
	
	/**
	 * Resets the servo back to the default position at an angle of 90
	 */
	public void reset()
	{
		servoMotor.set(0.5);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new RunServoMotorFromJoystick());
	}
}
