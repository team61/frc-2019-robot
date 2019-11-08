package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LSLevels;
import frc.robot.RobotMap;
import frc.robot.commands.Drivetrain.NormalDriveWithJoysticks;

public class RobotBase extends Subsystem {

    private TalonSRX frontLeftMotor = new TalonSRX(RobotMap.mLeftA);
    private TalonSRX rearLeftMotor = new TalonSRX(RobotMap.mLeftB);
    private TalonSRX frontRightMotor = new TalonSRX(RobotMap.mRightA);
    private TalonSRX rearRightMotor = new TalonSRX(RobotMap.mRightB);
    private TalonSRX liftWheelsMotor = new TalonSRX(RobotMap.mLiftWheels); // These wheels help the robot get into the platform

   // private Encoder leftEncoder = new Encoder(RobotMap.eLeftA, RobotMap.eLeftB, false, CounterBase.EncodingType.k4X);
    //private Encoder rightEncoder = new Encoder(RobotMap.eRightA, RobotMap.eRightB, true, CounterBase.EncodingType.k4X);

    private Solenoid sPTOA = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOA);
    private Solenoid sPTOB = new Solenoid(RobotMap.pcmModule, RobotMap.sPTOB);

    public LSLevels frontLevels = new LSLevels(RobotMap.LSFront);
    public LSLevels rearLevels = new LSLevels(RobotMap.LSRear);

    public RobotBase() {
        super("RobotBase");
        setPTOState(false);
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
        moveLeftMotorStack(leftSpeed);
        moveRightMotorStack(rightSpeed);
    }

    public void tankDrive(double speed) {
        moveLeftMotorStack(speed);
        moveRightMotorStack(speed);
    }

    public void stopTankDrive() {
        tankDrive(0);
    }

    public void torqueLiftDrive(double frontSpeed, double rearSpeed) {
        tankDrive(frontSpeed, rearSpeed);
    }

    public void torqueLiftDrive(double speed) {
        tankDrive(speed);
    }

    public void stopTorqueLiftDrive() {
        stopTankDrive();
    }

    public void moveLeftMotorStack(double speed) {
        frontLeftMotor.set(ControlMode.PercentOutput, speed);
        rearLeftMotor.set(ControlMode.PercentOutput, speed);
    }

    public void moveRightMotorStack(double speed) {
        frontRightMotor.set(ControlMode.PercentOutput, -speed);
        rearRightMotor.set(ControlMode.PercentOutput, -speed);
    }

    public void moveLiftWheels(double speed) {
        liftWheelsMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopLiftWheels() {
        moveLiftWheels(0);
    }

    public void moveFront(double speed) {
        moveLeftMotorStack(speed);
    }

    public void moveRear(double speed) {
        moveRightMotorStack(speed);
    }

    public void stopFront() {
        moveFront(0);
    }

    public void stopRear() {
        moveRear(0);
    }
    /*
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

    public void resetFrontEncoder() {
        resetLeftEncoder();
    }

    public void resetRightEncoder() {
        rightEncoder.reset();
    }

    public void resetRearEncoder() {
        resetRightEncoder();
    }*/
}
