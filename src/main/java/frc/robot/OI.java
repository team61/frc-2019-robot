package frc.robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private final double UPPER_JOYSTICK_BUFFER = .05;
    private final double LOWER_JOYSTICK_BUFFER = .05;

    // Declare Joysticks
    private LogitechJoystick jLeft = new LogitechJoystick(RobotMap.leftStick);
    private LogitechJoystick jRight = new LogitechJoystick(RobotMap.rightStick);
    private LogitechJoystick jLift = new LogitechJoystick(RobotMap.liftStick);
    private LogitechJoystick jArm = new LogitechJoystick(RobotMap.armStick);

	public OI() {
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
}
