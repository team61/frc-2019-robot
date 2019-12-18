package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PID.DriveTrainDistancePID;
import frc.robot.subsystems.PID.GyroRotatePID;

public class DriveToDistance extends Command {

    private DriveTrainDistancePID drivetrainDistancePID;
    private GyroRotatePID gyroRotatePID;

    public DriveToDistance(double distance, double angle) {
        initializeDriveToDistance(distance, angle);
    }

    public DriveToDistance(double distance) {
        initializeDriveToDistance(distance, Robot.m_navigation.getYaw());
    }

    private void initializeDriveToDistance(double distance, double angle) {
        requires(Robot.m_robotbase);

        drivetrainDistancePID = new DriveTrainDistancePID();
        drivetrainDistancePID.setSetpoint(distance);

        gyroRotatePID = new GyroRotatePID();
        gyroRotatePID.setSetpoint(angle);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.resetEncoders();
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
        gyroRotatePID.disable();
        drivetrainDistancePID.disable();
        Robot.m_robotbase.stopTankDrive();
    }

    @Override
    protected void interrupted() {
        end();
    }
}