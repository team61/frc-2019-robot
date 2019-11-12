package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveFront extends Command {
    private final int destination;
    private boolean reachedDestination;
    private final double speed = 0.5;

    public MoveFront(int destination) {
        requires(Robot.m_robotbase);
        this.destination = destination;
    }

    @Override
    protected void initialize() {
        reachedDestination = false;
    }

    @Override
    protected void execute() {
        Robot.m_robotbase.frontLevels.updateLocation();
        if (Robot.m_robotbase.frontLevels.getLocation() < destination) {
            Robot.m_robotbase.moveFront(speed);
        } else if (Robot.m_robotbase.frontLevels.getLocation() > destination) {
            Robot.m_robotbase.moveFront(-speed);
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
        Robot.m_robotbase.stopFront();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
