package frc.robot;

public class LSLevels {
    private final LimitSwitch[] LSLevels;
    private int location;

    public LSLevels(int[] levels) {
        LSLevels = new LimitSwitch[levels.length];
        for (int i = 0; i < LSLevels.length; i++) {
            LSLevels[i] = new LimitSwitch(levels[i]);
        }
        location = 0;
    }

    public boolean checkBottomLimitSwitch() {
        return LSLevels[0].isSwitchSet();
    }

    public boolean checkTopLimitSwitch() {
        return LSLevels[LSLevels.length - 1].isSwitchSet();
    }

    public void updateLocation() {
        if (getLocation() != 0 && getLocation() != LSLevels.length - 1) {
            if (LSLevels[getLocation() - 1].isSwitchSet()) {
                setLocation(getLocation() - 1);
            }
            if (LSLevels[getLocation() + 1].isSwitchSet()) {
                setLocation(getLocation() + 1);
            }
        }
    }
    public void setLocation(int location) {
        if (location > 0 || location < LSLevels.length - 1) {
            this.location = location;
        }
    }

    public int getLocation() { return location; }
}
