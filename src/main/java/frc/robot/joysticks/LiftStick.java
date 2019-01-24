package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class LiftStick extends Stick {
    private Joystick jLift;
    public LiftStick() {
        jLift = new Joystick(RobotMap.liftStick);
    }

    public double getY() {
        return jLift.getY();
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
