package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class RunShooterQueueSequence extends Command {
    public RunShooterQueueSequence() {
        requires(superStructure.getShooterQueue());
    }

    protected void initialize() {

    }

    protected void execute() {
        if(superStructure.getShooterQueue().readyForNextState())
        {
            superStructure.getShooterQueue().nextState();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
        super.interrupted();
    }
}
