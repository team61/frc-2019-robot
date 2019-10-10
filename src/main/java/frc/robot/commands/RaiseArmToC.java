package frc.robot.commands;

public class RaiseArmToC extends GlobalCommand {
    private boolean armCActivated;

    public RaiseArmToC() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        armCActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Arm C Limit Switch: " + limitSwitchArmC.isSwitchSet());
        if (limitSwitchArmC.isSwitchSet()) {
            armCActivated = true;
        }

        if (!armCActivated) {
            arm.moveArm(-.50);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return armCActivated;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
