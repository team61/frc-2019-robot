package frc.robot.commands;

public class PunchArm extends GlobalCommand {

    private boolean finished = false;

    public PunchArm() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        arm.setArmState(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Arm on");
        finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
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

