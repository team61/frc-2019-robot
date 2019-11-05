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

    public LimitSwitch[] LSFront = new LimitSwitch[3];
    public LimitSwitch[] LSRear = new LimitSwitch[3];

    private double output = 0;
    public TorqueLift() {
    	super("TorqueLift");
    	ahrs = new AHRS(SPI.Port.kMXP);
        ahrs.reset();
        setPTOState(false);
        System.out.println("TorqueLift Initiated");
        for (int i = 0; i < LSFront.length; i++) {
            LSFront[i] = new LimitSwitch(RobotMap.LSFront[i]);
        }
        for (int i = 0; i < LSRear.length; i++) {
            LSRear[i] = new LimitSwitch(RobotMap.LSRear[i]);
        }
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
        Robot.drivetrain.moveLeftMotorStack(-speed);
    }

    public void moveRear(double speed) {
        Robot.drivetrain.moveRightMotorStack(-speed);
    }

    public void stopFront() {
        Robot.drivetrain.moveLeftMotorStack(0.0);
    }

    public void stopRear() { Robot.drivetrain.moveRightMotorStack(0.0); }

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