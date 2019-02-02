package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.TorqueLiftWithJoysticks;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TorqueLift extends Subsystem {

    /**
     * Definition of Solenoids
     * Solenoids in this program will have the 's' prefix
     */
	private Solenoid sSwapA = new Solenoid(RobotMap.pcmModule, RobotMap.sLiftSwapA);
	private Solenoid sSwapB = new Solenoid(RobotMap.pcmModule, RobotMap.sLiftSwapB);

    private TalonSRX motorA = new TalonSRX(RobotMap.mLeftA);
    private TalonSRX motorB = new TalonSRX(RobotMap.mLeftB);
    private TalonSRX motorC = new TalonSRX(RobotMap.mRightA);
    private TalonSRX motorD = new TalonSRX(RobotMap.mRightB);
	private TalonSRX motorE = new TalonSRX(RobotMap.mLiftA);
    private TalonSRX motorF = new TalonSRX(RobotMap.mLiftB);
	
    public TorqueLift() {
    	super("TorqueLift");
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
     * Moves all motors on the robot
     * @author Team 61 Programming
     * @param speed the speed of the motors in percentage form
     */
    public void moveAllMotors(double speed) {
    	motorA.set(ControlMode.PercentOutput, -speed);
    	motorB.set(ControlMode.PercentOutput, -speed);
    	motorC.set(ControlMode.PercentOutput, speed);
    	motorD.set(ControlMode.PercentOutput, speed);
    	motorE.set(ControlMode.PercentOutput, speed);
    }

    /**
     * Shifts the robot from torque lift to normal lift, and vice versa
     */
    public void shift() {
    	// swaps the solonoids
    	sSwapA.set(true);
    	sSwapB.set(false);
    }

    /**
     * Sets the solenoids in their standard poitions
     */
    public void sSet() {
    	// the standard position of our solonoids
    	sSwapA.set(false);
    	sSwapB.set(true);
    }
}