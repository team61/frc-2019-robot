package frc.robot.commands;

public class NormalDriveWithJoysticks extends GlobalCommand {

    public NormalDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Driving");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            drivetrain.tankDrive(oi.getLeftSpeed(), oi.getRightSpeed());
            drivetrain.moveLiftWheelsMotor(oi.getLiftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
