package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class ArmStick extends Stick{
    private Joystick jArm;

    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;

    public ArmStick(int port) {
        jArm = new Joystick(port);
        button7 = new JoystickButton(jArm, 7);
        button8 = new JoystickButton(jArm, 8);
        button9 = new JoystickButton(jArm, 9);
        button10 = new JoystickButton(jArm, 10);
        button11 = new JoystickButton(jArm, 11);
        button12 = new JoystickButton(jArm, 12);
    }

    public double getY() {
        return jArm.getY();
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

    public Button getButton11() { return button11; }

    public Button getButton12() {
        return button12;
    }

    /**
     * Toggle button to open and close the claw
     */
    public void updateToggleTrigger()
    {
        if(jArm.getTrigger()){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        } else {
            togglePressed = false;
        }
    }

    public void updateToggleButton()
    {
        if(jArm.getRawButton(RobotMap.armReleaseButton)){
            if(!togglePressedButton){
                toggleOnButton = !toggleOnButton;
                togglePressedButton = true;
            }
        } else {
            togglePressedButton = false;
        }
    }

}
