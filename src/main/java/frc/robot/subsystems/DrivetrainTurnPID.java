package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.vision.M_I2C;
import frc.robot.vision.PixyPacket;

import static frc.robot.Robot.drivetrain;

public class DrivetrainTurnPID extends PIDSubsystem {
    private double speed = 0;
    private final int CENTER = 158;
    private M_I2C i2c;
    private PixyPacket pkt;
    public DrivetrainTurnPID() {
        super((0.0012658),0,0);
        i2c = new M_I2C();
        pkt = i2c.getPixy();
        setInputRange(0, 316);
        setOutputRange(-1, 1);
        setPercentTolerance(2);
    }
    protected void initDefaultCommand() {

    }

    protected double returnPIDInput() {
        return CENTER - pkt.getX();
    }

    protected void usePIDOutput(double output) {
        speed = output;
    }

    public double getSpeed() {
        return speed;
    }

    public void resetSpeed() {
        speed = 0;
    }
}
