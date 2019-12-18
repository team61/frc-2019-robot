package frc.robot.CoordinateSystem;

public abstract class Object {
    private double cordsX;
    private double cordsY;
    private double cordsZ;

    public Object(double cordsX, double cordsY, double cordsZ) {
        this.cordsX = cordsX;
        this.cordsY = cordsY;
        this.cordsZ = cordsZ;
    }

    public double getCordsX() {
        return cordsX;
    }

    public double getCordsY() {
        return cordsY;
    }

    public double getCordsZ() {
        return cordsZ;
    }

    public void setCordsX(double cordsX) {
        this.cordsX = cordsX;
    }

    public void setCordsY(double cordsY) {
        this.cordsY = cordsY;
    }

    public void setCordsZ(double cordsZ) {
        this.cordsZ = cordsZ;
    }

    public void setCords(double cordsX, double cordsY, double cordsZ) {
        this.cordsX = cordsX;
        this.cordsY = cordsY;
        this.cordsZ = cordsZ;
    }
}
