package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LSLevelSubsystem;

public abstract class MoveWithLimitSwitches extends Command {
    protected LSLevelSubsystem m_lslevelsubsystem;
    private int destination;
    protected boolean reachedDestination;
    private final double speed = 0.5;

    public MoveWithLimitSwitches(int destination) {
        this.destination = destination;
    }

    @Override
    protected void initialize() {
        reachedDestination = false;
    }

    @Override
    protected void execute() {
        m_lslevelsubsystem.checkLocation();
        if (m_lslevelsubsystem.getLocation() < destination) {
            m_lslevelsubsystem.move(speed);
        } else if (m_lslevelsubsystem.getLocation() > destination) {
            m_lslevelsubsystem.move(-speed);
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
        m_lslevelsubsystem.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
