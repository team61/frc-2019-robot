package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
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
    private Solenoid sArmA = new Solenoid(RobotMap.pcmModule, RobotMap.sArmA);
    private Solenoid sArmB = new Solenoid(RobotMap.pcmModule, RobotMap.sArmB);

    private TalonSRX armMotor = new TalonSRX(RobotMap.mArm);

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
     * Sets the state of the punching arm
     * if true, it punches arm outwards. if false, it retracts arm inwards.
     * @author Team 61 Programming
     */
    public void setArmState(boolean bool) {
        // TODO: confirm states of true and false
        sArmA.set(bool);
        sArmB.set(!bool);
    }
    
    /**
     * Moves the arm.
     * @author Team 61 Programming
     */
    public void moveArm(double speed) {
        armMotor.set(ControlMode.PercentOutput, -speed);
    }

    public void stop() {
        moveArm(0.0);
    }

}

