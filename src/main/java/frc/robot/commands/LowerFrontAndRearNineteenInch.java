package frc.robot.commands;

public class LowerFrontAndRearNineteenInch extends GlobalCommand {
    private boolean frontCActivated;
    private boolean rearCActivated;

    public LowerFrontAndRearNineteenInch() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frontCActivated = false;
        rearCActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Front Limit Switch: " + limitSwitchFrontC.isSwitchSet());
        System.out.println("Rear Limit Switch: " + limitSwitchRearC.isSwitchSet());
        if (limitSwitchFrontC.isSwitchSet()) {
            frontCActivated = true;
        }

        if (limitSwitchRearC.isSwitchSet()) {
            rearCActivated = true;
        }

        torquelift.shiftPTO();
        if (!rearCActivated) {
            torquelift.moveRearDown(.75);
        }
        if (!frontCActivated) {
            torquelift.moveFrontDown(1);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (frontCActivated && rearCActivated) {
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
