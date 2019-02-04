package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearC extends Switch {
    private DigitalInput limitSwitchRearC;

    public LimitSwitchRearC() {
        limitSwitchRearC = new DigitalInput(RobotMap.limitSwitchRearC);
    }

    public boolean isSwitchSet() {
        return !limitSwitchRearC.get();
    }
}
