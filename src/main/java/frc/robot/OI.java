package frc.robot;

import frc.robot.commands.Drivetrain.DriveStaight;
import frc.robot.commands.Lift.MoveLift;
//import frc.robot.commands.Macro.Record;
import frc.robot.commands.TorqueLift.NormalTorqueliftWithJoysticks;

//import java.io.IOException;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Declare Joysticks
    private LogitechJoystick jLeft = new LogitechJoystick(RobotMap.leftStick);
    private LogitechJoystick jRight = new LogitechJoystick(RobotMap.rightStick);
    private LogitechJoystick jLiftWheels = new LogitechJoystick(RobotMap.liftStick);
    private LogitechJoystick jLift = new LogitechJoystick(RobotMap.liftWheelsStick);

	public OI() {
        jLift.btn_7.whenPressed(new MoveLift(1));
        jLift.btn_9.whenPressed(new MoveLift(2));
        jLift.btn_11.whenPressed(new MoveLift(3));
        jRight.btn_3.whenPressed(new MoveLift(0));
        jRight.btn_2.toggleWhenPressed(new DriveStaight(5));
        //jRight.btn_1.whenPressed(new NormalTorqueliftWithJoysticks());

        /*
        try {
            jLift.btn_1.toggleWhenPressed(new Record("Demo"));
        } catch (IOException exc) {
            System.out.println("Couldn't record");
        }*/
	}

	public double getLiftWheelsSpeed() { return jLift.getYAxis(); }

	public double getLeftSpeed() { return jLeft.getYAxis(); }

	public double getRightSpeed() { return jRight.getYAxis(); }

	public double getLiftSpeed() { return jLiftWheels.getYAxis(); }

}
