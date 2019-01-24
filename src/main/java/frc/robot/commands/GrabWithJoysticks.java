package frc.robot.commands;

/**
 *
 */
public class GrabWithJoysticks extends GlobalCommand {

    public GrabWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
    	requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	oi.jRight.updateToggleTrigger();
        if(oi.jRight.toggleOn){
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
        	
        	//Toggle button to release or remove catch
        	oi.jClaw.updateToggleButton();
            if(oi.jClaw.toggleOnButton){
            	claw.releaseCatch();
            } else {
            	claw.removeCatch();
            }
        	
        	//Toggle button to open and close the claw
        	oi.jClaw.updateToggleTrigger();
            if(oi.jClaw.toggleOn){
            	claw.openClaw();
            } else {
            	claw.closeClaw();
            }
            
            //Toggle button to lift and lower claw
        	oi.jLift.updateToggleTrigger();
            if(oi.jLift.toggleOn){
            	claw.liftClaw();
            } else {
            	claw.lowerClaw();
            }
            
        } else {
        	// The commands here will occur normally, when the TorqueLift is
        	// not activated.
        	
        	//Toggle button to open and close the claw
        	oi.jClaw.updateToggleTrigger();
            if(oi.jClaw.toggleOn){
            	claw.openClaw();
            } else {
            	claw.closeClaw();
            }
            
            //Toggle button to lift and lower claw
        	oi.jLift.updateToggleTrigger();
            if(oi.jLift.toggleOn){
            	claw.liftClaw();
            } else {
            	claw.lowerClaw();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
