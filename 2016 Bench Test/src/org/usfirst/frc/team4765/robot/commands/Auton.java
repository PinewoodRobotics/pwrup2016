package org.usfirst.frc.team4765.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
		addSequential(new ResetFourBar());
		switch (setting)
		{
			case 1:
				System.out.println("case 1 DO NOTHING");
				break;
			
			case 2:
				// Move until wall is hit
				System.out.println("case 2 MOVE A BIT");
				addSequential(new MoveForwardThrottleTime(0.1, 0.5));
				break;
			
			case 3: 
				//RAMP ART, MOAT
				System.out.println("case 3 RAMP ART, MOAT");
				addSequential(new MoveForwardThrottleTime(0.3937, 3.0));
				break;
			
			case 4:
				// ROCK WALL
				System.out.println("case 4 ROCK WALL");
				addSequential(new MoveForwardThrottleTime(0.55, 3.0));
				break;
				
			case 5:
				// LOW BAR
				System.out.println("case 5 LOW BAR");
				addSequential(new FourBarToLowBar());
				addSequential(new WaitCommand(2));
				addSequential(new MoveForwardThrottleTime(0.102, 3.0));
				break;
			
			default:
				System.out.println("default");
				break;
		}
	}
}
