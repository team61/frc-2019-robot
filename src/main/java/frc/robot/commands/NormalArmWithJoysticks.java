package frc.robot.commands;

public class NormalArmWithJoysticks extends GlobalCommand {
    public NormalArmWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Using Arm");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            arm.moveArm(-oi.getArmSpeed());
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
        end();
    }
}
