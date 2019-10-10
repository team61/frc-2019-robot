package frc.robot.commands;

public class RaiseFrontSixInch extends GlobalCommand {
    private boolean frontAActivated;

    public RaiseFrontSixInch() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frontAActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Front Limit Switch: " + limitSwitchFrontA.isSwitchSet());
        if (limitSwitchFrontA.isSwitchSet()) {
            frontAActivated = true;
        }

        torquelift.setPTOState(true);

        if (!frontAActivated) {
            torquelift.moveFrontUp(1);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (frontAActivated || oi.jArm.getButton4().get()
                || (Math.abs(oi.getLeftSpeed()) > .2)
                || (Math.abs(oi.getRightSpeed()) > .2));
        // command should be killed when button 4 on arm stick is pressed or when
        // left or right joysticks are moved
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        torquelift.setPTOState(true);
        torquelift.stopFront();
        torquelift.stopRear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
