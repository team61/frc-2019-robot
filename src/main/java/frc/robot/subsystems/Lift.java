package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LSLevels;
import frc.robot.RobotMap;
import frc.robot.commands.Lift.NormalLiftWithJoysticks;

public class Lift extends Subsystem {

    private TalonSRX liftMotor = new TalonSRX(RobotMap.mArm);

    public LSLevels armLevels = new LSLevels(RobotMap.LSArm);

    public Lift() {
    	super("Lift");
    }

    public void initDefaultCommand() { setDefaultCommand(new NormalLiftWithJoysticks()); }

    public void moveLift(double speed) { liftMotor.set(ControlMode.PercentOutput, speed); }

    public void stopLift() { moveLift(0); }
}

