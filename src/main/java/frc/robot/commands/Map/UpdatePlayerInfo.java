package frc.robot.commands.Map;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Main.Map;

public class UpdatePlayerInfo extends Command {
    private double startDistance;
    private long startTime;
    public UpdatePlayerInfo() {
        requires(Robot.m_map);
    }

    @Override
    protected void initialize() {
        Robot.m_robotbase.resetEncoders();
        startDistance = 0;
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void execute() {

        double distanceTraveled = Robot.m_robotbase.getDistanceTraveled() - startDistance;

        Map.m_player.setCords(
                Map.m_player.getCordsX() + distanceTraveled * Math.cos(Robot.m_navigation.getYaw()),
                Map.m_player.getCordsY() + distanceTraveled * Math.sin(Robot.m_navigation.getYaw()),
                Map.m_player.getCordsZ() + ((Robot.m_robotbase.getPTOState()) ? distanceTraveled : 0));

        System.out.print("X: " + Map.m_player.getCordsX());
        System.out.print(", Y: " + Map.m_player.getCordsY());
        System.out.print(", Z: " + Map.m_player.getCordsZ());
        System.out.println(", Angle: " + Robot.m_navigation.getYaw());

        Map.m_player.setAccelerations(
                Robot.m_navigation.getAccelerationX(),
                Robot.m_navigation.getAccelerationY(),
                Robot.m_navigation.getAccelerationZ());

        long time = System.currentTimeMillis() - startTime;
        double addedVelocity = distanceTraveled / time;

        Map.m_player.setVelocities(
                Map.m_player.getVelocityX() + addedVelocity * Math.cos(Robot.m_navigation.getYaw()),
                Map.m_player.getVelocityY() + addedVelocity * Math.cos(Robot.m_navigation.getYaw()),
                Map.m_player.getVelocityZ() + ((Robot.m_robotbase.getPTOState()) ? addedVelocity : 0));


        startDistance = Robot.m_robotbase.getDistanceTraveled();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected boolean isFinished() {
        return false;
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
