package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearB extends Switch {
    // B limit switch is at the middle of the lift mechanism.

    private DigitalInput limitSwitchRearB;

    public LimitSwitchRearB() {
        limitSwitchRearB = new DigitalInput(RobotMap.limitSwitchRearB);
    }

    public boolean isSwitchSet() {
        return !limitSwitchRearB.get();
    }
}
