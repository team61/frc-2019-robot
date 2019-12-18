package frc.robot.subsystems.Main;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Navigation extends Subsystem {

    private AHRS ahrs;

    public Navigation() {
        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error installing navX MXP: " + ex.getMessage(), true);
        }
        resetGryo();
    }
    @Override
    public void initDefaultCommand() {

    }


    /**
     *  Methods for Gyro Data
     * @return The displacement in degrees from -180 to 180
     * */
    public double getYaw() {
        return ahrs.getYaw();
    }

    public double getPitch() {
        return ahrs.getRoll();
    } // The gyro was inserted sideways into the robot

    public double getRoll() {
        return ahrs.getPitch();
    } // The gyro was inserted sideways into the robot

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
}