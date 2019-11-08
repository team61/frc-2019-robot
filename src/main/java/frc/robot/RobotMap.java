package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Stick Ports
	public static int leftStick = 0;
	public static int rightStick = 1;
	public static int liftStick = 2;
	public static int armStick = 3;

	//Motor Ports
	public static final int mLeftA = 5;
	public static final int mLeftB = 6;
	public static final int mRightA = 1;
	public static final int mRightB = 2;
	public static final int mArm = 4;
	public static final int mLiftWheels = 3;
	
	//Encoder Ports
	public static final int eLeftA = 1;
	public static final int eLeftB = 2;
	public static final int eRightA = 7;
	public static final int eRightB = 8;
	public static final int eLiftA = 3;
	public static final int eLiftB= 4;
	
	//Solonoids 
	public static final int pcmModule = 7;
	public static final int sPTOA = 0;
	public static final int sPTOB = 1;
	public static final int sArmA = 2;
	public static final int sArmB = 3;

	//Limit Switches
	public static final int[] LSFront = {3, 4, 5}; // Levels 0 (lowest) to 2 (highest)
	public static final int[] LSRear = {0, 1, 2}; // Levels 0 (lowest) to 2 (highest)
	public static final int[] LSArm = {9, 8, 7, 6}; // Levels 0 (lowest) to 3 (highest)

	//Misc.
	public static final int armReleaseButton = 5;
}
