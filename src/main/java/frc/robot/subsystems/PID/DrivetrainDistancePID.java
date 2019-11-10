package frc.robot.subsystems.PID;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DrivetrainDistancePID extends PIDSubsystem {

    private double speed;

    public DrivetrainDistancePID() {
        super(0.0055, 0, 0);
    }

    @Override
    protected void initDefaultCommand() {
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {
        speed = output;
    }
}
