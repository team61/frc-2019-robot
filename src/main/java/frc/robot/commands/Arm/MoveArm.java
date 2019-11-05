package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.arm;
import static frc.robot.Robot.oi;

public class MoveArm extends Command {
    private boolean LimitSwitchState;
    private int level;
    private double speed = 0.5;
    public MoveArm(int level) {
        // Use requires() here to declare subsystem dependencies
        this.level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        LimitSwitchState = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        arm.checkLocation();

        if (arm.LSArm[0].isSwitchSet()) {
            arm.moveArm(0.3);
        } else if (arm.LSArm[arm.LSArm.length - 1].isSwitchSet()) {
            arm.moveArm(-0.3);
        } else {
            if (arm.getLocation() > level) {
                arm.moveArm(speed);
            } else if (arm.getLocation() < level) {
                arm.moveArm(-speed);
            } else {
                LimitSwitchState = true;
            }
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
