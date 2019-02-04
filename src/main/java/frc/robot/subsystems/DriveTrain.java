package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain Subsystem
 */
public class DriveTrain extends Subsystem {
//	private Encoder leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, EncodingType.k4X);
//	private Encoder rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, false, EncodingType.k4X);
//
//	private AnalogGyro mainGyro = new AnalogGyro(RobotMap.mainGyro);

    private TalonSRX firstLeftMotor = new TalonSRX(RobotMap.mLeftA);
    private TalonSRX secondLeftMotor = new TalonSRX(RobotMap.mLeftB);
    private TalonSRX firstRightMotor = new TalonSRX(RobotMap.mRightA);
    private TalonSRX secondRightMotor = new TalonSRX(RobotMap.mRightB);
    
	private static final double WHEEL_DIAMETER = 8;
	private static final double PULSE_PER_REVOLUTION = 1440;
	private static final double ENCODER_GEAR_RATIO = 1;
	private static final double GEAR_RATIO = 5 / 3;
	private static final double FUDGE_FACTOR = 2.8; // this is changed to accurately get a measure from our encoder

    public DriveTrain() {
    	super("DriveTrain");
        final double distancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
//    	leftEncoder.setDistancePerPulse(distancePerPulse);
//    	rightEncoder.setDistancePerPulse(distancePerPulse);
        System.out.println("DriveTrain Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
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
    
    /**
     * Moves the multiple motors on the left side.
     * @author Team 61 Programming
     * @param speed the speed of the motors in percentage form
     */
    private void moveLeftMotorStack(double speed) {
        firstLeftMotor.set(ControlMode.PercentOutput, speed);
        secondLeftMotor.set(ControlMode.PercentOutput, speed);
    }
    
    /**
     * Moves the multiple motors on the right side.
     * @author Team 61 Programming
     * @param speed the speed of the motors in percentage form
     */
    private void moveRightMotorStack(double speed) {
        firstRightMotor.set(ControlMode.PercentOutput, -speed);
        secondRightMotor.set(ControlMode.PercentOutput, -speed);
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
     * Resets Gyro to 0
     * @author Team 61 Programming
     */
    public void resetGyro(){
//        mainGyro.reset();
    }
    
    /**
     * Get Gyro Angle
     * Positive is clockwise
     * @return scaled angle in degrees
     */
    public double getGyroAngle(){
//      return mainGyro.getAngle();
        return 0;
    }

    /**
     * Get Gyro Rate
     * @return the rate of rotation of the Gyro
     */
    public double getGyroRate(){
//      return mainGyro.getRate();
        return 0;
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

