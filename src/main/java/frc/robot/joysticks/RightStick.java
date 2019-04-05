package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.RobotMap;

public class RightStick extends Stick {
    private Joystick jRight;
    private Button trigger;
    private Button button2;
    private Button button3;
    private Button button5;

    public RightStick(int port) {
        jRight = new Joystick(port);
        trigger = new TriggerButton(jRight);
        button2 = new JoystickButton(jRight, 2);
        button3 = new JoystickButton(jRight, 3);
        button5 = new JoystickButton(jRight, 5);

    }

    public double getY() {
        return jRight.getY();
    }

    public Button getTrigger() {
        return trigger;
    }

    public Button getButton2() { return button2; }

    public Button getButton3() {
        return button3;
    }

    public Button getButton5() {
        return button5;
    }

    /**
     * Used to initiate the torque lift mode of the robot
     */
    public void updateToggleTrigger() {
        if(jRight.getTrigger()){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        } else {
            togglePressed = false;
        }
    }
}
