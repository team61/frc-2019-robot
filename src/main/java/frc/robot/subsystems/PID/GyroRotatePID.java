package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class GyroRotatePID extends PIDSubsystem {

    private double turnSpeed;

    public GyroRotatePID() {
        super(.02, 0, 0);
        setOutputRange(-0.5, 0.5);
        setAbsoluteTolerance(5);
    }

    @Override
    protected void initDefaultCommand() {
    }

    @Override
    protected double returnPIDInput() {
        return Robot.m_navigation.getYaw();
    }

    @Override
    protected void usePIDOutput(double output) {
        turnSpeed = output;
    }

    public double getTurnSpeed() {
        return turnSpeed;
    }
}
