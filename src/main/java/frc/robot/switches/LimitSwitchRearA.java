package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearA extends Switch {
    private DigitalInput limitSwitchRearA;

    public LimitSwitchRearA() {
        limitSwitchRearA = new DigitalInput(RobotMap.limitSwitchRearA);
    }

    public boolean isSwitchSet() {
        return limitSwitchRearA.get();
    }
}
