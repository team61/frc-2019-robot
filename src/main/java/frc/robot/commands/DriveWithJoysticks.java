package frc.robot.commands;

/**
 *
 */
public class DriveWithJoysticks extends GlobalCommand {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Driving");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	oi.jLeft.updateToggleTrigger();
        if(oi.jLeft.toggleOn){
        	// commands to occur when torque toggle is pressed
            drivetrain.moveLiftWheelsMotor(oi.getLiftSpeed());
        } else {
        	//the commands here will be what normally runs
        	drivetrain.tankDrive(oi.getLeftSpeed(), oi.getRightSpeed());
            drivetrain.moveLiftWheelsMotor(oi.getLiftSpeed());
        }
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
