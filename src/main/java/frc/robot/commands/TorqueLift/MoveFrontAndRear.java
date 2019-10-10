package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveFrontAndRear extends CommandGroup {
    public MoveFrontAndRear(int Level, double Speed) {
        addParallel(new MoveFront(Level, Speed));
        addParallel(new MoveRear(Level, Speed));
    }
}
