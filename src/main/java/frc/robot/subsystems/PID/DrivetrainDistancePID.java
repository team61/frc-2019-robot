package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class DrivetrainDistancePID extends PIDSubsystem {

    private double driveSpeed;

    public DrivetrainDistancePID() {
        super(0, 0, 0);
        setOutputRange(-1, 1);
        setPercentTolerance(2);
    }

    @Override
    protected double returnPIDInput() {
        return (Robot.m_robotbase.getLeftEncoder() + Robot.m_robotbase.getRightEncoder()) / 2;
    }

    @Override
    protected void usePIDOutput(double output) {
        driveSpeed = output;
    }

    @Override
    protected void initDefaultCommand() {
    }

    public double getDriveSpeed() {
        return driveSpeed;
    }
}
