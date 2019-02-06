package frc.robot.commands;

/**
 *
 */
public class TorqueLiftWithJoysticks extends GlobalCommand {

    public TorqueLiftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	oi.jLeft.updateToggleTrigger();
        if(oi.jLeft.toggleOn){
            System.out.println("lift enabled");
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
            torquelift.shiftPTO(); // TODO: ensure that shiftPTO enables the lift, rather than the drive wheels
            if (!(limitSwitchFrontA.isSwitchSet() || limitSwitchFrontC.isSwitchSet())) {
                torquelift.liftDrive(oi.getLeftSpeed(), 0.0); // front, rear
            }
            if (!(limitSwitchRearA.isSwitchSet() || limitSwitchRearC.isSwitchSet())) {
                torquelift.liftDrive(0.0, oi.getRightSpeed()); // front, rear
            }
        } else {
            System.out.println("lift disabled, motors should be driving now");
            // The commands here will occur normally, when the TorqueLift is
            // not activated.
            torquelift.disengagePTO();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}