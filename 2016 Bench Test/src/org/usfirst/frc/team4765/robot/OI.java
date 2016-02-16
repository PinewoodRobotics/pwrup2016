package org.usfirst.frc.team4765.robot;

import org.usfirst.frc.team4765.robot.commands.FourBarToFullyRetracted;
import org.usfirst.frc.team4765.robot.commands.FourBarToLowBar;
import org.usfirst.frc.team4765.robot.commands.FourBarToLowest;
import org.usfirst.frc.team4765.robot.commands.MoveForward;
import org.usfirst.frc.team4765.robot.commands.SafeMoveForward;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	//JoystickButton moveForwardBtn;
	//JoystickButton safeMoveForwardBtn;
	JoystickButton fourBarToLowestBtn;
	JoystickButton fourBarToLowBarBtn;
	JoystickButton fourBarToFullyRetractedBtn;
	
	public OI(GenericHID... joysticks)
	{
		//moveForwardBtn = new JoystickButton(joysticks[0], 9);
		//moveForwardBtn.whenPressed(new MoveForward());
		
		//safeMoveForwardBtn = new JoystickButton(joysticks[0], 10);
		//safeMoveForwardBtn.whenPressed(new SafeMoveForward());
		
		fourBarToLowestBtn = new JoystickButton(joysticks[1], 1);
		fourBarToLowestBtn.whenPressed(new FourBarToLowest());
		
		fourBarToLowBarBtn = new JoystickButton(joysticks[1], 2);
		fourBarToLowBarBtn.whenPressed(new FourBarToLowBar());
		
		fourBarToFullyRetractedBtn = new JoystickButton(joysticks[1], 3);
		fourBarToFullyRetractedBtn.whenPressed(new FourBarToFullyRetracted());
		
	}
	 
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
