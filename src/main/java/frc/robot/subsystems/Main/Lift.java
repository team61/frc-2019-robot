package frc.robot.subsystems.Main;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LimitSwitch;
import frc.robot.RobotMap;
import frc.robot.commands.Lift.NormalLiftWithJoysticks;

public class Lift extends Subsystem {

    private WPI_TalonSRX liftMotor;
    private LimitSwitch LSLift;

    private Encoder eLift;

    private static final double MAX_HEIGHT = 600.0; // Max height that the lift can reach without breaking

    private double height;

    public Lift() {
    	super("Lift");
        liftMotor = new WPI_TalonSRX(RobotMap.mArm);

        LSLift = new LimitSwitch(RobotMap.LSLift);

        eLift = new Encoder(RobotMap.eLiftA, RobotMap.eLiftB, false, CounterBase.EncodingType.k4X);
        eLift.setDistancePerPulse(3);
        eLift.reset();
    }

    public void initDefaultCommand() { setDefaultCommand(new NormalLiftWithJoysticks()); }

    private void setLiftSpeed(double speed) { liftMotor.set(ControlMode.PercentOutput, speed); }

    public void stopLift() { setLiftSpeed(0); }

    public void moveLift(double speed) {
        if (!LSLift.isSwitchSet() && getHeight() < MAX_HEIGHT) {
            setLiftSpeed(speed);
        } else if (LSLift.isSwitchSet() && speed >= 0) {
            setLiftSpeed(speed);
        } else if (getHeight() >= MAX_HEIGHT && speed <= 0) {
            setLiftSpeed(speed);
        } else {
            stopLift();
        }
        setHeight();
    }

    private void setHeight() {
        height = eLift.getDistance();
    }

    public double getHeight() {
        height = eLift.getDistance();
        return height;
    }
}