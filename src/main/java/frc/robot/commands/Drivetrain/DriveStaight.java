package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PID.DrivetrainDistancePID;
import frc.robot.subsystems.PID.GyroRotatePID;

public class DriveStaight extends Command {

    private DrivetrainDistancePID drivetrainDistancePID;
    private GyroRotatePID gyroRotatePID;

    public DriveStaight(double distance) {
        requires(Robot.m_robotbase);
        requires(Robot.m_navigation);

        drivetrainDistancePID = new DrivetrainDistancePID();
        drivetrainDistancePID.setSetpoint(distance);

        gyroRotatePID = new GyroRotatePID();
        gyroRotatePID.setSetpoint(Robot.m_navigation.getYaw());
    }

    @Override
    protected void initialize() {
        gyroRotatePID.enable();
        drivetrainDistancePID.enable();
    }

    @Override
    protected void execute() {
        double driveSpeed = -drivetrainDistancePID.getDriveSpeed();
        double turnSpeed = gyroRotatePID.getTurnSpeed();
        double leftSpeed = driveSpeed - turnSpeed;
        double rightSpeed = driveSpeed + turnSpeed;
        Robot.m_robotbase.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return drivetrainDistancePID.onTarget() && gyroRotatePID.onTarget();
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTankDrive();
        gyroRotatePID.disable();
        drivetrainDistancePID.disable();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
