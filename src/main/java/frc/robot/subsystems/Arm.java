package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UseArmWithJoysticks;

/**
 * The Arm subsystem
 * The portion of the robot that grabs cubes
 */
public class Arm extends Subsystem {

    /**
     * Definition of Solenoids
     * Solenoids in this program will have the 's' prefix
     */
//	private Solenoid sClawLifterA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelA);
//	private Solenoid sClawLifterB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawLifterChannelB);
//	private Solenoid sClawA = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelA);
//	private Solenoid sClawB = new Solenoid(RobotMap.pcmModule, RobotMap.sClawChannelB);
//	private Solenoid sCatchA = new Solenoid(RobotMap.pcmModule, 6);
//	private Solenoid sCatchB = new Solenoid(RobotMap.pcmModule, 7);

    public Arm() {
    	super("Arm");
        System.out.println("Arm Initiated");
    }

    /**
     * The default command that the subsystem reverts to
     * when the subsystem is idle (the command currently
     * required the system completes).
     */
    public void initDefaultCommand() {
    	setDefaultCommand(new UseArmWithJoysticks());
    }
    
    /**
     * Punches with the arm, used to put the hatch panel on the velcro hatch
     * @author Team 61 Programming
     */
    public void punchArm() {
        //TODO: Implement punchArm method
    }
    
    /**
     * retracts the arm
     * @author Team 61 Programming
     */
    public void retractArm() {
        //TODO: Implement retractArm method
    }
    
    /**
     * Lowers the arm. Primarily used when hatch panel
     * is attached and arm must be retracted
     * @author Team 61 Programming
     */
    public void lowerArm() {
        //TODO: Implement lowerArm method
    }
}

