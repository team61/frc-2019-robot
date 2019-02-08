package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchArmC extends Switch {

    private DigitalInput limitSwitchArmC;

    public LimitSwitchArmC() {
        limitSwitchArmC = new DigitalInput(RobotMap.limitSwitchArmC);
    }
    public boolean isSwitchSet() {
        return !limitSwitchArmC.get();
    }
}
