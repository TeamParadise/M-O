package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunServoMotorFromJoystick extends Command
{

	public RunServoMotorFromJoystick()
	{
		requires(Robot.leftServoMotor);
		requires(Robot.rightServoMotor);
	}

	protected void initialize()
	{
		Robot.leftServoMotor.reset();
		Robot.rightServoMotor.reset();
	}

	protected void execute()
	{
		double position = (Robot.oi.twistAngle() + 1.0) / 2.0;
		Robot.leftServoMotor.setPosition(position);
		Robot.rightServoMotor.setPosition(position);
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		Robot.leftServoMotor.reset();
		Robot.rightServoMotor.reset();
	}

	protected void interrupted()
	{
		end();
	}
}
