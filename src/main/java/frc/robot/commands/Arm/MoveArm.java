package frc.robot.commands.Arm;

import frc.robot.commands.MoveWithLimitSwitches;

import static frc.robot.Robot.arm;

public class MoveArm extends MoveWithLimitSwitches {
    public MoveArm(int destination) {
        super(destination);
        requires(arm); // requires has to be declared here, if declared in it's abstract class then requires will read null
        m_lslevelsubsystem = arm;
    }
}
