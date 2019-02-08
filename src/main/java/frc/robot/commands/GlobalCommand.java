package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.TorqueLift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.switches.*;


public abstract class GlobalCommand extends Command {

    public static OI oi;
    
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Lift lift = new Lift();
	public static final Arm arm = new Arm();
	public static final TorqueLift torquelift = new TorqueLift();
	public static final Switch limitSwitchFrontA = new LimitSwitchFrontA();
    public static final Switch limitSwitchFrontB = new LimitSwitchFrontB();
    public static final Switch limitSwitchFrontC = new LimitSwitchFrontC();
    public static final Switch limitSwitchRearA = new LimitSwitchRearA();
    public static final Switch limitSwitchRearB = new LimitSwitchRearB();
    public static final Switch limitSwitchRearC = new LimitSwitchRearC();
//    public static final Switch limitSwitchArmA = new LimitSwitchArmA();
//    public static final Switch limitSwitchArmB = new LimitSwitchArmB();
//    public static final Switch limitSwitchArmC = new LimitSwitchArmC();
	
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
    }
    
    public GlobalCommand(String name) {
        super(name);
    }

    public GlobalCommand() {
        super();
    }
}
