package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontA extends Switch {
    // A limit switch is at the top of the lift mechanism, but
    // when reached, the robot will be at is lowest point
    // (disregarding arm height)

    private DigitalInput limitSwitchFrontA;

    public LimitSwitchFrontA() {
        limitSwitchFrontA = new DigitalInput(RobotMap.limitSwitchFrontA);
    }
    public boolean isSwitchSet() {
        return !limitSwitchFrontA.get();
    }
}
