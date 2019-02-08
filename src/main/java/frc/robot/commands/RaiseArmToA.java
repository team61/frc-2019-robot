//package frc.robot.commands;
//
//public class RaiseArmToA extends GlobalCommand {
//    private boolean armAActivated;
//
//    public RaiseArmToA() {
//        // Use requires() here to declare subsystem dependencies
//        requires(arm);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//        armAActivated = false;
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//        System.out.println("Arm A Limit Switch: " + limitSwitchArmA.isSwitchSet());
//        if (limitSwitchArmA.isSwitchSet()) {
//            armAActivated = true;
//        }
//
//        torquelift.setPTOState(true);
//        if (!armAActivated) {
//            arm.moveArm(.75);
//        }
//
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return armAActivated;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//        System.out.println("ended");
//        torquelift.setPTOState(true);
//        torquelift.stopFront();
//        torquelift.stopRear();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//        end();
//    }
//}
