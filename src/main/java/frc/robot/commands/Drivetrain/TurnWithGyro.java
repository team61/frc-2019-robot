package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PID.GyroRotatePID;

public class TurnWithGyro extends Command {

    private GyroRotatePID gyroRotatePID;

    public TurnWithGyro(double angle) {
        requires(Robot.m_robotbase);
        gyroRotatePID = new GyroRotatePID();

        gyroRotatePID.setSetpoint(angle);
    }

    @Override
    protected void initialize() {
        gyroRotatePID.enable();
    }

    @Override
    protected void execute() {
        double leftSpeed = gyroRotatePID.getTurnSpeed();
        double rightSpeed = -gyroRotatePID.getTurnSpeed();

        Robot.m_robotbase.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {

        return gyroRotatePID.onTarget();
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTankDrive();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
