package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightA extends CommandGroup {

    public AutoRightA() {
    	addSequential(new DriveForDistance((110), .6, 5));
    	addSequential(new DriveForDistance((17), .2, 5));
    	addSequential(new TurnForDegrees(-84, .25));
    	addSequential(new DriveForDistance(28, .6, 5));
    	addSequential(new lowerClaw());
    	addSequential(new openClaw()); // this automatically closes the claw for some reason
    	addParallel(new liftClaw());
    	System.out.println("DONE");
    }
}
