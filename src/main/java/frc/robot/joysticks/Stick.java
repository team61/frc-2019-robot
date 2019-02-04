package frc.robot.joysticks;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Abstract joystick class
 */
public abstract class Stick {

    public boolean toggleOn = false;
    public boolean togglePressed = false;

    public boolean toggleOnButton = false;
    public boolean togglePressedButton = false;

    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;

    /**
     * Updates the values of volatile variables associated with the trigger.
     * Currently used for a toggle button on the joystick trigger
     */
    public void updateToggleTrigger() {
        toggleOn = false;
        togglePressed = false;
    }

    /**
     * Updates the values of volatile variables associated with buttons.
     * Currently used for toggle buttons.
     */
    public void updateToggleButton() {
        toggleOnButton = false;
        togglePressedButton = false;
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
        return button11;
    }

    /**
     * Y Value of Joystick
     * @return the value of the y axis of the joystick, scaled from -1 to 1
     */
    public double getY() {
        return 0.0;
    }
}
