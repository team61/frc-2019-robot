package frc.robot;

import frc.robot.commands.*;
import frc.robot.joysticks.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Declare Joysticks
    public Stick jLeft = new LeftStick();
    public Stick jRight = new RightStick();
    public Stick jLift = new LiftStick();
    public Stick jClaw = new ClawStick();

	public OI() {
		jLift.getButton7().whenPressed(new LowerFrontAndRearSixInch());
		jLift.getButton8().whenPressed(new LowerFrontAndRearGroup());
		jLift.getButton9().whenPressed(new RaiseFrontSixInch());
		jLift.getButton10().whenPressed(new RaiseFrontSixInch());
		jLift.getButton11().whenPressed(new RaiseRearSixInch());
		jLift.getButton12().whenPressed(new RaiseRearSixInch());
	}

    /** 
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLiftSpeed() {
        return (jLift.getY()); 
	}

    /**
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled 0 to 1
     */
	public double getLiftYUpSpeed() {
		if (getLiftSpeed() < 0) {
			return (jLift.getY());
		} else {
			return 0;		
		}
	}

    /**
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled -1 to 0
     */
	public double getLiftYDownSpeed() {
		if (getLiftSpeed() > 0) {
			return (jLift.getY());
		} else {
			return 0;		
		}
	}
	
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLeftSpeed() {
        return (jLeft.getY()); 
	}
	
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getRightSpeed() {
        return (jRight.getY()); 
	}
	
    /** 
     * Gets the position of the jClaw Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getClawSpeed() {
        return (jClaw.getY()); 
	}
}
