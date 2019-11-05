
package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

/**
 * Main Robot class
 */
public class Robot extends TimedRobot {

    // Establishes all major subsystems and OI to provide basic functions to the robot
    public static DriveTrain drivetrain = new DriveTrain();
    public static Lift lift = new Lift();
    public static Arm arm = new Arm();
    public static TorqueLift torquelift = new TorqueLift();
    public static VisionCam visioncam = new VisionCam();

    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        final String teamNo = "   61";
        final String versionNo = "4-5-2019";
        torquelift.setPTOState(false);
        oi = new OI();

        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(160, 120);

        System.out.println("+----------------------------------------------+");
        System.out.println("| Team "+teamNo+" - Software Version: "+versionNo+" |");
        System.out.println("+----------------------------------------------+");
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {
        System.out.println("Disabled Intitiated");
    }

    /**
     * This function is called periodically during disabled mode
     */
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called initially when autonomous starts
     */
    public void autonomousInit() {
        /*No autonomous period in the 2019 DEEP SPACE game*/
        System.out.println("Autonomous Initiated");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called initially when teleop starts
     */
    public void teleopInit() {
        // stop the autonomous as soon as teleop starts
        System.out.println("Teleop Initiated");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        // nothing
    }

    public static void main(String[] args) {
        TimedRobot.startRobot(Robot::new);
    }
}
//Baraka add this comment