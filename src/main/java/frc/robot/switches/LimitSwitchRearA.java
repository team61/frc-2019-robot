package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearA extends Switch {
    // A limit switch is at the top of the lift mechanism, but
    // when reached, the robot will be at is lowest point
    // (disregarding arm height)

    private DigitalInput limitSwitchRearA;

    public LimitSwitchRearA() {
        limitSwitchRearA = new DigitalInput(RobotMap.limitSwitchRearA);
    }

    public boolean isSwitchSet() {
        return !limitSwitchRearA.get();
    }
}
