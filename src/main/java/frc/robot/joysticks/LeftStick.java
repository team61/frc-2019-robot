package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class LeftStick extends Stick {
    private Joystick jLeft;
    public LeftStick() {
        jLeft = new Joystick(RobotMap.leftStick);
    }

    public double getY() {
        return jLeft.getY();
    }

    public void updateToggleTrigger() {
        if (jLeft.getTrigger()) {
            if (!togglePressed) {
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        } else {
            togglePressed = false;
        }
    }
}
