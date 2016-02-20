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

	// periodic
	protected void execute()
	{
		Robot.fourBar.wench.set(-0.4);
	}

	protected boolean isFinished()
	{
		if((timeSinceInitialized() > 2.0) || (Robot.fourBar.limitSwitch.get()))
		{
			Robot.fourBar.wench.setEncPosition(0);
			System.out.println("LIMIT HIT");
			Robot.fourBar.wench.set(0); // still in percentVBus
			Robot.hasBeenReset = true;
			Robot.fourBar.wench.changeControlMode(CANTalon.TalonControlMode.Position);
			Robot.fourBar.wench.setPID(0.135, 0.000015, 50.0);
			// 0.000125 oscillated a little bit, decently stable: (0.2, 0.00009375, 0.0);
			//(0.17, 0.0000234375, 0.1 - 
			//(0.15, 0.0000234375, 0.8); 
			//Robot.fourBar.wench.setPID(0.085, 0.000015, 128.0);
			
			Robot.fourBar.wench.enableControl();
			Robot.fourBar.wench.setSetpoint(200);
			Robot.fourBar.wench.setVoltageRampRate(8);
			Robot.fourBar.wench.configNominalOutputVoltage(+0f, -0f);
			Robot.fourBar.wench.configPeakOutputVoltage(+3f, -8f);
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

	protected void interrupted()
	{
		
	}
}
