package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

import static edu.wpi.first.wpilibj.PIDSourceType.kDisplacement;
import static frc.robot.Robot.drivetrain;
import static frc.robot.Robot.visioncam;

public class MoveToTarget extends Command {

    private PIDController TurnPID;
    private PIDController SlowDownPID;
    public double turnSpeed;
    private double driveSpeed;
    private final double slowdownSensitivity = 2;
    private final int CENTER = 158;

    public MoveToTarget() {
        // Use requires() here to declare subsystem dependencies
        requires(visioncam);
        requires(drivetrain);

        /**
         * Turn PID implementation - calculates error of turning
         * using filtered vision camera data as imput for the PID
         * loop. PIDOutput (the output of the PID loop) is assigned
         * to turnSpeed double. Uses lambda to replace anonymous
         * override of the PIDOutput() abstract class, which solely
         * assigns the output of the PIDController loop to an object.
         */
        TurnPID = new PIDController(0.00633, 0, 0, new PIDSource() {

            PIDSourceType pidSource;
            public void setPIDSourceType(PIDSourceType pidSource) {
                pidSource = kDisplacement;
                this.pidSource = pidSource;
            }

            public PIDSourceType getPIDSourceType() {
                return pidSource;
            }

            public double pidGet() {
                return CENTER - visioncam.getPixy().getX();
            }
        }, output -> turnSpeed = output);

        /**
         * Drivespeed PID implementation - refer to above documentation.
         */
        SlowDownPID = new PIDController(0.0714, 0, 0, new PIDSource() {

            PIDSourceType pidSource;
            public void setPIDSourceType(PIDSourceType pidSource) {
                pidSource = kDisplacement;
                this.pidSource = pidSource;
            }

            public PIDSourceType getPIDSourceType() {
                return pidSource;
            }

            public double pidGet() {
                return visioncam.getPixy().getWidth();
            }
        }, output -> driveSpeed = output/(output + slowdownSensitivity));

        // Setting Absolute Values of PID Controllers
        TurnPID.setAbsoluteTolerance(0.05);
        SlowDownPID.setAbsoluteTolerance(0.05);

        TurnPID.setInputRange(0, 316);
        SlowDownPID.setInputRange(100, 200);

        TurnPID.setOutputRange(-1, 1);
        SlowDownPID.setOutputRange(-1, 1);

        TurnPID.setSetpoint(CENTER);
        SlowDownPID.setSetpoint(155);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        TurnPID.enable();
        SlowDownPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // drives robot based on PID values calculated from analysis of vision cam
        double speedLeft = driveSpeed + turnSpeed;
        double speedRight = driveSpeed - turnSpeed;
        drivetrain.tankDrive(speedLeft, speedRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (TurnPID.onTarget() && SlowDownPID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("ended");
        TurnPID.reset();
        SlowDownPID.reset();
        drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }

}