/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc.team1165.robot.commands.piston;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.subsystems.Piston;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Common base class for all commands that operate a piston.
 * 
 * The timeout is used to determine how long the solenoid should
 * be activated. Subclasses should NOT set or change the timeout.
 */
public abstract class PistonCommand extends Command
{
    /** Piston subsystems */
    public static Piston pickupWheelPistons =
        new Piston(RobotMap.pickupWheelPistonsInChannel, RobotMap.pickupWheelPistonsOutChannel);
    
    public static Piston toteLifterPiston = new Piston(RobotMap.toteLifterPistonHighInChannel, RobotMap.toteLifterPistonHighOutChannel);
    public static Piston toteLowerLifterPiston = new Piston(RobotMap.toteLifterPistonLowInChannelController, RobotMap.toteLifterPistonLowOutChannelController);
    private final boolean isExtending;
    private final Piston piston;
    private final Piston controller2; //if not null, we have two controllers on one piston to save air
	
	final static boolean extend = true;
	final static boolean retract = false;
	
	final static double powerOnTime = 0.05; // 50 milliseconds
    
    public PistonCommand(Piston piston, boolean isExtending)
	{
		super(powerOnTime);
		requires(piston);
        this.piston = piston;
        this.isExtending = isExtending;
        controller2 = null;
    }

    public PistonCommand(Piston piston, Piston controller2, boolean isExtending)
	{
		super(powerOnTime);
		requires(piston);
        this.piston = piston;
        this.isExtending = isExtending;
        this.controller2 = controller2;
    }

    protected void initialize() 
    {
        if (isExtending) 
        {
            piston.extend();
            if (controller2 != null)
            	controller2.extend();
        }
		else 
        {
            piston.retract();
            if (controller2 != null)
            	controller2.retract();
        }
    }

    protected void execute() 
    {
    }

    protected boolean isFinished() 
    {
        return this.isTimedOut();
    }

    protected void end() 
    {
		idle();
    }

    protected void interrupted() 
    {
		idle();
    }
    
	private void idle()
	{
		// TODO: Uncomment if want to idle the piston when the command is finished or interrupted.
		piston.idle();
	}
}
