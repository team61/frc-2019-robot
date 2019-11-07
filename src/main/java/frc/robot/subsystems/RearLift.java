package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class RearLift extends LSLevelSubsystem {

    public RearLift() {
        super("Rear Lift", RobotMap.LSRear);
    }
    @Override
    protected void setSpeed(double speed) {
        Robot.drivetrain.moveRightMotorStack(-speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
