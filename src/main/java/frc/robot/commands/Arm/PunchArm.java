package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

import static frc.robot.Robot.arm;

public class PunchArm extends InstantCommand {

    public PunchArm() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
    }

    // Calls the command once
    protected void initialize() {
        System.out.println("PunchArm is ON");
        arm.setArmState(true);
    }

    // Called after the command is finished
    protected void end() {
        System.out.println("PunchArm is OFF");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}

