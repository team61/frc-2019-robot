package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontC extends Switch {
    private DigitalInput limitSwitchFrontC;

    public LimitSwitchFrontC() {
        limitSwitchFrontC = new DigitalInput(RobotMap.limitSwitchFrontC);
    }

    public boolean isSwitchSet() {
        return !limitSwitchFrontC.get();
    }
}
