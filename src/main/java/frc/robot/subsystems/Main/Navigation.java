package frc.robot.subsystems.Main;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Navigation extends Subsystem {

    private AHRS ahrs;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    private static final double WHEEL_DIAMETER = 8;
    private static final double PULSE_PER_REVOLUTION = 1440;
    private static final double ENCODER_GEAR_RATIO = 1;
    private static final double GEAR_RATIO = 12.75;
    private static final double FUDGE_FACTOR = 1; // this is changed to accurately get a measure from our encoder

    public Navigation() {
        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error installing navX MXP: " + ex.getMessage(), true);
        }
        leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, CounterBase.EncodingType.k4X);
        rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, true, CounterBase.EncodingType.k4X);

        final double distancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);
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

    /* Methods for Encoder Data */

    public double getLeftEncoder() {
        return leftEncoder.getDistance();
    }

    public double getFrontEncoder() {
        return getLeftEncoder();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
    }

    public double getRearEncoder() {
        return getRightEncoder();
    }

    public void resetLeftEncoder() {
        leftEncoder.reset();
    }

    public void resetRearEncoder() {
        resetRightEncoder();
    }

    public void resetFrontEncoder() {
        resetLeftEncoder();
    }

    public void resetRightEncoder() {
        rightEncoder.reset();
    }
}
