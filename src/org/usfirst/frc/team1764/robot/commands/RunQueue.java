package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;
public class RunQueue extends Command {
    public RunQueue() {
        requires(superStructure.getQueue());
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getQueue().setSpeed(1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        superStructure.getQueue().setSpeed(0);

    }

    protected void interrupted() {
        superStructure.getQueue().setSpeed(0);
        super.interrupted();
    }
}
