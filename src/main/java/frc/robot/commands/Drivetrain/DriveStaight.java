package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PID.DrivetrainDistancePID;
import frc.robot.subsystems.PID.SideCorrectionPID;

public class DriveStaight extends Command {

    private DrivetrainDistancePID drivetrainDistancePID;
    //private SideCorrectionPID sideCorrectionPID;

    public DriveStaight(double distance) {
        requires(Robot.m_robotbase);
        drivetrainDistancePID = new DrivetrainDistancePID();
        //sideCorrectionPID = new SideCorrectionPID();

        drivetrainDistancePID.setSetpoint(distance);
        //sideCorrectionPID.setSetpoint(0);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.resetLeftEncoder();
        Robot.m_robotbase.resetRightEncoder();

        drivetrainDistancePID.enable();
        //sideCorrectionPID.enable();
    }

    @Override
    protected void execute() {
        double driveSpeed = -drivetrainDistancePID.getDriveSpeed();
        double turnSpeed = 0; //sideCorrectionPID.getTurnSpeed();
        double leftSpeed = driveSpeed - turnSpeed;
        double rightSpeed = driveSpeed + turnSpeed;
        System.out.println(driveSpeed);
        System.out.println(Robot.m_robotbase.getRightEncoder());
        Robot.m_robotbase.tankDrive(driveSpeed, driveSpeed);
    }

    @Override
    protected boolean isFinished() {

        return drivetrainDistancePID.onTarget(); //&& sideCorrectionPID.onTarget();
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