package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.arm;
import static frc.robot.Robot.oi;

public class NormalUseArmWithJoysticks extends Command {
    public NormalUseArmWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("NormalUseArmWithJoysticks is ON");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Called to print out whenever a limit switch is passed
        for (int i = 0; i < arm.LSArm.length; i++) {
            if (arm.LSArm[i].isSwitchSet()) {
                System.out.println("Limit Switch Arm Level: " + i + arm.LSArm[i].isSwitchSet());
            }
        }

        // If the bottom or top limit switches are pressed, reverse speed to prevent damage
        if (arm.LSArm[0].isSwitchSet()) {
            arm.moveArm(0.3);
            Timer.delay(0.2);
            arm.stopArm();
        } else if (arm.LSArm[arm.LSArm.length - 1].isSwitchSet()) {
            arm.moveArm(0.3);
            Timer.delay(0.2);
            arm.stopArm();
        } else {
            arm.moveArm(oi.getArmSpeed());
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("NormalUseArmWithJoysticks is OFF");
        arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
