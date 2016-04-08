package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForwardThrottleTime extends Command
{
	double duration_; // time we drive forward for
	double power_;
	
	public MoveForwardThrottleTime(double throttle, double duration)
	{
		requires(Robot.driveTrain);
		duration_ = duration;
		power_ = (throttle + 1) / 2;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.driveTrain.motor1.set(power_);
		Robot.driveTrain.motor3.set(power_);
		
		Robot.driveTrain.motor2.set(-power_);
		Robot.driveTrain.motor4.set(-power_);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return timeSinceInitialized() > duration_;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		System.out.println("Finished MovingForward");
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
