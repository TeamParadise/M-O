package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisengageToteLifterStops extends Command {

    public DisengageToteLifterStops() {
        requires(Robot.leftServoMotor);
        requires(Robot.rightServoMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       	Robot.rightServoMotor.setPosition(RobotMap.rightServoDisengagePosition);
    	Robot.leftServoMotor.setPosition(RobotMap.leftServoDisengagePosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
