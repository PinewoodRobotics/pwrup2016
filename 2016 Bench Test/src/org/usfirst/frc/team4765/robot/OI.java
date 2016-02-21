package org.usfirst.frc.team4765.robot;

import org.usfirst.frc.team4765.robot.commands.CaptureBallAndRetract;
import org.usfirst.frc.team4765.robot.commands.ChangeToButtonControl;
import org.usfirst.frc.team4765.robot.commands.ChangeToManual;
import org.usfirst.frc.team4765.robot.commands.FourBarToFullyRetracted;
import org.usfirst.frc.team4765.robot.commands.FourBarToIntake;
import org.usfirst.frc.team4765.robot.commands.FourBarToLowBar;
import org.usfirst.frc.team4765.robot.commands.FourBarToLowest;
import org.usfirst.frc.team4765.robot.commands.FourBarToOpJoy;
import org.usfirst.frc.team4765.robot.commands.FourBarToThrottle;
import org.usfirst.frc.team4765.robot.commands.ResetFourBar;
import org.usfirst.frc.team4765.robot.commands.ejectBall;

import edu.wpi.first.wpilibj.GenericHID;
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
	JoystickButton fourBarResetBtn;
	JoystickButton fourBarToIntakeBtn;
	JoystickButton fourBarToThrottleBtn;
	
	JoystickButton fourBarToLowestBtn2;
	JoystickButton fourBarToLowBarBtn2;
	JoystickButton fourBarToFullyRetractedBtn2;
	JoystickButton fourBarResetBtn2;
	JoystickButton fourBarToIntakeBtn2;
	
	//JoystickButton changeFourBarModes;
	
	public OI(GenericHID... joysticks)
	{
		//moveForwardBtn = new JoystickButton(joysticks[0], 9);
		//moveForwardBtn.whenPressed(new MoveForward());
		
		//safeMoveForwardBtn = new JoystickButton(joysticks[0], 10);
		//safeMoveForwardBtn.whenPressed(new SafeMoveForward());
		
		
		fourBarResetBtn2    = new JoystickButton(joysticks[1], 9);
		fourBarToIntakeBtn2 = new JoystickButton(joysticks[1], 11);
		fourBarToLowestBtn2 = new JoystickButton(joysticks[1], 10);
		fourBarToLowBarBtn2 = new JoystickButton(joysticks[1], 12);
		fourBarToFullyRetractedBtn2 = new JoystickButton(joysticks[1], 8);
		
		fourBarToLowestBtn = new JoystickButton(joysticks[0], 10);
		fourBarToLowBarBtn = new JoystickButton(joysticks[0], 9);
		fourBarToIntakeBtn = new JoystickButton(joysticks[0], 7);
		fourBarResetBtn    = new JoystickButton(joysticks[0], 8);
		fourBarToFullyRetractedBtn = new JoystickButton(joysticks[0], 11);
		
		enableButtons();
		
		//changeFourBarModes = new JoystickButton(joysticks[1], 6);
		//changeFourBarModes.whenPressed(new ChangeToManual());
		//changeFourBarModes.whenReleased(new ChangeToButtonControl());
		
		
		Robot.trigger.whenPressed(new CaptureBallAndRetract());
		Robot.thumbBtn.whenPressed(new ejectBall());
		
	}
	
	public void disableButtons()
	{
		fourBarToLowestBtn.whenPressed(null);
		fourBarToLowBarBtn.whenPressed(null);
		fourBarToFullyRetractedBtn.whenPressed(null);
		fourBarResetBtn.whenPressed(null);
		fourBarToIntakeBtn.whenPressed(null);
		
		//fourBarToLowestBtn2.whenPressed(null);
		//fourBarToLowBarBtn2.whenPressed(null);
		//fourBarToFullyRetractedBtn2.whenPressed(null);
		//fourBarResetBtn2.whenPressed(null);
		//fourBarToIntakeBtn2.whenPressed(null);
	}
	
	public void enableButtons()
	{
		fourBarToLowestBtn.whenPressed(new FourBarToLowest());
		fourBarToLowBarBtn.whenPressed(new FourBarToLowBar());
		fourBarToFullyRetractedBtn.whenPressed(new FourBarToFullyRetracted());
		fourBarResetBtn.whenPressed(new ResetFourBar());
		fourBarToIntakeBtn.whenPressed(new FourBarToIntake());
		
		//fourBarToLowestBtn2.whenPressed(new FourBarToLowest());
		//fourBarToLowBarBtn2.whenPressed(new FourBarToLowBar());
		//fourBarToFullyRetractedBtn2.whenPressed(new FourBarToFullyRetracted());
		//fourBarResetBtn2.whenPressed(new ResetFourBar());
		//fourBarToIntakeBtn2.whenPressed(new FourBarToIntake());
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
