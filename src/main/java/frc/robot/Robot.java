
package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Torquelift;

/**
 * Main Robot class
 */
public class Robot extends TimedRobot {

    public static OI oi;
    public static Drivetrain drivetrain = new Drivetrain();
    public static Lift lift;
    public static Arm arm = new Arm();
    public static Torquelift torquelift = new Torquelift();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        final String teamNo = "   61";
        final String versionNo = "4-5-2019";
        oi = new OI();
        drivetrain = new Drivetrain();
        lift = new Lift();
        arm = new Arm();
        torquelift = new Torquelift();

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
