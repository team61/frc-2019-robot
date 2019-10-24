package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class LogitechJoystick extends Joystick {

    public LogitechJoystick(final int port) {
        super(port);
    }

    public Button btn_1 = new JoystickButton(this, 1);
    public Button btn_2 = new JoystickButton(this, 2);
    public Button btn_3 = new JoystickButton(this, 3);
    public Button btn_4 = new JoystickButton(this, 4);
    public Button btn_5 = new JoystickButton(this, 5);
    public Button btn_6 = new JoystickButton(this, 6);
    public Button btn_7 = new JoystickButton(this, 7);
    public Button btn_8 = new JoystickButton(this, 8);
    public Button btn_9 = new JoystickButton(this, 9);
    public Button btn_10 = new JoystickButton(this, 10);
    public Button btn_11 = new JoystickButton(this, 11);
    public Button btn_12 = new JoystickButton(this, 12);
    //public Trigger trigger = new TriggerButton();
}
