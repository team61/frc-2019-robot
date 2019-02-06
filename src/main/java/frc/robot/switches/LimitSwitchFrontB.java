package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontB extends Switch {
    // B limit switch is at the middle of the lift mechanism.

    private DigitalInput limitSwitchFrontB;

    public LimitSwitchFrontB() {
        limitSwitchFrontB = new DigitalInput(RobotMap.limitSwitchFrontB);
    }

    public boolean isSwitchSet() {
        return !limitSwitchFrontB.get();
    }
}
