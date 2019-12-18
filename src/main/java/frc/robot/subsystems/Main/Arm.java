package frc.robot.subsystems.Main;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Arm.PunchArm;

public class Arm extends Subsystem {

    private Solenoid sArmA = new Solenoid(RobotMap.pcmModule, RobotMap.sArmA);
    private Solenoid sArmB = new Solenoid(RobotMap.pcmModule, RobotMap.sArmB);

    public Arm() {
        super("Arm");
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new PunchArm());
    }

    public void setArmState(boolean bool) {
        sArmA.set(!bool);
        sArmB.set(bool);
    }
}