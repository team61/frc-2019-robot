package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchArmA extends Switch {

    private DigitalInput limitSwitchArmA;

    public LimitSwitchArmA() {
        limitSwitchArmA = new DigitalInput(RobotMap.limitSwitchArmA);
    }
    public boolean isSwitchSet() {
        return !limitSwitchArmA.get();
    }
}
