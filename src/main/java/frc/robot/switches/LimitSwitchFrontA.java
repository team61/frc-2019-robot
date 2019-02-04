package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontA extends Switch {
    private DigitalInput limitSwitchFrontA;

    public LimitSwitchFrontA() {
        limitSwitchFrontA = new DigitalInput(RobotMap.limitSwitchFrontA);
    }
    public boolean isSwitchSet() {
        return !limitSwitchFrontA.get();
    }
}
