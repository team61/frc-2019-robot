package frc.robot.commands;

public class LowerArmToBase extends GlobalCommand {
    private boolean armBaseActivated;

    public LowerArmToBase() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        armBaseActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Arm A Limit Switch: " + limitSwitchArmBase.isSwitchSet());
        if (limitSwitchArmBase.isSwitchSet()) {
            armBaseActivated = true;
        }

        if (!armBaseActivated) {
            arm.moveArm(.50);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return armBaseActivated;
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
