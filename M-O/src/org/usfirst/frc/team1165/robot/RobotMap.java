package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    public static final double SONIC_TOTE_IN = 7.5;
    public static final double DRIVE_SPEED = 1;
    public static final double ROTATE_SPEED = 0.6;
    public static final double ROTATE_CREEP_SPEED = 0.6;
    public static final double SONIC_AT_STEP = 33.0;
    public static final double PICKUP_WHEELS_SPEED = 1;
    public static final double PICKUP_WHEELS_SPIN_OUT_TIME = 2;
    public static final double ROBOT_BACKUP_FROM_SCORING_PLATFORM = 30.0;    
    public static final double WAIT_BETWEEN_PNEUMATIC_ACTIONS = 0.5;    
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
    public static final int frontRightMotorChannel			= 3;
    public static final int rearLeftMotorChannel			= 2;
    public static final int rearRightMotorChannel			= 1;
    
    // Ultrasonic sensor
    public static final int ultrasonicPingChannel			= 0;
    public static final int ultrasonicEchoChannel			= 1;
    
    // Gyroscope
    public static final int gyroscopeChannel				= 0;

    // Joystick Ports
    public static final int joystickPort1					= 1;
    public static final int joystickPort2					= 2;
    
    // Encoder 
    public static final int encoderChannelA					= 2;
    public static final int encoderChannelB					= 3;
    
	public static final int leftServoChannel 				= 4;
	public static final int rightServoChannel				= 5;
	
    // BoxPickupWheels
	public static final int leftBoxPickupWheel				= 1;
	public static final int rightBoxPickupWheel     		= 0;
	
	public static final double leftServoEngagePosition 		= 0.72; 	//   130 / 180
	public static final double rightServoEngagePosition 	= 0.27; 	//    50 / 180
	public static final double leftServoDisengagePosition 	= 0.425;
	public static final double rightServoDisengagePosition 	= 0.5;
	
	// PCM and Solenoids
	public static final int pickupWheelPistonsInChannel		= 0;
	public static final int pickupWheelPistonsOutChannel	= 1;
	public static final int toteLifterPistonInChannel		= 2;
	public static final int toteLifterPistonOutChannel		= 3;
	
	// USB Camera Name
	public final static String cameraName = "cam0";

}
