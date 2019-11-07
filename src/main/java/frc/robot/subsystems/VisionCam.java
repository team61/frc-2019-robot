package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.vision.M_I2C;
import frc.robot.vision.PixyPacket;

public class VisionCam extends Subsystem {

    public VisionCam() {
        super("VisionCam");
    }

    protected void initDefaultCommand() {
    }

    public PixyPacket getPixy() {
        return new M_I2C().getPixy();
    }
}
