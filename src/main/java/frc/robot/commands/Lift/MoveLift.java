package frc.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.m_lift;

public class MoveLift extends Command {

    private final int destination;
    private boolean reachedDestination;
    private final double speed = 0.5;

    public MoveLift(int destination) {
        requires(m_lift);
        this.destination = destination;
    }

    @Override
    protected void initialize() {
        reachedDestination = false;
    }

    @Override
    protected void execute() {
        m_lift.armLevels.updateLocation();
        if (m_lift.armLevels.getLocation() < destination) {
            m_lift.moveLift(speed);
        } else if (m_lift.armLevels.getLocation() > destination) {
            m_lift.moveLift(-speed);
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
        m_lift.stopLift();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
