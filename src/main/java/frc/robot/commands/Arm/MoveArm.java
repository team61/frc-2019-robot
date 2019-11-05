package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.arm;

public class MoveArm extends Command {
    private boolean reachedDestination;
    private int destination;
    private final double speed = 0.5;
    public MoveArm(int destination) {
        requires(arm);
        reachedDestination = false;
        this.destination = destination;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        reachedDestination = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        arm.checkLocation();
        if (arm.LSArm[0].isSwitchSet()) {
            arm.moveArm(0.3);
            Timer.delay(0.2);
            arm.stopArm();
        } else if (arm.LSArm[arm.LSArm.length - 1].isSwitchSet()) {
            arm.moveArm(0.3);
            Timer.delay(0.2);
            arm.stopArm();
        } else {
            if (arm.getLocation() < destination) {
                arm.moveArm(speed);
            } else if (arm.getLocation() > destination) {
                arm.moveArm(-speed);
            } else {
                reachedDestination = true;
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return reachedDestination;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
