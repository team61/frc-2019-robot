package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveFrontAndRear extends CommandGroup {
    public MoveFrontAndRear(int destination) {
        addParallel(new MoveFront(destination));
        addParallel(new MoveRear(destination));
    }
}
