package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.GrabWithJoysticks;
//import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Claw subsystem
 * The portion of the robot that grabs cubes
 */
public class Claw extends Subsystem {

    /**
     * Definition of Solenoids
     * Solenoids in this program will have the 's' prefix
     */
	private Solenoid sClawLifterA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelA);
	private Solenoid sClawLifterB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelB);
	private Solenoid sClawA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelA);
	private Solenoid sClawB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelB);
	private Solenoid sCatchA = new Solenoid(RobotMap.pcmModule, 6);
	private Solenoid sCatchB = new Solenoid(RobotMap.pcmModule, 7);

    public Claw() {
    	super("Claw");
        System.out.println("Claw Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new GrabWithJoysticks());
    }
    
    /**
     * Opens the claw using solenoids
     * @author Team 61 Programming
     */
    public void openClaw() {
    	sClawA.set(false);
    	sClawB.set(true);
    }
    
    /**
     * Closes the claw using solenoids
     * @author Team 61 Programming
     */
    public void closeClaw() {
    	sClawA.set(true);
    	sClawB.set(false);
    }
    
    /**
     * Lifts the claw using solenoids
     * @author Team 61 Programming
     */
    public void liftClaw() {
    	sClawLifterA.set(false);
    	sClawLifterB.set(true);
    }
    
    /**
     * Lowers the claw using solenoids
     * @author Team 61 Programming
     */
    public void lowerClaw() {
    	sClawLifterA.set(true);
    	sClawLifterB.set(false);
    }
    
    /**
     * Drops catch for robots (this was removed in competition)
     * @author Team 61 Programming
     */
    public void releaseCatch() {
    	sCatchA.set(false);
    	sCatchB.set(true);
    }
    
    /**
     * Resets catch for robots (this was removed in competition)
     * @author Team 61 Programming
     */
    public void removeCatch() {
    	sCatchA.set(true);
    	sCatchB.set(false);
    }
}

