package frc.robot.commands;

public class LowerArmThreeInch extends GlobalCommand {
    private double initTime;
    private double timeMillis = 150;

    public LowerArmThreeInch() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arm.moveArm(.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((System.currentTimeMillis() - initTime > timeMillis) || limitSwitchArmBase.isSwitchSet()) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}