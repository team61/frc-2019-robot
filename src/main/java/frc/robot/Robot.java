
package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Main.Arm;
import frc.robot.subsystems.Main.Lift;
import frc.robot.subsystems.Main.Navigation;
import frc.robot.subsystems.Main.RobotBase;

/**
 * Main Robot class
 */
public class Robot extends TimedRobot {

    public static Lift m_lift;
    public static Arm m_arm;
    public static RobotBase m_robotbase;
    public static Navigation m_navigation;

    public static OI m_oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        final String teamNo = "   61";
        final String versionNo = "4-5-2019";
        m_lift = new Lift();
        m_arm = new Arm();
        m_robotbase = new RobotBase();
        m_navigation = new Navigation();

        m_oi = new OI();

        // Initialize all subsystems

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
        // instantiate the command used for the autonomous period (the chooser on the smart dashboard will pick this)
//		autonomousCommand = new AutoGroup();

        // schedule the autonomous command (example)
//		if (autonomousCommand != null) autonomousCommand.start();
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
