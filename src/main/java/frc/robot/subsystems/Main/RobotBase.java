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

    public DifferentialDrive m_differentialDrive;

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

        setPTOState(false);
        m_differentialDrive.setSafetyEnabled(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new NormalDriveWithJoysticks());
    }

    public void setPTOState(boolean bool) {
        sPTOA.set(bool);
        sPTOB.set(!bool);
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
}
