package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class RunFuelIntake extends Command {
    public RunFuelIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(superStructure.getFuelIntake());
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getFuelIntake().setSpeed(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        superStructure.getFuelIntake().setSpeed(0);
    }

    protected void interrupted() {
        superStructure.getFuelIntake().setSpeed(0);
        super.interrupted();
    }
}
