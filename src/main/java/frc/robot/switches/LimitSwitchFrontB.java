package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontB extends Switch {
    private DigitalInput limitSwitchFrontB;

    public LimitSwitchFrontB() {
        limitSwitchFrontB = new DigitalInput(RobotMap.limitSwitchFrontB);
    }

    public boolean isSwitchSet() {
        return limitSwitchFrontB.get();
    }
}
