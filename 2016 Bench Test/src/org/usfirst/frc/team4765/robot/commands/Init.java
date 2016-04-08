package org.usfirst.frc.team4765.robot.commands;

import org.usfirst.frc.team4765.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Init extends Command
{

	public Init()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		requires(Robot.fourBar);
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		//Robot.driveTrain.motor1.setFeedbackDevice(null);
		//Robot.driveTrain.motor2.setFeedbackDevice(null);
		//Robot.driveTrain.motor3.setFeedbackDevice(null);
		//Robot.driveTrain.motor4.setFeedbackDevice(null);
		
		//Robot.intake.intakeMotor.setFeedbackDevice(null);
		
		//Robot.fourBar.wench.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		//Robot.fourBar.wench.setControlMode(1); // position
		Robot.fourBar.winch.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		Robot.fourBar.winch.set(0);
		Robot.fourBar.winch.disableControl();
		
		Robot.driveTrain.motor1.setControlMode(0);
		Robot.driveTrain.motor2.setControlMode(0);
		
		Robot.driveTrain.motor3.setControlMode(0);
		Robot.driveTrain.motor4.setControlMode(0);
		
		//Robot.driveTrain.motor3.set(1);
		//Robot.driveTrain.motor3.enableControl();
		
		//Robot.driveTrain.motor4.set(2);
		//Robot.driveTrain.motor4.enableControl();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
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
