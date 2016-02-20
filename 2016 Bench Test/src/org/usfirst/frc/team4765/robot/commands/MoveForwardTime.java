package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForwardTime extends Command
{
	double duration; // time we drive forward for
	
	public MoveForwardTime(double inputDuration)
	{
		requires(Robot.driveTrain);
		duration = inputDuration;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveTrain.motor1.set(0.0);
		Robot.driveTrain.motor2.set(0.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.driveTrain.motor1.set(0.3);
		Robot.driveTrain.motor2.set(0.3);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return timeSinceInitialized() > duration;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
