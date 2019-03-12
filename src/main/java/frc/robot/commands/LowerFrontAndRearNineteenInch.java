package frc.robot.commands;

public class LowerFrontAndRearNineteenInch extends GlobalCommand {
    private boolean frontCActivated;
    private boolean rearCActivated;
    private double frontSpeedFactor = 0.0;
    private double rearSpeedFactor = 0.0;

    public LowerFrontAndRearNineteenInch() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frontCActivated = false;
        rearCActivated = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Front Limit Switch: " + limitSwitchFrontC.isSwitchSet());
        System.out.println("Rear Limit Switch: " + limitSwitchRearC.isSwitchSet());
        if (limitSwitchFrontC.isSwitchSet()) {
            frontCActivated = true;
        }

        if (limitSwitchRearC.isSwitchSet()) {
            rearCActivated = true;
        }

        torquelift.setPTOState(true);
        if (!rearCActivated) {
            torquelift.moveRearDown(.30 + rearSpeedFactor);
        }
        if (!frontCActivated) {
            torquelift.moveFrontDown(.42 + frontSpeedFactor);
        }
        // when roll is negative, the robots front is up
        if(torquelift.getGyroRoll() < -1) {
            rearSpeedFactor = .2;
        } else {
            rearSpeedFactor = 0.0;
        }

        if(torquelift.getGyroRoll() > 1) {
            frontSpeedFactor = .2;
        } else {
            frontSpeedFactor = 0.0;
        }
        System.out.println(torquelift.getGyroRoll());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((frontCActivated && rearCActivated) || oi.jArm.getButton4().get()
                || (Math.abs(oi.getLeftSpeed()) > .2)
                || (Math.abs(oi.getRightSpeed()) > .2)) {
            // command should be killed when button 4 on arm stick is pressed or when
            // left or right joysticks are moved
            return true;
        } else {
            return false;
        }
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
