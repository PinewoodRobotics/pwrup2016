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
import org.usfirst.frc.team4765.robot.commands.MoveForward;
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
	
	public static final JoystickButton panelBtn7  = new JoystickButton(panelJoy, 7);
	public static final JoystickButton panelBtn8  = new JoystickButton(panelJoy, 8);
	public static final JoystickButton panelBtn9  = new JoystickButton(panelJoy, 9);
	public static final JoystickButton panelBtn10 = new JoystickButton(panelJoy, 10);
	public static final JoystickButton panelBtn11 = new JoystickButton(panelJoy, 11);
	public static final JoystickButton panelBtn12 = new JoystickButton(panelJoy, 12);
	
	public Command auton;
	public Command init;

	// Secondary handlers
	public static OI oi;
	
	@Override
	public void autonomousInit()
	{
		auton = new Auton(readAutonConfig());
		Scheduler.getInstance().add(auton);
		
		System.out.println(joystick.getThrottle());
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
		//System.out.println("teleop");
	}

	@Override
	public void testPeriodic()
	{
		LiveWindow.run();
	}
	
	public int readAutonConfig()
	{
		if(panelBtn7.get())
			return 7;
		else if(panelBtn8.get())
			return 8;
		else if(panelBtn9.get())
			return 9;
		else if(panelBtn10.get())
			return 10;
		else if(panelBtn11.get())
			return 11;
		else if(panelBtn12.get())
			return 12;
		else
			return 0;
	}
}
