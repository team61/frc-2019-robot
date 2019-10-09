package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.arm;

public class MoveArm extends Command {
    private boolean LimitSwitchState;
    private int level;
    private double speed;
    public MoveArm(int level, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
        this.speed = speed;
        this.level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        LimitSwitchState = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(arm.LSArm[level] + ": " + arm.LSArm[level].isSwitchSet());
        int sign = (speed > 0) ? 1:-1;
        for (int i = 0; i < arm.LSArm.length - level; i++) {
            if (arm.LSArm[level + i * sign].isSwitchSet()) {
                LimitSwitchState = true;
            }
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
