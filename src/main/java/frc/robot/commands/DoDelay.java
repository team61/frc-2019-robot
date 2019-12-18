package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class DoDelay extends InstantCommand {

	private double time;

    public DoDelay(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void initialize() {
        System.out.println("Timer has started");
    	Timer.delay(time);
    }

    // Called once after isFinished returns true
    protected void end() { System.out.println("Timer has finished"); }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { end(); }
}