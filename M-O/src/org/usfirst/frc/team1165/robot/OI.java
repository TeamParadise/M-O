package org.usfirst.frc.team1165.robot;
 
import org.usfirst.frc.team1165.robot.commands.DriveStraight;
import org.usfirst.frc.team1165.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1165.robot.commands.DriveToObject;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinIn;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinLeft;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinOut;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinRight;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsStop;
import org.usfirst.frc.team1165.robot.commands.ResetEncoder;
import org.usfirst.frc.team1165.robot.commands.ResetGyro;
import org.usfirst.frc.team1165.robot.commands.RotateToHeading;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotes;
import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	private final Joystick mainJoystick = new Joystick(RobotMap.joystickPort1);
	private final Joystick secondaryJoystick = new Joystick(RobotMap.joystickPort2);

	public OI()
	{
		SmartDashboard.putNumber("Dampening", .9);
	
		SmartDashboard.putNumber("Forward Speed", -1);
		SmartDashboard.putData(new DriveStraight("Forward Speed", 0.5));

		SmartDashboard.putNumber("Drive Inches", 53);
		SmartDashboard.putData(new DriveStraightDistance("Forward Speed", "Drive Inches"));

		SmartDashboard.putNumber("Target Range", 19);
		SmartDashboard.putNumber("Brake Range", 50);
		SmartDashboard.putNumber("Creep Speed", -.2);
		SmartDashboard.putData(new DriveToObject("Forward Speed", "Brake Range", "Target Range", "Creep Speed"));

		SmartDashboard.putNumber("Target Heading", 45);
		SmartDashboard.putNumber("Brake Heading", 10);
		SmartDashboard.putNumber("Rotate Magnitude", .4);
		SmartDashboard.putNumber("Creep Magnitude", .2);
		SmartDashboard.putData(new RotateToHeading("Rotate Magnitude", "Brake Heading", "Target Heading",
				"Creep Magnitude"));
		
		SmartDashboard.putData(new PickupWheelsStop());
		SmartDashboard.putData(new PickupWheelsSpinIn());
		SmartDashboard.putData(new PickupWheelsSpinOut());
		SmartDashboard.putData(new PickupWheelsSpinRight());
		SmartDashboard.putData(new PickupWheelsSpinLeft());
		
		SmartDashboard.putData(new LiftTotes());
		SmartDashboard.putData(new LowerTotes());
		SmartDashboard.putData(new MovePickupWheelsIn());
		SmartDashboard.putData(new MovePickupWheelsOut());

		SmartDashboard.putData(new ResetGyro());
		SmartDashboard.putData(new ResetEncoder());
	}

	public double getDampening()
	{
		return SmartDashboard.getNumber("Dampening");
	}

	public double getDriveX()
	{
		return mainJoystick.getY();
	}

	public double getDriveY()
	{
		return mainJoystick.getX();
	}

	public double getDriveTwist()
	{
		return mainJoystick.getTwist();
	}
	
	public double boxPickupSpeedX()
	{
		return secondaryJoystick.getX();
	}

	public double boxPickupSpeedY()
	{
		// Pushing forward on the joystick returns negative y values.
		// We want the reverse of that.
		return -secondaryJoystick.getY();
	}
	
	public double twistAngle()
	{
		return secondaryJoystick.getTwist();
	}
}
