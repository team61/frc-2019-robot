package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NormalTorqueliftWithJoysticks extends Command {

    public NormalTorqueliftWithJoysticks() {
        requires(Robot.m_robotbase);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.setPTOState(true);
    }

    @Override
    protected void execute() {
        Robot.m_robotbase.torkLiftDrive(Robot.m_oi.getLeftSpeed(), Robot.m_oi.getRightSpeed());
        Robot.m_robotbase.moveLiftWheels(Robot.m_oi.getLiftWheelsSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTorqueLiftDrive();
        Robot.m_robotbase.setPTOState(false);
    }

    @Override
    protected void interrupted() {
        end();
    }
}