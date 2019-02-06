package frc.robot.commands;

public class LowerFrontAndRearSixInch extends GlobalCommand {
    private boolean frontBActivated;
    private boolean rearBActivated;

    public LowerFrontAndRearSixInch() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frontBActivated = false;
        rearBActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Front Limit Switch: " + limitSwitchFrontB.isSwitchSet());
        System.out.println("Rear Limit Switch: " + limitSwitchRearB.isSwitchSet());
        if (limitSwitchFrontB.isSwitchSet()) {
            frontBActivated = true;
        }

        if (limitSwitchRearB.isSwitchSet()) {
            rearBActivated = true;
        }

        // the following two if statements are for safety purposes, as if the B
        // limit switches are already passed, we don't want it to keep going beyond the
        // C  limit switches point
        if (limitSwitchFrontC.isSwitchSet()) {
            frontBActivated = true;
        }

        if (limitSwitchRearC.isSwitchSet()) {
            rearBActivated = true;
        }

        torquelift.shiftPTO();
        if (!rearBActivated) {
            torquelift.moveRearDown(.75);
        }
        if (!frontBActivated) {
            torquelift.moveFrontDown(1);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (frontBActivated && rearBActivated) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        torquelift.disengagePTO();
        torquelift.stopFront();
        torquelift.stopRear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
