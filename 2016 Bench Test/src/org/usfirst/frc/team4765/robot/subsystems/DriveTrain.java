package org.usfirst.frc.team4765.robot.subsystems;

import org.usfirst.frc.team4765.robot.Robot;
import org.usfirst.frc.team4765.robot.commands.Drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	// odds on the left, evens are on the right 
	public CANTalon motor1 = new CANTalon(1); // front left, leader
	public CANTalon motor2 = new CANTalon(2); // front right, leader
	public CANTalon motor3 = new CANTalon(3); // rear left, follower
	public CANTalon motor4 = new CANTalon(4); // rear right, follower

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

		setDefaultCommand(new Drive());
	}
	// roborio in usb
	// attach CAN bus
	/**
	 * Limit motor values to the -1.0 to +1.0 range.
	 */
	protected static double limit(double num)
	{
		if (num > 1.0)
		{
			return 1.0;
		}
		if (num < -1.0)
		{
			return -1.0;
		}
		return num;
	}

	/**
	 * @param moveValue - going to be joystick.getY()
	 * @param rotateValue - going to be joystick.getZ()
	 * @return
	 */
	public double[] arcadeDriveMath(double moveValue, double rotateValue)
	{
		double leftMotorSpeed;
		double rightMotorSpeed;

		moveValue = limit(moveValue);
		rotateValue = limit(rotateValue);

		if (moveValue > 0.0)
		{
			if (rotateValue > 0.0)
			{
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} 
			else
			{
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} 
		else
		{
			if (rotateValue > 0.0)
			{
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} 
			else
			{
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}
		return new double[]{leftMotorSpeed, rightMotorSpeed};
	}

	public void move()
	{
		double throttle = (Robot.joystick.getThrottle() + 1.0) / 2.0;
		double[] motorSpeeds = arcadeDriveMath(Robot.joystick.getZ(), Robot.joystick.getY());
		double leftMotorSpeed = motorSpeeds[0];
		double rightMotorSpeed = motorSpeeds[1];
		
		motor1.set(leftMotorSpeed * throttle);
		motor2.set(rightMotorSpeed * throttle);
	}

	public void stop()
	{
		motor1.set(0);
		motor2.set(0);
	}
}