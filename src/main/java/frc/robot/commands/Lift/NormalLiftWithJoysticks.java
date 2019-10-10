package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.lift;
import static frc.robot.Robot.oi;

public class NormalLiftWithJoysticks extends Command {
    public NormalLiftWithJoysticks() {
        requires(lift);
    }

    protected void initialize() {
        System.out.println("NormalLiftWithJoysticks is ON");
        lift.resetEncoder(); // this will have to be removed so that the encoder does not reset after autonomous is complete
    }

    protected void execute() {
            lift.moveLift(oi.getLiftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("NormalLiftWithJoysticks is OFF");
        lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
