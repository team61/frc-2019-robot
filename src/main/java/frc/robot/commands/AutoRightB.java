package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightB extends CommandGroup {
    public AutoRightB() {
    	addSequential(new DriveForDistance(195, .8, 10));
    	addSequential(new DriveForDistance(10, .3, 5));
    }
}
