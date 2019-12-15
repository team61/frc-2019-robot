package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NormalDriveWithJoysticks extends Command {

    public NormalDriveWithJoysticks() {
        requires(Robot.m_robotbase);
        requires(Robot.m_navigation);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.resetDriveTrainEncoders();
    }

    @Override
    protected void execute() {

        Robot.m_robotbase.tankDrive(Robot.m_oi.getLeftSpeed(), Robot.m_oi.getRightSpeed());

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTankDrive();
        Robot.m_robotbase.resetDriveTrainEncoders();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
