package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class ClawStick extends Stick{
    private Joystick jClaw;
    public ClawStick() {
        jClaw = new Joystick(RobotMap.clawStick);
    }

    public double getY() {
        return jClaw.getY();
    }

    /**
     * Toggle button to open and close the claw
     */
    public void updateToggleTrigger()
    {
        if(jClaw.getTrigger()){
            if(!togglePressed){
                toggleOn = !toggleOn;
                togglePressed = true;
            }
        } else {
            togglePressed = false;
        }
    }

    /**
     * releases catch for other robots
     */
    public void updateToggleButton()
    {
        if(jClaw.getRawButton(RobotMap.barToggleButton)){
            if(!togglePressedButton){
                toggleOnButton = !toggleOnButton;
                togglePressedButton = true;
            }
        } else {
            togglePressedButton = false;
        }
    }

}
