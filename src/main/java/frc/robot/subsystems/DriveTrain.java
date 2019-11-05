package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drivetrain.NormalDriveWithJoysticks;

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
    private TalonSRX liftWheelsMotor = new TalonSRX(RobotMap.mLiftWheels);
    
	private static final double WHEEL_DIAMETER = 8;
	private static final double PULSE_PER_REVOLUTION = 1440;
	private static final double ENCODER_GEAR_RATIO = 1;
	private static final double GEAR_RATIO = 5 / 3;
	private static final double FUDGE_FACTOR = 2.8; // this is changed to accurately get a measure from our encoder

    public DriveTrain() {
    	super("Drivetrain");
        System.out.println("DriveTrain Initiated");
    }


    public void initDefaultCommand() {
    	setDefaultCommand(new NormalDriveWithJoysticks());
    }


    public void tankDrive(double left, double right) {
        moveLeftMotorStack(left);
        moveRightMotorStack(right);
    }

    public void moveLeftMotorStack(double speed) {
        firstLeftMotor.set(ControlMode.PercentOutput, speed);
        secondLeftMotor.set(ControlMode.PercentOutput, speed);
    }
    

    public void moveRightMotorStack(double speed) {
        firstRightMotor.set(ControlMode.PercentOutput, -speed);
        secondRightMotor.set(ControlMode.PercentOutput, -speed);
    }

    public void moveLiftWheelsMotor(double speed) {
        liftWheelsMotor.set(ControlMode.PercentOutput, speed);
    }
    

    public void stop() {
    	moveLeftMotorStack(0.0);
    	moveRightMotorStack(0.0);
    }


    public double getLeftEncoder() {
//    	return leftEncoder.getDistance();
        return 0;
    }


    public double getRightEncoder() {
//      return rightEncoder.getDistance();
        return 0;
    }

    public void resetLeftEncoder() {
//    	leftEncoder.reset();
    }

    public void resetRightEncoder() {
//    	rightEncoder.reset();
    }
}

