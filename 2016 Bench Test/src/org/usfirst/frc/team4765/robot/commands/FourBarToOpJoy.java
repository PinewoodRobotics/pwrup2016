package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FourBarToOpJoy extends Command
{

	public FourBarToOpJoy()
	{
		requires(Robot.fourBar);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		//System.out.println(this.getClass().getName());
		//System.out.println(System.currentTimeMillis());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if(Robot.hasBeenReset && Robot.oi.changeFourBarModes.get())
		{
			Robot.fourBar.winch.setSetpoint((Robot.panelJoy.getY() + 1) / 2 * 15400);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
