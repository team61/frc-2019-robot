package frc.robot;

import frc.robot.commands.Lift.MoveLift;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {


    // TODO Test for joystick buffers, 0.7 is a rough estimate
	private final double UPPER_JOYSTICK_BUFFER = .07;
    private final double LOWER_JOYSTICK_BUFFER = -.07;

    private final double RIGHT_JOYSTICK_BUFFER = .07;
    private final double LEFT_JOYSTICK_BUFFER = -.07;

    // Declare Joysticks
    private LogitechJoystick jLeft = new LogitechJoystick(RobotMap.leftStick);
    private LogitechJoystick jRight = new LogitechJoystick(RobotMap.rightStick);
    private LogitechJoystick jLift = new LogitechJoystick(RobotMap.liftStick);
    private LogitechJoystick jArm = new LogitechJoystick(RobotMap.armStick);

	public OI() {
        jArm.btn_7.whenPressed(new MoveLift(1));
        jArm.btn_9.whenPressed(new MoveLift(2));
        jArm.btn_11.whenPressed(new MoveLift(3));
        jRight.btn_3.whenPressed(new MoveLift(0));
	}

    public double getYJoystickValue(LogitechJoystick logitechjoystick) {
        if ((logitechjoystick.getY() < UPPER_JOYSTICK_BUFFER) && (logitechjoystick.getY() > LOWER_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (logitechjoystick.getY());
        }
    }

    public double getXJoystickValue(LogitechJoystick logitechjoystick) {
        if ((logitechjoystick.getX() < RIGHT_JOYSTICK_BUFFER) && (logitechjoystick.getX() > LEFT_JOYSTICK_BUFFER)) {
            return 0;
        } else {
            return (logitechjoystick.getX());
        }
    }

	public double getLiftWheelsSpeed() { return getYJoystickValue(jLift); }

	public double getLeftSpeed() { return getYJoystickValue(jLeft); }

	public double getRightSpeed() { return getYJoystickValue(jRight); }

	public double getLiftSpeed() { return getYJoystickValue(jArm); }

	// These are for when the end limit switches for the lift are pressed and prevent the lift from moving past the edges
	public double getPositiveLiftSpeed() { return (getLiftSpeed() > 0) ? getLiftSpeed() : 0; }

    public double getNegativeLiftSpeed() { return (getLiftSpeed() < 0) ? getLiftSpeed() : 0; }

}
