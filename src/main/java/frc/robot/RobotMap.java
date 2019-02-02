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
	public static int clawStick = 3;

	//Motor Ports
	public static int mLeftA = 1;
	public static int mLeftB = 2;
	public static int mRightA = 3;
	public static int mRightB = 4;
	public static int mLiftA = 5;
	public static int mLiftB = 6;
	
	//Encoder Ports
	public static int eLeftA = 1;
	public static int eLeftB = 2;
	public static int eRightA = 7;
	public static int eRightB = 8;
	public static int eLiftA = 3;
	public static int eLiftB= 4;
	
	//Solonoids 
	public static int pcmModule = 11;
	public static int sClawLifterChannelA = 0;
	public static int sClawLifterChannelB = 1;
	public static int sClawChannelA = 2;
	public static int sClawChannelB = 3;
	public static int sLiftSwapA = 4;
	public static int sLiftSwapB = 5;
	
	//Limit Switches
	public static int limitSwitchFrontA = 0;
	public static int limitSwitchFrontB = 0;
	public static int limitSwitchFrontC = 0;
	public static int limitSwitchRearA = 0;
	public static int limitSwitchRearB = 0;
	public static int limitSwitchRearC = 0;

	//Misc.
	public static int barToggleButton = 10;
	public static int mainGyro = 0;
	public static int chooserSwitchA = 6;
	public static int chooserSwitchB = 5;
}
