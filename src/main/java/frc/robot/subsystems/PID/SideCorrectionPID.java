package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class SideCorrectionPID extends PIDSubsystem {

    private double turnSpeed;

    public SideCorrectionPID() {
        super(0, 0, 0);
        setOutputRange(-0.2, 0.2);
        setAbsoluteTolerance(0.1);

    }

    @Override
    protected double returnPIDInput() {
        return Robot.m_robotbase.getLeftEncoder() - Robot.m_robotbase.getRightEncoder();
    }

    @Override
    protected void usePIDOutput(double output) {
        turnSpeed = output;
    }

    @Override
    protected void initDefaultCommand() {
    }

    public double getTurnSpeed() {
        return turnSpeed;
    }
}
