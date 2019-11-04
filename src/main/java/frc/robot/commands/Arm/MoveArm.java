package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.arm;

public class MoveArm extends Command {
    private boolean LimitSwitchState;
    private int level;
    private double speed;
    public MoveArm(int level, double speed) {
        // Use requires() here to declare subsystem dependencies
        this.level = level;
        this.speed = (arm.getLocation() >= level) ? -speed:speed;
    }
    private void monitorLocation() {
        // Monitors the location of the arm by checking each limit switch
        for (int i = 0; i < arm.LSArm.length; i++) {
            if (arm.LSArm[i].isSwitchSet()) {
                arm.setLocation(i);
            }
        }
    }

    // Safety feature to stop arm if the arm be the set location.
    private void checkDestination() {
        if (speed <= 0) {
            if (arm.getLocation() >= level) {
                LimitSwitchState = true;
            }
        } else {
            if (arm.getLocation() <= level) {
                LimitSwitchState = true;
            }
        }
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        LimitSwitchState = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        monitorLocation();
        checkDestination();
        System.out.println(arm.LSArm[level] + ": " + arm.LSArm[level].isSwitchSet());

        // If the bottom or top limit switches are pressed, reverse speed to prevent damage
        if (arm.LSArm[0].isSwitchSet() || arm.LSArm[arm.LSArm.length - 1].isSwitchSet()) {
            arm.moveArm(-speed);
        }
        if (!LimitSwitchState) {
            arm.moveArm(speed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return LimitSwitchState;
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
