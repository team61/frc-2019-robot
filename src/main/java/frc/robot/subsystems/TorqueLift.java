package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LimitSwitch;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.TorqueLift.NormalTorqueliftWithJoysticks;

/**
 * Documentation for the gyro is here: https://www.kauailabs.com/public_files/navx-mxp/apidocs/java/com/kauailabs/navx/frc/AHRS.html
 */
public class TorqueLift extends Subsystem {

    /**
     * Definition of Solenoids
     * Solenoids in this program will have the 's' prefix
     */
    private Solenoid sPTOA = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOA);
    private Solenoid sPTOB = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOB);
    private AHRS ahrs;

    private static LSLevelSubsystem m_frontlift = new LSLevelSubsystem("Front Lift", RobotMap.LSFront) {
        @Override
        protected void setSpeed(double speed) { Robot.drivetrain.moveLeftMotorStack(-speed); }

        @Override
        protected void initDefaultCommand() { }
    };

    private static LSLevelSubsystem m_rearlift = new LSLevelSubsystem("Rear Lift", RobotMap.LSRear) {
        @Override
        protected void setSpeed(double speed) { Robot.drivetrain.moveRightMotorStack(-speed); }

        @Override
        protected void initDefaultCommand() { }
    };

    public TorqueLift() {
    	super("TorqueLift");
    	ahrs = new AHRS(SPI.Port.kMXP);
        ahrs.reset();
        setPTOState(false);
        System.out.println("TorqueLift Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
    }

    /**
     * Sets the state of the PTO
     * if true, the lift is enabled, if false, the drive mechanism is enabled
     * @author Team 61 Programming
     */
    public void setPTOState(boolean bool) {
        sPTOA.set(bool);
        sPTOB.set(!bool);
    }

    public void moveFront(double speed) {
        m_frontlift.move(speed);
    }

    public void moveRear(double speed) {
        m_rearlift.move(speed);
    }

    public void move(double frontSpeed, double rearSpeed) {
        moveFront(frontSpeed);
        moveRear(rearSpeed);
    }

    public void move(double speed) {
        moveFront(speed);
        moveRear(speed);
    }

    public void stopFront() {
        m_frontlift.stop();
    }

    public void stopRear() {
        m_rearlift.stop();
    }

    public void stop() {
        stopFront();
        stopRear();
    }
    public void resetGyro() {
        ahrs.reset();
    }

    public double getGyroYaw() {
        return ahrs.getYaw();
    }

    public double getGyroRoll() {
        return ahrs.getRoll();
    }

    public double getGyroPitch() {
        return ahrs.getPitch();
    }
}