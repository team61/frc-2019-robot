package frc.robot.vision;

public class PixyPacket {
    private double x, y, width;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    //for our use we only cared about a x, y, and area
    //you could get any data you wanted
}
