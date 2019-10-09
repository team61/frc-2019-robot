package frc.robot.vision;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class M_I2C {

    private static I2C Wire = new I2C(Port.kOnboard, 4); //uses the i2c port on the RoboRIO

    private static final int MAX_BYTES = 32;

    // Writes data to the arduino
    public void write(String input) {

        char[] CharArray = input.toCharArray(); //creates a char array from the input string
        byte[] WriteData = new byte[CharArray.length]; //creates a byte array from the char array

        // Converts char elements to byte elements for the arduino
        for (int i = 0; i < CharArray.length; i++) {
            WriteData[i] = (byte) CharArray[i];
        }

        // Sends each byte to arduino
        Wire.transaction(WriteData, WriteData.length, null, 0);
    }

    // Method to data from the arduino
    private String read() {
        byte[] data = new byte[MAX_BYTES]; // Creates a byte array to hold the incoming data
        Wire.read(4, MAX_BYTES, data); // Uses address 4 on i2c to store it in the data array
        String output = new String(data); // Creates a string from the byte array

        // Cycles through data
        int pt = output.indexOf((char)255);
        return (String) output.subSequence(0, pt < 0 ? 0 : pt);
    }

    // Reads data form the arudiono with read(); then stores it with a PixyPacket
    public PixyPacket getPixy() {

        // This command adds elements to the info array
        String[] info = read().split("\\|"); // The "|" character splits up the data

        // Creates a new pixy packet to hold the data
        PixyPacket pkt = new PixyPacket();

        // Checks to make sure there is data
        if (info[0].equals("none") || info[0].equals("")) {
            System.out.println("NO DATA FROM ARDIUNO");
            // The values will never be -1 normally so it's used as a placeholder
            pkt.setX(-1);
            pkt.setY(-1);
            pkt.setWidth(-1);
        } else if (info.length == 3) {
            System.out.println("DATA FROM ARDUINO");
            pkt.setX(Double.parseDouble(info[0]));
            pkt.setY(Double.parseDouble(info[1]));
            pkt.setWidth(Double.parseDouble(info[2]));
        }

        return pkt;
    }
}
