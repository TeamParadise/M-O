/*
 * The Piston class is for getting and opening different pistons on the Robot.
 */

package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a generic piston subsystem.
 */
public class Piston extends Subsystem
{
	private final Solenoid solenoidOut;
	private final Solenoid solenoidIn;

	public Piston(int solenoidInPort, int solenoidOutPort)
	{
		this.solenoidIn = new Solenoid(RobotMap.pcmCanId, solenoidInPort);
		this.solenoidOut = new Solenoid(RobotMap.pcmCanId, solenoidOutPort);
	}

	public void extend()
	{
		solenoidIn.set(true);
		solenoidOut.set(false);
	}

	public void retract()
	{
		solenoidIn.set(false);
		solenoidOut.set(true);
	}

	public void idle()
	{
		solenoidIn.set(false);
		solenoidOut.set(false);
	}

	public Solenoid getInSolenoid()
	{
		return solenoidIn;
	}

	public Solenoid getOutSolenoid()
	{
		return solenoidOut;
	}

	protected void initDefaultCommand()
	{
	}
}
