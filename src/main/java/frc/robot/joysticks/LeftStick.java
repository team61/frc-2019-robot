package frc.robot.joysticks;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class LeftStick extends Stick {
    private Joystick jLeft;
    public LeftStick() {
        jLeft = new Joystick(RobotMap.leftStick);
    }

    public double getY() {
        return jLeft.getY();
    }
}
