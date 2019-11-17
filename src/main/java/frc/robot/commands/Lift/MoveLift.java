package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveLift extends Command {

    private final int destination;
    private boolean reachedDestination;
    private final double speed = 0.5;

    public MoveLift(int destination) {
        requires(Robot.m_lift);
        this.destination = destination;
    }

    @Override
    protected void initialize() {
        reachedDestination = false;
    }

    @Override
    protected void execute() {
        Robot.m_lift.armLevels.updateLocation();
        if (Robot.m_lift.armLevels.getLocation() < destination) {
            Robot.m_lift.moveLift(speed);
        } else if (Robot.m_lift.armLevels.getLocation() > destination) {
            Robot.m_lift.moveLift(-speed);
        } else {
            reachedDestination = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return reachedDestination;
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
