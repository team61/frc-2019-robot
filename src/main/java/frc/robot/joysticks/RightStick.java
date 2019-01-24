package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class RightStick extends Stick {
    private Joystick jRight;
    public RightStick() {
        jRight = new Joystick(RobotMap.rightStick);
    }

    public double getY() {
        return jRight.getY();
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
