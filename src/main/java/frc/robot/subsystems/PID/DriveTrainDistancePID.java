package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class DriveTrainDistancePID extends PIDSubsystem {

    private double driveSpeed;

    public DriveTrainDistancePID() {
        super(0.2, 0, 0);
        setOutputRange(-0.5, 0.5);
        setAbsoluteTolerance(0.2);
    }

    @Override
    protected double returnPIDInput() {
        return Robot.m_robotbase.getDistanceTraveled();
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