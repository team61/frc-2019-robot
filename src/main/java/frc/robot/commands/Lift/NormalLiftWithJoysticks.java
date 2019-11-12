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
        Robot.m_lift.armLevels.updateLocation();

        // These if statements prevent the arm from traveling past the end limit switches
        if (Robot.m_lift.armLevels.checkBottomLimitSwitch()) {
            Robot.m_lift.moveLift((Robot.m_oi.getLiftSpeed() > 0) ? Robot.m_oi.getLiftSpeed() : 0);
        } else if (Robot.m_lift.armLevels.checkTopLimitSwitch()) {
            Robot.m_lift.moveLift((Robot.m_oi.getLiftSpeed() < 0) ? Robot.m_oi.getLiftSpeed() : 0);
        } else {
            Robot.m_lift.moveLift(Robot.m_oi.getLiftSpeed());
        }
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
