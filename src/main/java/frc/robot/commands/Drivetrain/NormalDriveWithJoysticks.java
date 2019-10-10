package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.oi;

public class NormalDriveWithJoysticks extends Command {

    public NormalDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("NormalDriveWithJoysticks is ON");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            drivetrain.tankDrive(oi.getLeftSpeed(), oi.getRightSpeed());
            drivetrain.moveLiftWheelsMotor(oi.getLiftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("NormalDriveWithJoysticks is OFF");
        drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
