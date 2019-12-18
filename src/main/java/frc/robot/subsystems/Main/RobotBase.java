package frc.robot.subsystems.Main;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drivetrain.NormalDriveWithJoysticks;

public class RobotBase extends Subsystem {

    private WPI_TalonSRX frontLeftMotor;
    private WPI_TalonSRX rearLeftMotor;
    private WPI_TalonSRX frontRightMotor;
    private WPI_TalonSRX rearRightMotor;
    private WPI_TalonSRX liftWheelsMotor; //These wheels help the robot get into the platform

    private Solenoid sPTOA;
    private Solenoid sPTOB;

    private DifferentialDrive m_differentialDrive;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    private double x;
    private double y;

    private static final double WHEEL_DIAMETER = 8;
    private static final double PULSE_PER_REVOLUTION = 1440;
    private static final double ENCODER_GEAR_RATIO = 1;
    private static final double GEAR_RATIO = 12.75;
    private static final double FUDGE_FACTOR = 1; // this is changed to accurately get a measure from our encoder

    private static final double driveTrainDistancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
    private static final double torkLiftDistancePerPulse = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
    private double distancePerPulse;

    private boolean PTOState;

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

        m_differentialDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
        m_differentialDrive.setSafetyEnabled(false);

        leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, CounterBase.EncodingType.k4X);
        rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, true, CounterBase.EncodingType.k4X);

        distancePerPulse = driveTrainDistancePerPulse;
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);

        PTOState = false;
        //setPTOState(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new NormalDriveWithJoysticks());
    }

    public void setPTOState(boolean PTOState) {
        sPTOA.set(PTOState);
        sPTOB.set(!PTOState);
        distancePerPulse = (!PTOState) ? driveTrainDistancePerPulse : torkLiftDistancePerPulse;
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);
        this.PTOState = PTOState;
    }

    public boolean getPTOState() {
        return PTOState;
    }

    /* Drive Train Commands */

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squaredInputs) {
        m_differentialDrive.tankDrive(leftSpeed, rightSpeed, squaredInputs);
    }
    public void tankDrive(double leftSpeed, double rightSpeed) {
        tankDrive(leftSpeed, rightSpeed, false);
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

    /* Tork Lift Commands*/

    public void torkLiftDrive(double frontSpeed, double rearSpeed) {
        tankDrive(frontSpeed, rearSpeed);
    }

    public void torkLiftDrive(double speed) {
        tankDrive(speed);
    }

    public void stopTorqueLiftDrive() {
        torkLiftDrive(0);
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

    public void moveLiftWheels(double speed) {
        liftWheelsMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopLiftWheels() {
        moveLiftWheels(0);
    }

    /* Methods for Encoder Data */

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

    public void resetRightEncoder() {
        rightEncoder.reset();
    }

    public void resetEncoders() {
        resetRightEncoder();
        resetLeftEncoder();
    }

    public void resetRearEncoder() {
        resetRightEncoder();
    }

    public void resetFrontEncoder() {
        resetLeftEncoder();
    }

    public double getDistanceTraveled() {
        return (getLeftEncoder() + getRightEncoder()) / 2;
    }
}