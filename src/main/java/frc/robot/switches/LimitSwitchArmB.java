package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchArmB extends Switch {

    private DigitalInput limitSwitchArmB;

    public LimitSwitchArmB() {
        limitSwitchArmB = new DigitalInput(RobotMap.limitSwitchArmB);
    }
    public boolean isSwitchSet() {
        return !limitSwitchArmB.get();
    }
}
