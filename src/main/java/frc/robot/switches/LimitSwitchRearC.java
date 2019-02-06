package frc.robot.switches;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

public class LimitSwitchRearC extends Switch {
    // C limit switch is the lowest limit switch on the lift mechanism,
    // but when activated the robot will be at its highest (disregarding
    // arm height.

    private DigitalInput limitSwitchRearC;

    public LimitSwitchRearC() {
        limitSwitchRearC = new DigitalInput(RobotMap.limitSwitchRearC);
    }

    public boolean isSwitchSet() {
        return !limitSwitchRearC.get();
    }
}
