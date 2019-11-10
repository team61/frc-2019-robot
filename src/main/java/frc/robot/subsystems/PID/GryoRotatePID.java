package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class GryoRotatePID extends PIDSubsystem {

    private double rotateSpeed;

    public GryoRotatePID() {
        super(.0055, 0, 0);
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
        rotateSpeed = output;
    }
}
