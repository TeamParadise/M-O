package org.usfirst.frc.team1165.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem
{
	private RobotDrive robotDrive;

	public DriveTrain()
	{
		robotDrive = new RobotDrive(
				new CANTalon(RobotMap.frontLeftMotorChannel),
				new CANTalon(RobotMap.frontRightMotorChannel),
				new CANTalon(RobotMap.rearLeftMotorChannel),
				new CANTalon(RobotMap.rearRightMotorChannel));

		// Invert the left side motors
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		robotDrive.setExpiration(0.1);
	}

	public void driveCartesian(double x, double y, double twist, double gyroAngle)
	{
		robotDrive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}
}
