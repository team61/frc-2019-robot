package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.Lift.NormalLiftWithJoysticks;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * The Lift Subsystem
 * Controls the system that lifts and lowers the claw
 */
public class Lift extends Subsystem {
//
//	private TalonSRX firstLiftMotor = new TalonSRX(RobotMap.mLiftA);
//	private TalonSRX secondLiftMotor = new TalonSRX(RobotMap.mLiftB);
//
//	private Encoder liftEncoder = new Encoder(RobotMap.eLiftA, RobotMap.eLiftB);

	public Lift() {
		super("Lift");
		System.out.println("Lift Initiated");
//		liftEncoder.setDistancePerPulse(1.0);
	}

	/**
	 * The default command that the subsystem reverts to
	 * when the subsystem is idle (the command currently
	 * required the system completes).
	 */
    public void initDefaultCommand() {
		setDefaultCommand(new NormalLiftWithJoysticks());
    }

	/**
	 * Moves the lift up
	 * @author Team 61 Programming
	 * @param speed the speed of the motors in percentage form
	 */
    public void moveLiftUp(double speed) {
		if(speed < 0) speed = 0;
		moveLiftMotorStack(speed);
    }

	/**
	 * Moves the lift down
	 * @author Team 61 Programming
	 * @param speed the speed of the motors in percentage form
	 */
    public void moveLiftDown(double speed) {
		if(speed > 0) speed = 0;
		moveLiftMotorStack(speed);
    }

	/**
	 * Moves the lift motor
	 * @author Team 61 Programming
	 * @param speed the speed of the motors in percentage form
	 */
    public void moveLift(double speed) {
    	moveLiftMotorStack(speed);
    }

	/**
	 * Moves the lift motor(s)
	 * @author Team 61 Programming
	 * @param speed the speed of the motors in percentage form
	 */
	private void moveLiftMotorStack(double speed) {
//		firstLiftMotor.set(ControlMode.PercentOutput, speed);
//      secondLiftMotor.set(ControlMode.PercentOutput, speed);
	}

	/**
	 * Stops the lift motor
	 */
	public void stop() {
//		firstLiftMotor.set(ControlMode.PercentOutput, 0.0);
//      secondLiftMotor.set(ControlMode.PercentOutput, 0.0);
	}

	/**
	 * Get Distance Traveled
	 * @return the distance the lift has driven since the last reset
	 */
	public double getLiftEncoder(){
//		return liftEncoder.getDistance();
		return 0;
	}

	/**
	 * Reset the lift encoder distance to zero
	 */
	public void resetEncoder(){
//		liftEncoder.reset();
	}
}