package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleRight extends CommandGroup {

    public AutoMiddleRight() {
    	
//    	addSequential(new DriveForDistance((60), .6));
//    	addSequential(new DriveForDistance((17), .2));
//    	addSequential(new TurnForDegrees(90, .25));
//    	addSequential(new DriveForDistance(100, .6));
//    	addSequential(new TurnForDegrees(-90, .25));
//    	addSequential(new DriveForDistance(60, .6));
//    	addSequential(new TurnForDegrees(-90, .25));
//    	addSequential(new DriveForDistance(28, .6));
//    	addSequential(new lowerClaw());
//    	addSequential(new openClaw()); // this automatically closes the claw for some reason
//    	addParallel(new liftClaw());
//    	System.out.println("DONE");
    	addSequential(new DriveForDistance(10, .6, 3));
    	addSequential(new TurnForDegrees(20, .25));
    	addSequential(new DriveForDistance(10.5*12, .6, 4));
    	addSequential(new lowerClaw());
    	addSequential(new openClaw()); // this automatically closes the claw for some reason
    	addParallel(new liftClaw());
    	System.out.println("DONE");
    	
    }
}
