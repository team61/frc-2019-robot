package frc.robot.commands;

public class UseArmWithJoysticks extends GlobalCommand {
    public UseArmWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Using Arm");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        oi.jRight.updateToggleTrigger();
        if(oi.jRight.toggleOn){
            // commands to occur when torque toggle is pressed
            // we only want the moveAllMotors command in TorqueLift to
            // run so we will do nothing here
            return;
        } else {
            //the commands here will be what normally runs

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
        end();
    }
}
