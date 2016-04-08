package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetIntakeMotor extends Command
{
	double power_;
	
	public SetIntakeMotor(double power)
	{
		power_ = power;
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		System.out.println(this.getClass().getName());
		System.out.println(System.currentTimeMillis());
		System.out.println("intake motor set to " + power_);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		
		Robot.intake.intakeMotor.set(power_);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
