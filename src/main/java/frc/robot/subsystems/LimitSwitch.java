package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The LimitSwitch Subsystem
 */
public class LimitSwitch extends Subsystem {
	
	private DigitalInput limitSwitchA = new DigitalInput(RobotMap.limitSwitchA);

    public void initDefaultCommand() {
    }
    /**
     * Gets the state of the limitswitch
     * @author Team 61 Programming
     * @return True if limitswitch is pressed
     */
	private boolean isSwitchSet() {
		return limitSwitchA.get();
	}
	
    /**
     * Determine if the limitswitch is pressed or not
     * @author Team 61 Programming
     * @return False if limitswitch is pressed, True if it is not
     */
    public boolean getReadyState() {
    	return !isSwitchSet();
    }
}