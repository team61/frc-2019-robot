package frc.robot.commands.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.oi;
import static frc.robot.Robot.torquelift;

public class MoveRear extends Command {
    private boolean limitswitchState;
    private int level = 0;

    private double speed;
    private double speedFactor;

    public MoveRear(int Level, double Speed) {
        // Use requires() here to declare subsystem dependencies
        requires(torquelift);
        this.level = Level;
        this.speed = Speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        limitswitchState = false;
        speedFactor = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println(torquelift.LSRear[level] + ": " + torquelift.LSRear[level].isSwitchSet());
        int sign = (speed > 0) ? 1:-1;
        for (int i = 0; i < torquelift.LSFront.length - level; i++) {
            if (torquelift.LSFront[level + i * sign].isSwitchSet()) { limitswitchState = true; }
        }

        torquelift.setPTOState(true);
        if (!limitswitchState) { torquelift.moveRear(speed + speedFactor); }

        // when roll is negative, the robots front is up
        speedFactor = (torquelift.getGyroRoll() < -1) ? 0.2 : 0;

        System.out.println(torquelift.getGyroRoll());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        final double SPEED_BUFFER = 0.2;
        return ((limitswitchState)
                || (Math.abs(oi.getLeftSpeed()) > SPEED_BUFFER)
                || (Math.abs(oi.getRightSpeed()) > SPEED_BUFFER));
        // command should be killed when button 4 on arm stick is pressed or when
        // left or right joysticks are moved
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        torquelift.setPTOState(true);
        torquelift.stopFront();
        torquelift.stopRear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
