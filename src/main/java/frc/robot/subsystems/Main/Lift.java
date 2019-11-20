package frc.robot.subsystems.Main;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LSLevels;
import frc.robot.RobotMap;
import frc.robot.commands.Lift.NormalLiftWithJoysticks;

public class Lift extends Subsystem {

    public WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.mArm);

    //public LSLevels armLevels = new LSLevels(RobotMap.LSArm);

    private Encoder eLift;


    public Lift() {
    	super("Lift");
        eLift = new Encoder(RobotMap.eLiftA, RobotMap.eLiftB, false, CounterBase.EncodingType.k4X);
        eLift.reset();
    }

    public void initDefaultCommand() { setDefaultCommand(new NormalLiftWithJoysticks()); }

    public void moveLift(double speed) { liftMotor.set(ControlMode.PercentOutput, speed); }

    public void stopLift() { moveLift(0); }

    public double getLiftEncoder() {
        return eLift.get();
    }
}

