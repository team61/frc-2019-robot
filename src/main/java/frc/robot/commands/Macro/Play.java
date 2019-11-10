package frc.robot.commands.Macro;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Play extends Command {

    private Scanner scanner;
    private File file;

    private long startTime;
    private boolean onTime = true;
    private double time;
    private boolean ended = false;

    public Play(File file) {
        requires(Robot.m_robotbase);
        requires(Robot.m_lift);
        this.file = file;
    }

    @Override
    protected void initialize() {
        try {
            scanner = new Scanner(file);
        } catch (IOException exc) {
            ended = true;
        }
        // let scanner know that the numbers are separated by a comma or a newline, as it is a .csv file
        scanner.useDelimiter(",|\\n");

        // set start time to the current time you begin autonomous
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void execute() {
        if (scanner.hasNextDouble()) {
            double delta;
            if (onTime) {
                time = scanner.nextDouble();
            }
            delta = time - (System.currentTimeMillis() - startTime);
            if (delta <= 0) {
                //for 2015 robot. these are all the motors available to manipulate during autonomous.
                //it is extremely important to set the motors in the SAME ORDER as was recorded in BTMacroRecord
                //otherwise, motor values will be sent to the wrong motors and the robot will be unpredicatable

                // drive motors
                Robot.m_robotbase.frontLeftMotor.set(ControlMode.PercentOutput, scanner.nextDouble());
                Robot.m_robotbase.rearLeftMotor.set(ControlMode.PercentOutput, scanner.nextDouble());
                Robot.m_robotbase.frontRightMotor.set(ControlMode.PercentOutput, scanner.nextDouble());
                Robot.m_robotbase.rearRightMotor.set(ControlMode.PercentOutput, scanner.nextDouble());

                // lift motors
                Robot.m_lift.liftMotor.set(ControlMode.PercentOutput, scanner.nextDouble());
                onTime = true;
            } else {
                onTime = false;
            }
        } else {
            scanner.close();
            ended = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return ended;
    }

    @Override
    protected void end() {
        Robot.m_robotbase.stopTankDrive();
        Robot.m_lift.stopLift();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
