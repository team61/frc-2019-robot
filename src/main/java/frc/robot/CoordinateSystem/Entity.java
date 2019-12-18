package frc.robot.CoordinateSystem;

public class Entity extends Object{
    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;

    private double velocityX;
    private double velocityY;
    private double velocityZ;

    private double forceX;
    private double forceY;
    private double forceZ;

    public Entity(double cordsX, double cordsY, double cordsZ) {
        super(cordsX, cordsY, cordsZ);
        accelerationX = 0;
        accelerationY = 0;
        accelerationZ = 0;

        velocityX = 0;
        velocityY = 0;
        velocityZ = 0;

        forceX = 0;
        forceY = 0;
        forceZ = 0;
    }

    public double getAccelerationX() {
        return accelerationX;
    }

    public double getAccelerationY() {
        return accelerationY;
    }

    public double getAccelerationZ() {
        return accelerationZ;
    }

    public void setAccelerationX(double accelerationX) {
        this.accelerationX = accelerationX;
    }

    public void setAccelerationY(double accelerationY) {
        this.accelerationY = accelerationY;
    }

    public void setAccelerationZ(double accelerationZ) {
        this.accelerationZ = accelerationZ;
    }

    public void setAccelerations(double accelerationX, double accelerationY, double accelerationZ) {
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
        this.accelerationZ = accelerationZ;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getVelocityZ() {
        return velocityZ;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityZ(double velocityZ) {
        this.velocityZ = velocityZ;
    }

    public void setVelocities(double velocityX, double velocityY, double velocityZ) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    public double getForceX() {
        return forceX;
    }

    public double getForceY() {
        return forceY;
    }

    public double getForceZ() {
        return forceZ;
    }

    public void setForceX(double forceX) {
        this.forceX = forceX;
    }

    public void setForceY(double forceY) {
        this.forceY = forceY;
    }

    public void setForceZ(double forceZ) {
        this.forceZ = forceZ;
    }

    public void setForces(double forceX, double forceY, double forceZ) {
        this.forceX = forceX;
        this.forceY = forceY;
        this.forceZ = forceZ;
    }
}
