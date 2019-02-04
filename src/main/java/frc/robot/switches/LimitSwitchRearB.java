package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearB extends Switch {
    private DigitalInput limitSwitchRearB;

    public LimitSwitchRearB() {
        limitSwitchRearB = new DigitalInput(RobotMap.limitSwitchRearB);
    }

    public boolean isSwitchSet() {
        return !limitSwitchRearB.get();
    }
}
