package frc.robot;

import frc.robot.commands.*;
import frc.robot.joysticks.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private final double UPPER_JOYSTICK_BUFFER = .05;
    private final double LOWER_JOYSTICK_BUFFER = .05;

    // Declare Joysticks
    public Stick jLeft = new LeftStick(RobotMap.leftStick);
    public Stick jRight = new RightStick(RobotMap.rightStick);
    public Stick jLift = new LiftStick(RobotMap.liftStick);
    public Stick jArm = new ArmStick(RobotMap.armStick);

	public OI() {
		jLift.getButton7().whenPressed(new LowerFrontAndRearSixInch());
		jLift.getButton8().whenPressed(new LowerFrontAndRearGroup());
		jLift.getButton9().whenPressed(new RaiseFrontSixInch());
		jLift.getButton10().whenPressed(new RaiseFrontSixInch());
		jLift.getButton11().whenPressed(new RaiseRearSixInch());
		jLift.getButton12().whenPressed(new RaiseRearSixInch());

        jArm.getButton7().whenPressed(new RaiseArmToA());
        jArm.getButton9().whenPressed(new RaiseArmToB());
        jArm.getButton11().whenPressed(new RaiseArmToC());
        jRight.getButton3().whenPressed(new LowerArmThreeInch());
        jRight.getTrigger().whenPressed(new LowerArmToBase());

        // TODO: implement trigger class that extends button, and allows the trigger to funtion like a button in OI
	}

    /** 
     * Gets the position of the jElev Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLiftSpeed() {
		if ((jLift.getY() < UPPER_JOYSTICK_BUFFER) && (jLift.getY() > LOWER_JOYSTICK_BUFFER)) {
			return 0;
		} else {
			return (jLift.getY());
		}
	}

    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getLeftSpeed() {
        if ((jLeft.getY() < UPPER_JOYSTICK_BUFFER) && (jLeft.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jLeft.getY());
        }
	}

	//reverse joystick brings robot up in air
	public double getLeftPositiveSpeed() {
	    if (getLeftSpeed() > 0) {
	        return getLeftSpeed();
        } else {
	        return 0;
        }
    }

    public double getLeftNegativeSpeed() {
        if (getLeftSpeed() < 0) {
            return getLeftSpeed();
        } else {
            return 0;
        }
    }
	
    /** 
     * Gets the position of the jLeft Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getRightSpeed() {
        if ((jRight.getY() < UPPER_JOYSTICK_BUFFER) && (jRight.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jRight.getY());
        }
	}

    public double getRightPositiveSpeed() {
        if (getRightSpeed() > 0) {
            return getRightSpeed();
        } else {
            return 0;
        }
    }

    public double getRightNegativeSpeed() {
        if (getRightSpeed() < 0) {
            return getRightSpeed();
        } else {
            return 0;
        }
    }
	
    /** 
     * Gets the position of the jClaw Y Axis
     * @return joystick value scaled -1 to 1
     */
	public double getArmSpeed() {
        if ((jArm.getY() < UPPER_JOYSTICK_BUFFER) && (jArm.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (jArm.getY());
        }
	}

    public double getArmPositiveSpeed() {
        if (getArmSpeed() > 0) {
            return getArmSpeed();
        } else {
            return 0;
        }
    }

    public double getArmNegativeSpeed() {
        if (getArmSpeed() < 0) {
            return getArmSpeed();
        } else {
            return 0;
        }
    }
}
