package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
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
		Robot.fourBar.wench.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		Robot.fourBar.wench.set(-0.4);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		if(Robot.fourBar.limitSwitch.get())
		{
			Robot.fourBar.wench.setEncPosition(0);
			System.out.println("LIMIT HIT");
			Robot.fourBar.wench.set(0); // still in percentVBus
			System.out.println("before reset: " + Robot.fourBar.wench.getSetpoint());
			Robot.hasBeenReset = true;
			Robot.fourBar.wench.changeControlMode(CANTalon.TalonControlMode.Position);
			Robot.fourBar.wench.setPID(0.2, 0, 0);   
			Robot.fourBar.wench.enableControl();
			Robot.fourBar.wench.setSetpoint(200);
			System.out.println("after reset: " + Robot.fourBar.wench.getSetpoint());
			return true;
		}
		else
			return false;
	}
	
	// ball intake position: ~8500 

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
