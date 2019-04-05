package frc.robot;

public class PixyTest {
    M_I2C i2c = new M_I2C();//setup the i2c interface
    PixyPacket pkt = i2c.getPixy();//create a pixy packet to hold data
    double center = 157.5;
    public void centerOnObject(){
//        if(pkt.x != -1){//if data is exist
//            System.out.println("XPos: " + pkt.x);//print the data just to see
//
//
//        }
//        pkt = i2c.getPixy();
    }
}
