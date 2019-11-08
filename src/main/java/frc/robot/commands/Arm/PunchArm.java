package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class PunchArm extends InstantCommand {

    public PunchArm() {
        requires(Robot.m_arm);
    }

    @Override
    protected void _initialize() {
        Robot.m_arm.setArmState(true);
    }
}

