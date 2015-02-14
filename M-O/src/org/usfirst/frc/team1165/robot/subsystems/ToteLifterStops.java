package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ReportToteLifterStopPositions;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls tote lifter stops on either side of robot.
 */
public class ToteLifterStops extends Subsystem
{
	private Servo leftServo = new Servo(RobotMap.leftServoChannel);
	private Servo rightServo = new Servo(RobotMap.rightServoChannel);
	
	public void disengage()
	{
		leftServo.set(RobotMap.leftServoDisengagePosition);
		rightServo.set(RobotMap.rightServoDisengagePosition);
	}
	
	public void engage()
	{
		leftServo.set(RobotMap.leftServoEngagePosition);
		rightServo.set(RobotMap.rightServoEngagePosition);
	}
	
	public double getLeftPosition()
	{
		return leftServo.get();
	}
	
	public double getRightPosition()
	{
		return rightServo.get();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new ReportToteLifterStopPositions(this));
	}
}
