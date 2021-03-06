package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FourBarToFullyRetracted extends Command
{

	public FourBarToFullyRetracted()
	{
		requires(Robot.fourBar);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println(this.getClass().getName());
		System.out.println(System.currentTimeMillis());
		Robot.fourBar.winch.set(200);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return (true); // || Robot.fourBar.limitSwitch.get());
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
