package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TogglePickupWheels extends Command
{
	private boolean isTurning = false;
	private Button button;
	private boolean hasButtonBeenReleased;

	public TogglePickupWheels(Button button)
	{
		requires(Robot.boxPickupWheels);
		this.button = button;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.boxPickupWheels.spinIn(1.0);
		isTurning = true;
		hasButtonBeenReleased = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (!hasButtonBeenReleased)
		{
			hasButtonBeenReleased = !button.get();
		}
		
		if (hasButtonBeenReleased && button.get())
		{
			isTurning = false;
		}		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return !isTurning;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.boxPickupWheels.idle();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
