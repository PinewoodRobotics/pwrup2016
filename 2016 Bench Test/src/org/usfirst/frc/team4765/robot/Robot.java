package org.usfirst.frc.team4765.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4765.robot.commands.Auton;
import org.usfirst.frc.team4765.robot.commands.Init;
import org.usfirst.frc.team4765.robot.commands.MoveBackward;
import org.usfirst.frc.team4765.robot.commands.MoveForwardThrottleTime;
import org.usfirst.frc.team4765.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4765.robot.subsystems.FourBar;
import org.usfirst.frc.team4765.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	// TODO: delete this comment
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final FourBar fourBar = new FourBar();
	public static final Intake intake = new Intake();
	
	public static final Joystick joystick = new Joystick(0);
	public static final Joystick panelJoy = new Joystick(1);
	
	public static final JoystickButton trigger = new JoystickButton(joystick, 1);
	public static final JoystickButton thumbBtn = new JoystickButton(joystick, 2);
	
	public static final JoystickButton panelKnob1 = new JoystickButton(panelJoy, 1);
	public static final JoystickButton panelKnob2 = new JoystickButton(panelJoy, 2);
	public static final JoystickButton panelKnob3 = new JoystickButton(panelJoy, 3);
	public static final JoystickButton panelKnob4 = new JoystickButton(panelJoy, 4);
	public static final JoystickButton panelKnob5 = new JoystickButton(panelJoy, 5);
	
	public static boolean hasBeenReset = false;
	public Command auton;
	public Command init;
	
	public static int intakeEncPos = 9750;
	public static int lowBarEncPos = 5750;
	public static int chevalEncPos = 13970;
	public static int capturedBallEncPos = 4900;
	public static int fullyRetractedEncPos = 200;
	
	// 660, should be 200
	

	// Secondary handlers
	public static OI oi;
	
	@Override
	public void autonomousInit()
	{
		auton = new Auton(readAutonConfig());
		Scheduler.getInstance().add(auton);
		
		//System.out.println(joystick.getThrottle());
	}

	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void robotInit()
	{
		init = new Init();
		Scheduler.getInstance().add(init);
		oi = new OI(joystick, panelJoy);
	}

	@Override
	public void teleopInit()
	{
	}

	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
		//System.out.println(Robot.fourBar.wench.getEncPosition());
		//System.out.println("intake current: " + Robot.intake.intakeMotor.getOutputCurrent());
		System.out.println("throttle: " + Robot.joystick.getThrottle());
	}

	@Override
	public void testPeriodic()
	{
		LiveWindow.run();
	}
	
	public int readAutonConfig()
	{
		if(panelKnob1.get())
			return 1;
		else if(panelKnob2.get())
			return 2;
		else if(panelKnob3.get())
			return 3;
		else if(panelKnob4.get())
			return 4;
		else if(panelKnob5.get())
			return 5;
		else
			return 0;
	}
}
