package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn the robot for a specific amount of degrees based on the AnalogGyro reading.
 * @author Team 61 Programming
 */
public class TurnForDegrees extends GlobalCommand {

    private static final double kThresh = 3.0;
    private static final double FUDGE_FACTOR = 1;
    private double target;
    private double angle;
    private double error;
    private double speed = 0.2;
	
    public TurnForDegrees(double angle, double speed) {
    	requires(drivetrain);
    	this.angle = angle * FUDGE_FACTOR;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetGyro();
    	target = drivetrain.getGyroAngle() + angle;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double vel;
    	double angle = drivetrain.getGyroAngle();
    	System.out.println(angle);
    	error = target - angle;
        System.out.println("T "+target+" - A "+angle+" = E "+error);
        if (error > 0 ) {
        	vel = speed;
        } else {
        	vel = -speed;
        }
        System.out.println(-vel + " " + vel);
        drivetrain.tankDrive(-vel, vel);
        System.out.println(error);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ((Math.abs(error) < kThresh));

    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Finished Turn");
    	drivetrain.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
