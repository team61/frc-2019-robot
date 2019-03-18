package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.RobotMap;
import frc.robot.commands.GlobalCommand;
import frc.robot.commands.TorqueLiftWithJoysticks;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Doumentation for the gyro is here: https://www.kauailabs.com/public_files/navx-mxp/apidocs/java/com/kauailabs/navx/frc/AHRS.html
 */
public class TorqueLift extends Subsystem {

    /**
     * Definition of Solenoids
     * Solenoids in this program will have the 's' prefix
     */
    private Solenoid sPTOA = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOA);
    private Solenoid sPTOB = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOB);
    private Boolean isFrontDipping = false;
    private Boolean isRearDipping = false;
    private AHRS ahrs;
    public Relay gyroEnabledLight = new Relay(0);
	
    public TorqueLift() {
    	super("TorqueLift");
    	ahrs = new AHRS(SPI.Port.kMXP);
        ahrs.reset();
        System.out.println("TorqueLift Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TorqueLiftWithJoysticks());
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

    public void moveRearDown(double speed) {
        GlobalCommand.drivetrain.moveRightMotorStack(speed);
    }

    public void moveFrontDown(double speed) {
        GlobalCommand.drivetrain.moveLeftMotorStack(speed);
    }

    public void moveRearUp(double speed) {
        GlobalCommand.drivetrain.moveRightMotorStack(-speed);
    }

    public void moveFrontUp(double speed) {
        GlobalCommand.drivetrain.moveLeftMotorStack(-speed);
    }

    public void stopFront() {
        GlobalCommand.drivetrain.moveLeftMotorStack(0.0);
    }

    public void stopRear() {
        GlobalCommand.drivetrain.moveRightMotorStack(0.0);
    }

    public void liftDrive(double front, double rear) {
        GlobalCommand.drivetrain.tankDrive(front, rear);
    }

    public void frontLiftDrive(double speed) {
        GlobalCommand.drivetrain.moveLeftMotorStack(speed);
    }

    public void rearLiftDrive(double speed) {
        GlobalCommand.drivetrain.moveRightMotorStack(speed);
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
    /**
     * Shifts the robot from torque lift to normal lift, and vice versa
     */
    public void shift() {
    	// swaps the solonoids
//    	sSwapA.set(true);
//    	sSwapB.set(false);
    }

    /**
     * Sets the solenoids in their standard poitions
     */
    public void sSet() {
    	// the standard position of our solonoids
//    	sSwapA.set(false);
//    	sSwapB.set(true);
    }
}