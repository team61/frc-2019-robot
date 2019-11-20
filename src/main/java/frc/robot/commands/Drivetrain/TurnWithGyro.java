package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.PID.GryoRotatePID;

public class TurnWithGyro extends Command {

    private GryoRotatePID gryoRotatePID;

    public TurnWithGyro(double angle) {
        requires(Robot.m_robotbase);
        gryoRotatePID = new GryoRotatePID();

        gryoRotatePID.setSetpoint(angle);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.resetLeftEncoder();
        Robot.m_robotbase.resetRightEncoder();

        gryoRotatePID.enable();
    }

    @Override
    protected void execute() {
        double leftSpeed = gryoRotatePID.getTurnSpeed();
        double rightSpeed = -gryoRotatePID.getTurnSpeed();

        Robot.m_robotbase.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {

        return gryoRotatePID.onTarget();
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTankDrive();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
