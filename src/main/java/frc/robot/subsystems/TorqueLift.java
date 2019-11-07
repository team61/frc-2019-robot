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

    public static FrontLift frontlift = new FrontLift();
    public static RearLift rearlift = new RearLift();

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
        frontlift.move(speed);
    }

    public void moveRear(double speed) {
        rearlift.move(speed);
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
        frontlift.stop();
    }

    public void stopRear() {
        rearlift.stop();
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