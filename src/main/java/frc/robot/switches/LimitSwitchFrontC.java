package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchFrontC extends Switch {
    // C limit switch is the lowest limit switch on the lift mechanism,
    // but when activated the robot will be at its highest (disregarding
    // arm height.

    private DigitalInput limitSwitchFrontC;

    public LimitSwitchFrontC() {
        limitSwitchFrontC = new DigitalInput(RobotMap.limitSwitchFrontC);
    }

    public boolean isSwitchSet() {
        return !limitSwitchFrontC.get();
    }
}
