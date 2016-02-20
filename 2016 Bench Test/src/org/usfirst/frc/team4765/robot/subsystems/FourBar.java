package org.usfirst.frc.team4765.robot.subsystems;

import org.usfirst.frc.team4765.robot.Robot;
import org.usfirst.frc.team4765.robot.commands.FourBarToOpJoy;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FourBar extends Subsystem
{
	public CANTalon wench = new CANTalon(5);
	
	public DigitalInput limitSwitch = new DigitalInput(1);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void enableManual()
	{
		setDefaultCommand(new FourBarToOpJoy());
		Robot.oi.disableButtons();
	}
	
	public void disableManual()
	{
		setDefaultCommand(null);
		Robot.oi.enableButtons();
	}
}
