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
				// Move until wall is hit
				System.out.println("case 1");
				addSequential(new Init());
				addSequential(new ResetFourBar());
				addSequential(new MoveForwardTime(2.0));
				break;
			
			case 2:
				System.out.println("case 2");
				//addSequential(new MoveForwardTime(2.0));
				break;
			
			case 3:
				System.out.println("case 3");
				break;
				
			case 4:
				System.out.println("case 4");
				break;
				
			case 5:
				System.out.println("case 5");
				break;
			
			default:
				System.out.println("default");
				break;
		}
	}
}
