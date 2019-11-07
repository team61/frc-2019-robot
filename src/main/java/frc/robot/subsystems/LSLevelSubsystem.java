package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.LimitSwitch;

public abstract class LSLevelSubsystem extends Subsystem {
    private final LimitSwitch[] LSLevels;
    private int location;
    private double speed;
    private final double awayFromEdgeSpeed = 0.2;
    public LSLevelSubsystem(String name, int[] levels) {
        super(name);
        LSLevels = new LimitSwitch[levels.length];
        for (int i = 0; i < LSLevels.length; i++) {
            LSLevels[i] = new LimitSwitch(levels[i]);
        }
        location = 0;
    }

    protected abstract void setSpeed(double speed);
    public void stop() { setSpeed(0); }

    public void move(double speed) {
        if (checkBottomLimitSwitch()) {
            setSpeed(awayFromEdgeSpeed);
        } else if (checkTopLimitSwitch()) {
            setSpeed(-awayFromEdgeSpeed);
        } else {
            setSpeed(speed);
        }
    }

    public boolean checkBottomLimitSwitch() {
        return LSLevels[0].isSwitchSet();
    }

    public boolean checkTopLimitSwitch() {
        return LSLevels[LSLevels.length - 1].isSwitchSet();
    }

    public void checkLocation() {
        for (int i = 0; i < LSLevels.length; i++) {
            if (LSLevels[i].isSwitchSet()) {
                setLocation(i);
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