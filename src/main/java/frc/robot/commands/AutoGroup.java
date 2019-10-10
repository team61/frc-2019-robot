package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup extends CommandGroup {
    public AutoGroup() {
        addSequential(new PunchArm()); // we want to punch out the arm once at the start of the match
    }
}
