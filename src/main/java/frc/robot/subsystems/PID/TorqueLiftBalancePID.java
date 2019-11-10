package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class TorqueLiftBalancePID extends PIDSubsystem {

    private double rotateSpeed;

    public TorqueLiftBalancePID() {
        super(.0055, 0, 0);
    }

    @Override
    protected void initDefaultCommand() {
    }

    @Override
    protected double returnPIDInput() {
        return Robot.m_navigation.getPitch();
    }

    @Override
    protected void usePIDOutput(double output) {
        rotateSpeed = output;
    }
}
