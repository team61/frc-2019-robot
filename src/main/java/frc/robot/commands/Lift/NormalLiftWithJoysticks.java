package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NormalLiftWithJoysticks extends Command {

    public NormalLiftWithJoysticks() {
        requires(Robot.m_lift);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        //System.out.println(Robot.m_lift.getHeight());
        Robot.m_lift.moveLift(Robot.m_oi.getLiftSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_lift.stopLift();
    }

    @Override
    protected void interrupted() {
        end();
    }
}