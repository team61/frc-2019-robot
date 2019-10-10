package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseDriveForDistance extends GlobalCommand {

    private static final double FUDGE_FACTOR = .94; //FUDGE_FACTOR affecs the left side
	private double target = 1;
    private double speed = .5;
    private double threshold = .25;
    private boolean finishedLeft = false;
    private boolean finishedRight = false;
//    public double travelled = 0;
    public double travelledLeft = 0;
    public double travelledRight = 0;
    

	public ReverseDriveForDistance(double target, double speed) {
    	requires(drivetrain);
    	this.target = target;
    	this.speed = -speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    	drivetrain.resetLeftEncoder();
    	drivetrain.resetRightEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	travelled = (drivetrain.getLeftEncoder() + drivetrain.getRightEncoder())/2;
//    	drivetrain.tankDrive(speed, speed*FUDGE_FACTOR);
//    	System.out.println("Left: " + drivetrain.getLeftEncoder());
//    	System.out.println("Right: " + drivetrain.getRightEncoder());
    	double speedLeft = speed * FUDGE_FACTOR;
    	double speedRight = speed;
    	travelledLeft = drivetrain.getLeftEncoder();
    	travelledRight = drivetrain.getRightEncoder();
    	if (target + travelledLeft < threshold) { finishedLeft = true; }
    	if (target + travelledRight < threshold) { finishedRight = true; }
    	drivetrain.tankDrive(-speedLeft, -speedRight);
    	System.out.println("TravelledLeft: " + travelledLeft + " SpeedLeft: " + speedLeft);
    	System.out.println("TravelledRight: " + travelledRight + " SpeedRight: " + speedRight);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return (target - travelled) < threshold;
        return (finishedRight);
//        return (finishedRight && finishedLeft);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
