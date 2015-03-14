package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightDistanceWithTcas extends Command
{
	private String forwardSpeedKey;
	private String driveInchesKey;

	private double forwardSpeed;
	private double driveInches;
	private double tcas;
	private double sitAndSpin; //distance from the sonar at which all forward motion stops and we twist until sonar clears
	private boolean didWeAvoidOneThing = false;
	
	private DriveStraightDistanceWithTcas()
	{
		requires(Robot.driveTrain);
	}
	
	public DriveStraightDistanceWithTcas(String forwardSpeedKey, String driveInchesKey) 
	{
		this();
		this.forwardSpeedKey = forwardSpeedKey;
		this.driveInchesKey = driveInchesKey;
	}

	public DriveStraightDistanceWithTcas(double forwardSpeed, double driveInches, double tcas, double sitAndSpin) 
	{
		this();
		this.forwardSpeed = forwardSpeed;
		this.driveInches = driveInches;
		this.tcas = tcas;
		this.sitAndSpin = sitAndSpin;
	}

	protected void initialize()
	{
		if (null != forwardSpeedKey)
		{
			forwardSpeed = SmartDashboard.getNumber(forwardSpeedKey);
			driveInches = SmartDashboard.getNumber(driveInchesKey);
		}
		didWeAvoidOneThing = false;		
		Robot.gyroscope.reset();
		Robot.quadEncoder.reset();
	}

	protected void execute()
	{
		double twistCorrection = Robot.gyroscope.getTwistCorrection();
		double speed;
		if (Robot.rangeFinder.getRange() < tcas && Robot.rangeFinder.getRange() > 30) 
		{ 
			twistCorrection = -0.40;
			if (!didWeAvoidOneThing)
			{
				didWeAvoidOneThing = true;
				driveInches *= 1.1;
			}
		}
		if (Robot.rangeFinder.getRange() < sitAndSpin && Robot.rangeFinder.getRange() > 30)
		{
			speed = 0;//-forwardSpeed *0.5;
			twistCorrection = -0.3;
		}
		else speed = forwardSpeed;
		
		Robot.driveTrain.driveCartesian(speed, 0, twistCorrection, 0);
	}
 
	protected boolean isFinished()
	{
		return Math.abs(Robot.quadEncoder.getInches()) > driveInches;
	}

	protected void end()
	{
		Robot.driveTrain.driveCartesian(0, 0, 0, 0);
	}

	protected void interrupted()
	{
		end();
	}
}
