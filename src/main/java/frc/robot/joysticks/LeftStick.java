package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class LeftStick extends Stick {
    private Joystick jLeft;
    private Button button5;

    public LeftStick(int port) {
        jLeft = new Joystick(port);
        button5 = new JoystickButton(jLeft, 5);
    }

    public double getY() {
        return jLeft.getY();
    }

    public Button getButton5() {
        return button5;
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
        if (getButton5().get()) {
            if (!togglePressedButton) {
                toggleOnButton = !toggleOnButton;
                togglePressedButton = true;
            }
        } else {
            togglePressedButton = false;
        }
    }
}
