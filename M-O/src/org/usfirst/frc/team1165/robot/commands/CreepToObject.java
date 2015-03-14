package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CreepToObject extends Command
{
	private String targetRangeKey;
	private String creepSpeedKey;

	private double targetRange;
	private double creepSpeed;

	private double currentRange;
	private double twistCorrection;
	
	
	private CreepToObject()
	{
		super(RobotMap.CREEP_TO_OBJECT_TIMEOUT);
		requires(Robot.driveTrain);
	}
	
	public CreepToObject(String targetRangeKey, String creepSpeedKey)
	{
		this();
		this.targetRangeKey = targetRangeKey;
		this.creepSpeedKey = creepSpeedKey;
	}

	public CreepToObject(double targetRange, double creepSpeed)
	{
		this();
		this.targetRange = targetRange;
		this.creepSpeed = creepSpeed;
	}

	protected void initialize()
	{
		if (null != targetRangeKey)
		{
			targetRange = SmartDashboard.getNumber(targetRangeKey);
			creepSpeed = SmartDashboard.getNumber(creepSpeedKey);
		}
		Robot.quadEncoder.reset();
		Robot.gyroscope.reset();
	}

	protected void execute()
	{
		// Creep forwards or backward until at the desired range.
		currentRange = Robot.rangeFinder.getRange();
		twistCorrection = Robot.gyroscope.getTwistCorrection();
		
		if (currentRange > targetRange)
		{
			Robot.driveTrain.driveCartesian(creepSpeed, 0, twistCorrection, 0);			
		}
		else
		{ 
			Robot.driveTrain.driveCartesian(-creepSpeed, 0, twistCorrection, 0);
		}
	}

	protected boolean isFinished()
	{
		return Math.abs(Robot.rangeFinder.getRange() - targetRange) <= RobotMap.RECYCLE_BIN_ERROR_MARGIN || isTimedOut();
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
