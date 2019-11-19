package frc.robot.subsystems.Main;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.LSLevels;
import frc.robot.RobotMap;
import frc.robot.commands.Drivetrain.NormalDriveWithJoysticks;

public class RobotBase extends Subsystem {

    private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX rearLeftMotor;
    private WPI_TalonSRX frontRightMotor;
    private WPI_TalonSRX rearRightMotor;
    private WPI_TalonSRX liftWheelsMotor; //These wheels help the robot get into the platform

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    private Solenoid sPTOA;
    private Solenoid sPTOB;

//    public LSLevels frontLevels;
//    public LSLevels rearLevels;

    public DifferentialDrive m_differentialDrive;

    public static final double WHEEL_DIAMETER = 8;
    public static final double PULSE_PER_REVOLUTION = 1440;
    public static final double ENCODER_GEAR_RATIO = 1;
    public static final double GEAR_RATIO = 12.75;
    public static final double FUDGE_FACTOR = 1; // this is changed to accurately get a measure from our encoder
    //.84

    public RobotBase() {
        super("RobotBase");

        frontLeftMotor = new WPI_TalonSRX(RobotMap.mLeftA);
        rearLeftMotor = new WPI_TalonSRX(RobotMap.mLeftB);
        frontRightMotor = new WPI_TalonSRX(RobotMap.mRightA);
        rearRightMotor = new WPI_TalonSRX(RobotMap.mRightB);

        rearLeftMotor.follow(frontLeftMotor);
        rearRightMotor.follow(frontRightMotor);

        liftWheelsMotor = new WPI_TalonSRX(RobotMap.mLiftWheels);

        sPTOA = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOA);
        sPTOB = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOB);

//        try {
//            frontLevels = new LSLevels(RobotMap.LSFront);
//            rearLevels = new LSLevels(RobotMap.LSRear);
//        } catch (RuntimeException ex) {
//            DriverStation.reportError(ex.getMessage(), true);
//        }
        m_differentialDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

        leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, CounterBase.EncodingType.k4X);
        rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, true, CounterBase.EncodingType.k4X);

        setPTOState(false);
        m_differentialDrive.setSafetyEnabled(false);

        final double distancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new NormalDriveWithJoysticks());
    }

    public void setPTOState(boolean bool) {
        sPTOA.set(bool);
        sPTOB.set(!bool);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public void tankDrive(double speed) {
        tankDrive(speed, speed);
    }

    public void stopTankDrive() {
        tankDrive(0);
    }

    public void moveLeft(double speed) {
        frontLeftMotor.set(ControlMode.PercentOutput, speed);
    }

    public void moveRight(double speed) {
        frontRightMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopLeft() {
        moveLeft(0);
    }

    public void stopRight() {
        moveRight(0);
    }

    public void moveFront(double speed) {
        moveLeft(speed);
    }

    public void moveRear(double speed) {
        moveRight(speed);
    }

    public void stopFront() {
        stopLeft();
    }

    public void stopRear() {
        stopRight();
    }

    public void torqueLiftDrive(double frontSpeed, double rearSpeed) {
        tankDrive(frontSpeed, rearSpeed);
    }

    public void torqueLiftDrive(double speed) {
        tankDrive(speed);
    }

    public void stopTorqueLiftDrive() {
        torqueLiftDrive(0);
    }

    public void moveLiftWheels(double speed) {
        liftWheelsMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopLiftWheels() {
        moveLiftWheels(0);
    }

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
