package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class LeftStick extends Stick {
    private Joystick jLeft;
    private Button button5;
    private Button button11;

    public LeftStick(int port) {
        jLeft = new Joystick(port);
        button5 = new JoystickButton(jLeft, 5);
        button11 = new JoystickButton(jLeft, 11);
    }

    public double getY() {
        return jLeft.getY();
    }

    public Button getButton5() {
        return button5;
    }

    public Button getButton11() {
        return button11;
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

    public void updateToggleButton() {
        if (getButton11().get()) {
            if (!togglePressedButton) {
                toggleOnButton = !toggleOnButton;
                togglePressedButton = true;
            }
        } else {
            togglePressedButton = false;
        }
    }
}
