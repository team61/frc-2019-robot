package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowerFrontAndRearGroup extends CommandGroup {
    public LowerFrontAndRearGroup() {
        addSequential(new LowerFrontAndRearSixInch());
        addSequential(new LowerFrontAndRearNineteenInch());
    }
}
