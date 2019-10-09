package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.oi;
import static frc.robot.Robot.torquelift;

public class NormalTorqueliftWithJoysticks extends Command {
    public NormalTorqueliftWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("NormalTorqueLiftWithJoysticks is ON");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Called to print out whenever a limit switch is passed
        for (int i = 0; i < torquelift.LSFront.length; i++) {
            if (torquelift.LSFront[i].isSwitchSet()) {
                System.out.println("Limit Switch Arm Level: " + i + torquelift.LSFront[i].isSwitchSet());
            }
        }
        for (int i = 0; i < torquelift.LSRear.length; i++) {
            if (torquelift.LSRear[i].isSwitchSet()) {
                System.out.println("Limit Switch Arm Level: " + i + torquelift.LSRear[i].isSwitchSet());
            }
        }

        // If bottom or top limit switch is NOT pressed, allow controls
        if (!(torquelift.LSFront[0].isSwitchSet() || torquelift.LSFront[torquelift.LSFront.length - 1].isSwitchSet())) {
            torquelift.moveFront(oi.getLeftSpeed());
        }
        if (!(torquelift.LSRear[0].isSwitchSet() || torquelift.LSRear[torquelift.LSFront.length - 1].isSwitchSet())) {
            torquelift.moveRear(oi.getLeftSpeed());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("NormalTorqueLiftWithJoysticks is OFF");
        torquelift.stopFront();
        torquelift.stopRear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
