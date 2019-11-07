package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.*;

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
        torquelift.move(oi.getLeftSpeed(), oi.getRightSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("NormalTorqueLiftWithJoysticks is OFF");
        torquelift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
