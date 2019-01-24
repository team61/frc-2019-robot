package frc.robot.joysticks;

/**
 * Abstract joystick class
 */
public abstract class Stick {

    public boolean toggleOn = false;
    public boolean togglePressed = false;

    public boolean toggleOnButton = false;
    public boolean togglePressedButton = false;

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

    /**
     * Y Value of Joystick
     * @return the value of the y axis of the joystick, scaled from -1 to 1
     */
    public double getY() {
        return 0.0;
    }
}
