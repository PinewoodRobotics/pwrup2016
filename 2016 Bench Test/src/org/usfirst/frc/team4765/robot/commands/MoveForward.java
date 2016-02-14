package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;
import org.usfirst.frc.team4765.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveForward extends Command
{
	Timer driveTime = new Timer();
	
	public MoveForward()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		driveTime.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if(Robot.joystick.getThrottle() != 10000)
			System.out.println("throttle > 0");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if(driveTime.get() > 1.0)
		{
			driveTime.stop();
			return true;
		}
		else
		{
			return false;
		}
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
		driveTime.stop();
		end();
	}
}
