package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ReportEncoder;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class QuadEncoder extends Subsystem {
	
	private Encoder encoder;
	double distancePerTick = Math.PI/12;
    
	public QuadEncoder()
	{
		encoder = new Encoder(RobotMap.encoderChannelA, RobotMap.encoderChannelB, false, EncodingType.k4X );
		reset();
	}

    public void initDefaultCommand() 
    {
        setDefaultCommand(new ReportEncoder());
    }
    
    public void report()
    {
    	SmartDashboard.putNumber("Encoder Distance", getInches());
    	SmartDashboard.putNumber("Encoder Ticks", encoder.get());
    }
    
    public double getInches()
    {
    	return distancePerTick*getTicks();
    }
    
    public double getStrafeInches() 
    {
    	double strafePerTick = distancePerTick/3;
    	return strafePerTick*getTicks();
    }
    
    public double getTicks() 
    {
    	return encoder.get();
    }
    
    public void reset()
    {
    	encoder.reset();
    }
}
