package frc.robot.commands;

import frc.robot.subsystems.ChooserSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGroup extends CommandGroup {
	public ChooserSwitch chooserswitch = new ChooserSwitch();
    public AutoGroup() {

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.charAt(0) == 'L')
    	{
    		// left data
    		if (chooserswitch.getChooserSwitchB()) {
    			//Runs when middle switch is enabled
    			addSequential(new AutoMiddleLeft());
    		} else {
    			//Runs when middle switch is disabled
	    		if (chooserswitch.getChooserSwitchA()) {
	    			addSequential(new AutoLeftA());
	    		} else {
	    			addSequential(new AutoRightB());
	    		}
    		}
    	} else {
    		// right data
    		if (chooserswitch.getChooserSwitchB()) {
    			//Runs when middle switch is enabled
    			addSequential(new AutoMiddleRight());
    		} else {
    			//Runs when middle switch is disabled
	    		if (chooserswitch.getChooserSwitchA()) {
	    			addSequential(new AutoLeftB());
	    		} else {
	    			addSequential(new AutoRightA());
	    		}
    		}
    	}
    }
}