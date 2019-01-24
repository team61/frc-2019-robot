
package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.AutoGroup;
import frc.robot.commands.GlobalCommand;
import frc.robot.subsystems.DriveTrain;

/**
 * Main Robot class
 */
public class Robot extends TimedRobot {

	private static OI oi;
	
    private final String teamNo = "   61";
    private final String versionNo = "1-24-2019";

	private Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		
	    // Initialize all subsystems
	    GlobalCommand.init();
		
        CameraServer.getInstance().startAutomaticCapture();

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
		autonomousCommand = new AutoGroup();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
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
		if (autonomousCommand != null) autonomousCommand.cancel();
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
