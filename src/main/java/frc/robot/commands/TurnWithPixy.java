package frc.robot.commands;

import frc.robot.M_I2C;
import frc.robot.PixyPacket;

public class TurnWithPixy extends GlobalCommand {
    private M_I2C i2c;
    private PixyPacket pkt;
    private long startTime;
    private int TIME_TO_RUN = 5000; // milliseconds
    private double SPEED = .2;
    double CENTER = 157.5;
    private boolean finished;

    public TurnWithPixy() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        i2c = new M_I2C(); //setup the i2c interface
        pkt = i2c.getPixy();//create a pixy packet to hold data
        finished = false;
        startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(pkt.x != -1){//if data is exist
            System.out.println("XPos: " + pkt.x);//print the data just to see
            if ((CENTER - pkt.x) > 8) {
                System.out.println("turning left");
                drivetrain.moveLeftMotorStack(SPEED);
                drivetrain.moveRightMotorStack(-SPEED);
                // TURN LEFT
            } else if ((CENTER - pkt.x) < 8) {
                System.out.println("turning right");
                drivetrain.moveLeftMotorStack(-SPEED);
                drivetrain.moveRightMotorStack(SPEED);
                // TURN RIGHT
            } else {
                finished = true;
            }

        }
        pkt = i2c.getPixy();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime > TIME_TO_RUN) || finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("PixyTurn ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
