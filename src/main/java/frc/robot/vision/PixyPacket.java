package frc.robot.vision;

public class PixyPacket {

    /* More data can be collected but this is all that is need for now */
    private double x, y, width;

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setWidth(double width) { this.width = width; }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
}
