package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class TriggerButton extends Button {
    Joystick joystick;

    public TriggerButton(Joystick joystick) {
        this.joystick = joystick;
    }

    @Override
    public boolean get() {
        return joystick.getTrigger();
    }
}
