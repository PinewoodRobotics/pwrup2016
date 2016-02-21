package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FourBarToLowBar extends Command
{

	public FourBarToLowBar()
	{
		requires(Robot.fourBar);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println("executing FourBarToLowBar");
		Robot.fourBar.winch.set(Robot.lowBarEncPos);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		// TODO: write this
	}
	
	public boolean isInterruptible()
	{
		return true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
