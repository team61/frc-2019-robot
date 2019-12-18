package frc.robot.CoordinateSystem;

public class Player extends Entity {

    private double mass;

    //private Polygon player;

    public Player(double cordsX, double cordsY, double cordsZ) {
        super(cordsX, cordsY, cordsZ);
        //player = new Polygon();
        mass = 120;
    }
}

