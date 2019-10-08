package frc.lib.util.components;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch {
    private DigitalInput LimitSwitch;
    public enum Location {Front, Rear, Arm}
    private Location Location;
    private int Level;

    public LimitSwitch(int port, Location Location, int Level) {
        LimitSwitch = new DigitalInput(port);
        this.Location = Location;
        this.Level = Level;
    }

    public boolean isSwitchSet() {
        return !LimitSwitch.get();
    }

    public Location getLocation() {
        return Location;
    }
    public int getLevel() {
        return Level;
    }

    public String toString() {
        return (Location.name() + Level + "Limit Switch");
    }
}
