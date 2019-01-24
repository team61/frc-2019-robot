package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The ChooserSwitch Subsystem
 * Used to determine the mode of autonomous that will be used
 * Was utilized on the 2017-2018 robot but will likely not be used on the 2019 robot
 */
public class ChooserSwitch extends Subsystem {

	private DigitalInput chooserSwitchA = new DigitalInput(RobotMap.chooserSwitchA);
	private DigitalInput chooserSwitchB = new DigitalInput(RobotMap.chooserSwitchB);

    public void initDefaultCommand() {
    }
    
    public boolean getChooserSwitchA() {
    	return !chooserSwitchA.get();
    }
    
    public boolean getChooserSwitchB() {
    	return !chooserSwitchB.get();
    }
    
}

