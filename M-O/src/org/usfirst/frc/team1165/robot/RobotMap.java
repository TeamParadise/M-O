package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    
    // Wheel motors: Digital I/O PWM
    public static final int frontLeftMotorChannel			= 0;
    public static final int frontRightMotorChannel			= 1;
    public static final int rearLeftMotorChannel			= 2;
    public static final int rearRightMotorChannel			= 3;
    
    // Ultrasonic sensor
    public static final int ultrasonicPingChannel			= 0;
    public static final int ultrasonicEchoChannel			= 1;
    
    // Gyroscope
    public static final int gyroscopeChannel				= 0;

    // Joystick Ports
    public static final int joystickPort1					= 1;
    public static final int joystickPort2					= 2;
    
    // Encoder 
    public static final int encoderChannelA					= 8;
    public static final int encoderChannelB					= 9;
    
	public static final int leftServoMotorChannel 			= 4;
	public static final int rightServoMotorChannel			= 5;
	
    // BoxPickupWheels
	public static final int leftBoxPickupWheel				= 8;
	public static final int rightBoxPickupWheel     		= 9;
	
	public static final double leftServoEngagePosition 		= 1.0;
	public static final double rightServoEngagePosition 	= 1.0;
	public static final double leftServoDisengagePosition 	= 0.5;
	public static final double rightServoDisengagePosition 	= 0.5;
	
	// PCM and Solenoids
	public static final int pcmCanId						= 10;
	public static final int pickupWheelPistonsInChannel		= 0;
	public static final int pickupWheelPistonsOutChannel	= 1;
	public static final int toteLifterPistonInChannel		= 2;
	public static final int toteLifterPistonOutChannel		= 3;
	
	// USB Camera Name
	public final static String cameraName = "cam11";

}
