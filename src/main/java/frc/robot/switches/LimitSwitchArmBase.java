package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchArmBase extends Switch {
    private DigitalInput limitSwitchArmBase;

    public LimitSwitchArmBase() {
        limitSwitchArmBase = new DigitalInput(RobotMap.limitSwitchArmBase);
    }
    public boolean isSwitchSet() {
        return !limitSwitchArmBase.get();
    }
}
