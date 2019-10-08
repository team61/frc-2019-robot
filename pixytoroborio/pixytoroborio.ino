#include <Wire.h>

//built in class from arduino, strongly suggest looking at it on their website
//it is not a complicated class

#include <Pixy2.h>

//this is provided by the pixy creators, you will have to go to the arduino sketch editor, 
//click sketch, include library, and import the pixy .zip files

//SETUP THE DEVICES

//plug sda on RoboRIO into A4
//plug scl on RoboRIO into A5
//connect the two grounds


String output = "none";//string to be sent to the robot

int i; 
int xCenter;
int yCenter;
               
String input = "blank";  //string received from the robot
const String PIXY = "pi";
Pixy2 pixy;

void setup(){
  Serial.begin(9600);
  Wire.begin(4);                // join i2c bus with address #4 as a slave device
  Wire.onReceive(receiveEvent); // Registers a function to be called when a slave device receives a transmission from a master
  Wire.onRequest(requestEvent); // Register a function to be called when a master requests data from this slave device
  pixy.init();
}

void loop(){
  // grab blocks!
  pixy.ccc.getBlocks();
  
  // If there are detect blocks, print them!
   if (pixy.ccc.numBlocks == 2) {
    int xValues[2]; //an array with two values. value 0 is the leftmost block and value 1 is the rightmost block
    int yValues[2];
    for (i=0; i<pixy.ccc.numBlocks; i++)
    {
      xValues[i] = pixy.ccc.blocks[i].m_x;
      yValues[i] = pixy.ccc.blocks[i].m_y;
      Widths[i] = pixy.ccc.blocks[i].m_width;
    }

    xCenter = (abs(xValues[1] + xValues[0]))/2;
    yCenter = (abs(yValues[1] + yValues[0]))/2;
    Width = abs(xValues[1] - yValue[0]) + (Widths[1] + Widths[0])/2;

    Serial.print("xCenter: ");
    Serial.println(xCenter);

    Serial.print("yCenter: ");
    Serial.println(yCenter);

    Serial.println("Width: ");
    Serial.println(Width);
    Serial.println("TWO BLOCKS DETECTED");
    
    output = String(xCenter);
    output += "|";
    output += String(yCenter);
    output += "|";
    output += String(Width);
    
  } else {
    output = "none"; //if no blocks tell roborio there are none
    Serial.println("no blocks");
  }
  
  if (pixy.ccc.numBlocks < 2) {
    Serial.println("TOO FEW OBJECTS DETECTED");
  }

  if (pixy.ccc.numBlocks > 2) {
    Serial.println("TOO MANY OBJECTS DETECTED");
  }

  delay(70); //gives time for everything to process
}

void requestEvent(){//called when RoboRIO request a message from this device
  Wire.write(output.c_str()); //writes data to the RoboRIO, converts it to string

}

void receiveEvent(int bytes){//called when RoboRIO "gives" this device a message

}
