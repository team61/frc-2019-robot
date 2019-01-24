package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftA extends CommandGroup {

    public AutoLeftA() {
    	addSequential(new DriveForDistance((110), .6, 5));
    	addSequential(new DriveForDistance((17), .2, 5));
    	addSequential(new TurnForDegrees(90, .25));
    	addSequential(new DriveForDistance(28, .6, 5));
    	addSequential(new lowerClaw());
    	addSequential(new openClaw()); // this automatically closes the claw for some reason
    	addParallel(new liftClaw());
    	System.out.println("DONE");
    }
}
