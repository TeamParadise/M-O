package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.ToteLifterStops;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ReportToteLifterStopPositions extends Command
{
	private ToteLifterStops stops;

	public ReportToteLifterStopPositions(ToteLifterStops stops)
	{
		requires(stops);
		this.stops = stops;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		SmartDashboard.putNumber("Left Stop", stops.getLeftPosition());
		SmartDashboard.putNumber("Right Stop", stops.getRightPosition());
	}

	protected void initialize()
	{		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
