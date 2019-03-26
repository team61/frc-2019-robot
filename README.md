# 2018 First Robotics Robot

FIRST Robotics Competition is the ultimate Sport for the MindTM, where imagination and innovation come together! By combining the excitement of sport and beauty of art with the rigors of science and technology, teams of high school students (ages 14 - 18/grades 9 - 12) are challenged to design a team “brand,” hone teamwork skills, and build and program robots to perform tasks against a field of competitors.

Teams work together to build, program and test robots with the guidance of adult mentors. Teams then compete with their robots as family and friends cheer from the stands at more than 160 events worldwide – all leading up to the 2018 FIRST Championship, April 18 - 21 in Houston, TX and April 25 - 28 in Detroit, MI.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


### Prerequisites

What things you need to install the software and how to install them

1. FRC 2018 Update Suite (http://www.ni.com/download/first-robotics-software-2015/5112/en/)
2. Java SE Development Kit 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
3. Eclipse IDE For Java Developers (http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygen2)
4. CTRE Toolsuite v4_Legacy (http://www.ctr-electronics.com/hro.html#product_tabs_technical_resources)
5. FRC Plugins
<!-- ```
Give examples
``` -->

### Installing

A step by step installation guide to run this program on the Team 61 FRC Robot

1. Get the FRC 2019 Update Suite by visiting [their website](http://www.ni.com/download/first-robotics-software-2015/5112/en/) and downloading the Update Suite. A encryption key may be necessary, if so, for 2018 it is: pLaY&4%R3aL!. Be sure to uninstall any previous version of National Instruments software before starting. Extract the package that you have downloaded, and run the installer. For testing purposes, it is not necessary to activate the software if asked.

2. Download the installer for the Java SE Development Kit 8 (any other version will not function properly with the 2017/2018 code) from [this website.](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) Make sure that the version downloaded fit the operating system of the computer you are testing on. Run the installer.

3. Next, download the installer for the Eclipse IDE for Java developers from [this website.](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygen2) Run the installer.

4. Java SE Development Kit 8 must now be selected for use in Eclipse. To do this, open Eclipse, and click
```
Window > Prefrences > Java > Installed JRES > Select "jdk1.8.0"
```
make sure that the JRE is not being used as this will not function for FRC robot code.

5. The next step is to install the FRC Plugins for use with Java Programming. To do this, open Eclipse and click
```
Help > Install New Software > Click the "Add" Button
```
for the name, type "FRC Plugins," and for the location, type "http://first.wpi.edu/FRC/roborio/release/eclipse/."

6. Next, download the installer for the CTRE Toolsuite Legacy v4 from [this website.](http://www.ctr-electronics.com/hro.html#product_tabs_technical_resources) We began programming in 2017, and many of the methods used are now deprecated, which is why the Legacy version is being used.

## Deployment

To run the robot code, connect your computer to the RoboRIO, either by USB or Ethernet/radio. Next, in Eclipse, right click the file titled "robot.java" and selected
```
Run As > WPILib Java Deploy
```
the console in Driver Station is very helpful in debugging issues in a scenario where this does not properly work. Many messages are outputted throughout the code to help in these situations.

## Built With

* [Java JDK](http://www.oracle.com/technetwork/java/javase/overview/index.html) - The language we used
* [WPILib](http://first.wpi.edu/FRC/roborio/release/docs/java/) - Libraries to program the FRC Robot

## Contributing

Since the season is close to over, we will most likely archive this project from further contributions.

## Authors

* **Thomas Buckley** - *Programmer* - [thomasbuckley](https://github.com/thomasabuckley)
* **Kevin Downing** - *Shadowed Programmers* - [KevinDowning](https://github.com/KevinDowning)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Thanks to the [previous 2015 Team 61 Programming Team](https://github.com/BVT-Team-61) for their helpful documentation and source code