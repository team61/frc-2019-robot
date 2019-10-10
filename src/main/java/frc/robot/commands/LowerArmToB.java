package frc.robot.commands;

public class LowerArmToB extends GlobalCommand {
    private boolean armBActivated;

    public LowerArmToB() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        armBActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Arm B Limit Switch: " + limitSwitchArmB.isSwitchSet());
        if (limitSwitchArmB.isSwitchSet()) {
            armBActivated = true;
        }

        if (!armBActivated) {
            arm.moveArm(.30);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return armBActivated;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        torquelift.stopFront();
        torquelift.stopRear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
