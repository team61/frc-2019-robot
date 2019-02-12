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
        oi.jLeft.updateToggleTrigger();
        oi.jArm.updateToggleButton();
        if(oi.jLeft.toggleOn){
            // commands to occur when torque toggle is pressed
            // we only want the moveAllMotors command in TorqueLift to
            // run so we will do nothing here
            if(limitSwitchArmBase.isSwitchSet()) {
                arm.moveArm(oi.getArmNegativeSpeed());
            } else {
                arm.moveArm(oi.getArmSpeed());
            }
            arm.setArmState(oi.jArm.toggleOnButton);
        } else {
            //the commands here will be what normally runs
            if(limitSwitchArmBase.isSwitchSet()) {
                arm.moveArm(oi.getArmNegativeSpeed());
            } else {
                arm.moveArm(oi.getArmSpeed());
            }
            arm.setArmState(oi.jArm.toggleOnButton);
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
