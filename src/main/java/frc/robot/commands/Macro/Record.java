package frc.robot.commands.Macro;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Record extends Command {

    public File file;
    private String fileName;
    private FileWriter writer;
    private long startTime;
    private boolean stop;

    public Record(String fileName) throws IOException {
        this.fileName = fileName + ".txt";
        file = new File(this.fileName);
        writer = new FileWriter(file);
    }

    @Override
    protected void initialize() {
        startTime = System.currentTimeMillis();
        stop = true;
    }

    @Override
    protected void execute() {
        try {
            if (file.createNewFile()) {
                // start each "frame" with the elapsed time since we started recording
                writer.append("" + (System.currentTimeMillis() - startTime));

                // in this chunk, use writer.append to add each type of data you want to record to the frame
                // drive motors
                writer.append("," + Robot.m_robotbase.frontLeftMotor.getMotorOutputPercent());
                writer.append("," + Robot.m_robotbase.rearLeftMotor.getMotorOutputPercent());
                writer.append("," + Robot.m_robotbase.frontRightMotor.getMotorOutputPercent());
                writer.append("," + Robot.m_robotbase.rearRightMotor.getMotorOutputPercent());

                // lift motors
                writer.append("," + Robot.m_lift.liftMotor.getMotorOutputPercent());

                writer.append("\n");
            } else {
                stop = true;
            }
        } catch (IOException exc) {
            stop = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return stop;
    }

    @Override
    protected void end() {
        try {
            writer.close();
        } catch (IOException exc) {
            System.out.println("Recording was unsuccessful");
        }
    }

    @Override
    protected void interrupted() {
        end();
    }
}
