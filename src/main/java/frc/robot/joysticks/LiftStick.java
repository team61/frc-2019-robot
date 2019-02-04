package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class LiftStick extends Stick {
    private Joystick jLift;

    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;

    public LiftStick() {
        jLift = new Joystick(RobotMap.liftStick);
        button7 = new JoystickButton(jLift, 7);
        button8 = new JoystickButton(jLift, 8);
        button9 = new JoystickButton(jLift, 9);
        button10 = new JoystickButton(jLift, 10);
        button11 = new JoystickButton(jLift, 11);
        button12 = new JoystickButton(jLift, 12);
    }

    public double getY() {
        return jLift.getY();
    }

    public Button getButton7() {
        return button7;
    }

    public Button getButton8() {
        return button8;
    }

    public Button getButton9() {
        return button9;
    }

    public Button getButton10() {
        return button10;
    }

    public Button getButton11() {
        return button11;
    }

    public Button getButton12() {
        return button12;
    }

    /**
     * Toggle button to lift and lower the claw
     */
    public void updateToggleTrigger() {
        if(jLift.getTrigger()){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        } else {
            togglePressed = false;
        }
    }
}
