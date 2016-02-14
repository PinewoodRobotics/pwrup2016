package org.usfirst.frc.team4765.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4765.robot.commands.Auton;
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
	// Static Instances of subsystems
	public static final Joystick joystick = new Joystick(0);
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final FourBar fourBar = new FourBar();
	public static final Intake intake = new Intake();
	
	public Command auton;
	

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
		oi = new OI(joystick);
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
		return 0;
	}
}
