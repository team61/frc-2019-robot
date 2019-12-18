package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch {

    private DigitalInput LimitSwitch;

    public LimitSwitch(int port) {
        LimitSwitch = new DigitalInput(port);
    }
    public boolean isSwitchSet() {
        return !LimitSwitch.get();
    }
}