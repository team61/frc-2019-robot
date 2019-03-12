package frc.robot.commands;

/**
 *
 */
public class TorqueLiftWithJoysticks extends GlobalCommand {
    private double frontSpeedFactor = 0.0;
    private double rearSpeedFactor = 0.0;
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
        oi.jLeft.updateToggleButton();
        if(oi.jLeft.toggleOn){
            System.out.println("lift enabled");
        	// The commands here will occur if the TorqueLift toggle switch
        	// is activated. All code here will only run after the button
        	// has been toggled.
            torquelift.setPTOState(true); // TODO: ensure that shiftPTO enables the lift, rather than the drive wheels
            if (limitSwitchFrontA.isSwitchSet() || limitSwitchFrontC.isSwitchSet() ||
                    limitSwitchRearA.isSwitchSet() || limitSwitchRearC.isSwitchSet()) {
                if (limitSwitchFrontA.isSwitchSet() || limitSwitchFrontC.isSwitchSet()) {
                    if (limitSwitchFrontA.isSwitchSet()) {
                        torquelift.frontLiftDrive(oi.getLeftPositiveSpeed());
                    } else {
                        torquelift.frontLiftDrive(oi.getLeftNegativeSpeed());
                    }
                } else {
                    torquelift.frontLiftDrive(oi.getLeftSpeed());
                }

                if (limitSwitchRearA.isSwitchSet() || limitSwitchRearC.isSwitchSet()) {
                    if (limitSwitchRearA.isSwitchSet()) {
                        torquelift.rearLiftDrive(oi.getRightPositiveSpeed());
                    } else {
                        torquelift.rearLiftDrive(oi.getRightNegativeSpeed());
                    }
                } else {
                    torquelift.rearLiftDrive(oi.getRightSpeed());
                }
            } else {
                torquelift.liftDrive(oi.getLeftSpeed(), oi.getRightSpeed());
            }

            if(!oi.jLeft.toggleOnButton) {
                // correction
                if (torquelift.getGyroRoll() < -1) {
                    torquelift.rearLiftDrive(.45);
                } else {
                    rearSpeedFactor = 0.0;
                }

                if (torquelift.getGyroRoll() > 1) {
                    torquelift.frontLiftDrive(.45);
                } else {
                    frontSpeedFactor = 0.0;
                }
            }
            System.out.println(torquelift.getGyroRoll());
        } else {
            System.out.println("lift disabled");
            // The commands here will occur normally, when the TorqueLift is
            // not activated.
            torquelift.setPTOState(false);
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