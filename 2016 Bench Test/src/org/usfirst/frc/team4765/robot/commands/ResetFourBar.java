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
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.fourBar.winch.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.intake.intakeMotor.set(0);
		Robot.fourBar.winch.set(-0.4);
	}

	// periodic
	protected void execute()
	{
	}

	protected boolean isFinished()
	{
		if((timeSinceInitialized() > 2.0) || (Robot.fourBar.limitSwitch.get()))
		{
			Robot.fourBar.winch.setEncPosition(0);
			System.out.println("LIMIT HIT");
			Robot.fourBar.winch.set(0); // still in percentVBus
			Robot.hasBeenReset = true;
			Robot.fourBar.winch.changeControlMode(CANTalon.TalonControlMode.Position);
			Robot.fourBar.winch.setPID(0.135, 0.000015, 50.0);
			// 0.000125 oscillated a little bit, decently stable: (0.2, 0.00009375, 0.0);
			//(0.17, 0.0000234375, 0.1 - 
			//(0.15, 0.0000234375, 0.8); 
			//Robot.fourBar.wench.setPID(0.085, 0.000015, 128.0);
			
			Robot.fourBar.winch.enableControl();
			Robot.fourBar.winch.setSetpoint(200);
			Robot.fourBar.winch.setVoltageRampRate(8);
			Robot.fourBar.winch.configNominalOutputVoltage(+0f, -0f);
			Robot.fourBar.winch.configPeakOutputVoltage(+3f, -8f);
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
