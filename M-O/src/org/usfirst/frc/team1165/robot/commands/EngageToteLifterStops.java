package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EngageToteLifterStops extends Command {

    public EngageToteLifterStops() {
        requires(Robot.leftServoMotor);
        requires(Robot.rightServoMotor);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rightServoMotor.setPosition(RobotMap.rightServoEngagePosition);
    	Robot.leftServoMotor.setPosition(RobotMap.leftServoEngagePosition);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
