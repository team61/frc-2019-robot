package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.vision.M_I2C;
import frc.robot.vision.PixyPacket;

public class VisionCam extends Subsystem {

    private M_I2C i2c;
    private PixyPacket pkt;

    public VisionCam() {
        super("VisionCam");
        i2c = new M_I2C();
        pkt = i2c.getPixy();
    }

    protected void initDefaultCommand() {
    }

    public PixyPacket getPixy() {
        return pkt;
    }
}
