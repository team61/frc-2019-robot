package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Navigation extends Subsystem {

    private AHRS ahrs;

    public Navigation() {
        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error installing navX MXP: " + ex.getMessage(), true);
        }
    }

    public double getYaw() {
        return ahrs.getYaw();
    }

    public double getPitch() {
        return ahrs.getPitch();
    }

    public double getRoll() {
        return ahrs.getRoll();
    }

    public double getAccelerationX() {
        return ahrs.getRawAccelX();
    }

    public double getAccelerationY() {
        return ahrs.getRawAccelY();
    }

    public double getAccelerationZ() {
        return ahrs.getRawAccelZ();
    }

    public void resetGryo() {
        ahrs.reset();
    }

    public boolean isCalibrating() {
        return ahrs.isCalibrating();
    }

    @Override
    public void initDefaultCommand() {

    }
}
