package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ingestBall extends Command
{

	public ingestBall()
	{
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println(this.getClass().getName());
		System.out.println(System.currentTimeMillis());
		Robot.intake.intakeMotor.set(0.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.intake.intakeMotor.set(-0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return !Robot.trigger.get();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.intake.intakeMotor.set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
