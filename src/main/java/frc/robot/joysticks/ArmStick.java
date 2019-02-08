package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class ArmStick extends Stick{
    private Joystick jClaw;
    public ArmStick() {
        jClaw = new Joystick(RobotMap.armStick);
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

    public void updateToggleButton()
    {
        if(jClaw.getRawButton(RobotMap.armReleaseButton)){
            if(!togglePressedButton){
                toggleOnButton = !toggleOnButton;
                togglePressedButton = true;
            }
        } else {
            togglePressedButton = false;
        }
    }

}
