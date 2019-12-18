package frc.robot.subsystems.Main;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.CoordinateSystem.Player;
import frc.robot.commands.Map.UpdatePlayerInfo;

public class Map extends Subsystem {
    private int length;
    private int height;

    public static Player m_player;

    public Map(int length, int height) {
        super("Map");
        this.length = length;
        this.height = height;
        m_player = new Player(0, 0, 0);
    }
    public Map() {
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new UpdatePlayerInfo());
    }
}
