package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class FrontLift extends LSLevelSubsystem {

    public FrontLift() {
        super("Front Lift", RobotMap.LSFront);
    }
    @Override
    protected void setSpeed(double speed) {
        Robot.drivetrain.moveLeftMotorStack(-speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
