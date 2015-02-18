package org.usfirst.frc.team1165.robot;
 
import org.usfirst.frc.team1165.robot.commands.DisengageToteLifterStops;
import org.usfirst.frc.team1165.robot.commands.DriveHalfCircle;
import org.usfirst.frc.team1165.robot.commands.DriveStraight;
import org.usfirst.frc.team1165.robot.commands.DriveStraightDistance;
import org.usfirst.frc.team1165.robot.commands.DriveToObject;
import org.usfirst.frc.team1165.robot.commands.EngageToteLifterStops;
import org.usfirst.frc.team1165.robot.commands.ExcreteOnScoringPlatform;
import org.usfirst.frc.team1165.robot.commands.ExcreteOnStep;
import org.usfirst.frc.team1165.robot.commands.PickupTote;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinIn;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinLeft;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinOut;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsSpinRight;
import org.usfirst.frc.team1165.robot.commands.PickupWheelsStop;
import org.usfirst.frc.team1165.robot.commands.ResetEncoder;
import org.usfirst.frc.team1165.robot.commands.ResetGyro;
import org.usfirst.frc.team1165.robot.commands.RotateToHeading;
import org.usfirst.frc.team1165.robot.commands.TogglePickupWheels;
import org.usfirst.frc.team1165.robot.commands.piston.LiftTotes;
import org.usfirst.frc.team1165.robot.commands.piston.LowerTotes;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsIn;
import org.usfirst.frc.team1165.robot.commands.piston.MovePickupWheelsOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	private final Joystick mainJoystick = new Joystick(RobotMap.joystickPort1);
	private final Joystick secondaryJoystick = new Joystick(RobotMap.joystickPort2);

    private final Button secondaryButton1 = new JoystickButton(secondaryJoystick, 1);
    private final Button secondaryButton2 = new JoystickButton(secondaryJoystick, 2);
    private final Button secondaryButton3 = new JoystickButton(secondaryJoystick, 3);
    private final Button secondaryButton4 = new JoystickButton(secondaryJoystick, 4);
    private final Button secondaryButton5 = new JoystickButton(secondaryJoystick, 5);
    private final Button secondaryButton6 = new JoystickButton(secondaryJoystick, 6);
    private final Button secondaryButton7 = new JoystickButton(secondaryJoystick, 7);
    private final Button secondaryButton8 = new JoystickButton(secondaryJoystick, 8);
    private final Button secondaryButton9 = new JoystickButton(secondaryJoystick, 9);
    private final Button secondaryButton10 = new JoystickButton(secondaryJoystick, 10);
    private final Button secondaryButton11 = new JoystickButton(secondaryJoystick, 11);
    private final Button secondaryButton12 = new JoystickButton(secondaryJoystick, 12);
    
    
	public OI()
	{
		// Smart dashbaord numbers
		SmartDashboard.putNumber("Dampening", .9);
	
		SmartDashboard.putNumber("Forward Speed", 0.3);

		SmartDashboard.putNumber("Drive Inches", 10);

		SmartDashboard.putNumber("Target Range", 19);
		SmartDashboard.putNumber("Brake Range", 50);
		SmartDashboard.putNumber("Creep Speed", .2);

		SmartDashboard.putNumber("Target Heading", 45);
		SmartDashboard.putNumber("Brake Heading", 10);
		SmartDashboard.putNumber("Rotate Magnitude", .4);
		SmartDashboard.putNumber("Creep Magnitude", .2);

		// Smart dashboard buttons
		SmartDashboard.putData(new DriveStraightDistance("Forward Speed", "Drive Inches"));
		SmartDashboard.putData(new DriveStraight("Forward Speed", 1));
		SmartDashboard.putData(new DriveToObject("Forward Speed", "Brake Range", "Target Range", "Creep Speed"));
		SmartDashboard.putData(new DriveHalfCircle("Forward Speed"));
		SmartDashboard.putData(new RotateToHeading("Rotate Magnitude", "Brake Heading", "Target Heading", "Creep Magnitude"));

		SmartDashboard.putData(new PickupWheelsStop());
		SmartDashboard.putData(new PickupWheelsSpinIn(RobotMap.PICKUP_WHEELS_SPEED, 1 , false));
		SmartDashboard.putData(new PickupWheelsSpinOut());
		SmartDashboard.putData(new PickupWheelsSpinRight());
		SmartDashboard.putData(new PickupWheelsSpinLeft());
		
		SmartDashboard.putData(new LiftTotes());
		SmartDashboard.putData(new LowerTotes());
		
		SmartDashboard.putData(new MovePickupWheelsIn());
		SmartDashboard.putData(new MovePickupWheelsOut());
		
		SmartDashboard.putData(new EngageToteLifterStops());
		SmartDashboard.putData(new DisengageToteLifterStops());
		
		SmartDashboard.putData(new PickupTote());
		
		SmartDashboard.putData(new ExcreteOnScoringPlatform());
		SmartDashboard.putData(new ExcreteOnStep());

		SmartDashboard.putData(new ResetGyro());
		SmartDashboard.putData(new ResetEncoder());
		
		// Joystick button mapping
		secondaryButton1.whenPressed(new PickupTote());

		secondaryButton2.whenPressed(new TogglePickupWheels(secondaryButton2));
		
		secondaryButton3.whenPressed(new EngageToteLifterStops());
		secondaryButton5.whenPressed(new DisengageToteLifterStops());
		
		secondaryButton4.whenPressed(new MovePickupWheelsIn());
		secondaryButton6.whenPressed(new MovePickupWheelsOut());
		
		secondaryButton7.whenPressed(new LowerTotes());
		secondaryButton8.whenPressed(new LiftTotes());

		secondaryButton10.whenPressed(new ExcreteOnStep());
		secondaryButton11.whenPressed(new ExcreteOnScoringPlatform());
	}

	public double getDampening()
	{
		return SmartDashboard.getNumber("Dampening");
	}

	public double getDriveX()
	{
		return -mainJoystick.getY();
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
