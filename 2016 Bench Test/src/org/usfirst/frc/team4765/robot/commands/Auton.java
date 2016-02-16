package org.usfirst.frc.team4765.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton extends CommandGroup
{

	public Auton(int setting)
	{
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		switch (setting)
		{
			case 0:
				System.out.println("0");
				break;
			
			case 1:
				System.out.println("case 1");
				break;
			
			case 7:
				System.out.println("case 7");
				break;
			
			case 8:
				System.out.println("case 8");
				break;
				
			case 9:
				System.out.println("case 9");
				break;
				
			case 10:
				System.out.println("case 10");
				break;
				
			case 11:
				System.out.println("case 11");
				break;
				
			case 12:
				System.out.println("case 12");
				break;
			
			default:
				System.out.println("default");
				break;
		}
	}
}
