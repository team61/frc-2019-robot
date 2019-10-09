package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.NormalDriveWithJoysticks;

/**
 * The DriveTrain Subsystem
 */
public class Drivetrain extends Subsystem {
//	private Encoder leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, EncodingType.k4X);
//	private Encoder rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, false, EncodingType.k4X);
//
//	private AnalogGyro mainGyro = new AnalogGyro(RobotMap.mainGyro);

    private TalonSRX firstLeftMotor = new TalonSRX(RobotMap.mLeftA);
    private TalonSRX secondLeftMotor = new TalonSRX(RobotMap.mLeftB);
    private TalonSRX firstRightMotor = new TalonSRX(RobotMap.mRightA);
    private TalonSRX secondRightMotor = new TalonSRX(RobotMap.mRightB);
    private TalonSRX liftWheelsMotor = new TalonSRX(RobotMap.mLiftWheels);
    
	private static final double WHEEL_DIAMETER = 8;
	private static final double PULSE_PER_REVOLUTION = 1440;
	private static final double ENCODER_GEAR_RATIO = 1;
	private static final double GEAR_RATIO = 5 / 3;
	private static final double FUDGE_FACTOR = 2.8; // this is changed to accurately get a measure from our encoder

    public Drivetrain() {
    	super("Drivetrain");
        System.out.println("DriveTrain Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new NormalDriveWithJoysticks());
    }

    /**
     * Tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void tankDrive(double left, double right) {
        moveLeftMotorStack(left);
        moveRightMotorStack(right);
    }
    
    /**
     * Reversed tank-drive controls.
     * @author Team 61 Programming
     * @param left Left motor value or motor stack value
     * @param right Right motor value or motor stack value
     */
    public void reverseTankDrive(double right, double left) {
        moveRightMotorStack(right);
        moveLeftMotorStack(left);
    }

    // when joysticks are negative, robot is moved up

    /**
     * Moves the multiple motors on the left side.
     * @author Team 61 Programming
     * @param speed the speed of the motors in percentage form
     */
    public void moveLeftMotorStack(double speed) {
        firstLeftMotor.set(ControlMode.PercentOutput, speed);
        secondLeftMotor.set(ControlMode.PercentOutput, speed);
    }
    
    /**
     * Moves the multiple motors on the right side.
     * @author Team 61 Programming
     * @param speed the speed of the motors in percentage form
     */
    public void moveRightMotorStack(double speed) {
        firstRightMotor.set(ControlMode.PercentOutput, -speed);
        secondRightMotor.set(ControlMode.PercentOutput, -speed);
    }

    public void moveLiftWheelsMotor(double speed) {
        liftWheelsMotor.set(ControlMode.PercentOutput, speed);
    }
    
    /**
     * Stops the left and right motor stacks.
     * @author Team 61 Programming
     */
    public void stop() {
    	moveLeftMotorStack(0.0);
    	moveRightMotorStack(0.0);
    }

    /**
     * Get Distance Traveled
     * @return the distance the robot has driven since the last reset
     */
    public double getLeftEncoder() {
//    	return leftEncoder.getDistance();
        return 0;
    }

    /**
     * Get Distance Traveled
     * @return the distance the robot has driven since the last reset
     */
    public double getRightEncoder() {
//      return rightEncoder.getDistance();
        return 0;
    }

    /**
     * Reset the left motor encoder distance to zero
     */
    public void resetLeftEncoder() {
//    	leftEncoder.reset();
    }

    /**
     * Reset the right motor encoder distance to zero
     */
    public void resetRightEncoder() {
//    	rightEncoder.reset();
    }
}

