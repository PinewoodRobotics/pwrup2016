package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetFourBar extends Command
{

	public ResetFourBar()
	{
		requires(Robot.fourBar);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.fourBar.wench.setControlMode(0); // percentVBus
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.fourBar.wench.set(-0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if(Robot.fourBar.limitSwitch.get())
		{
			Robot.fourBar.wench.set(0); // still in percentVBus
			Robot.fourBar.wench.reset();
			Robot.fourBar.wench.setControlMode(1); // position
			Robot.fourBar.wench.setSetpoint(0);
			return true;
		}
		else
			return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}
	
	public boolean isInterruptible()
	{
		return false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
	}
}
