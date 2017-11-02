package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class ShooterQueueNextState extends Command {

    private boolean done = false;
    public ShooterQueueNextState() {
        requires(superStructure.getShooterQueue());
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getShooterQueue().nextState();
        done = true;
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {

    }

    protected void interrupted() {
        super.interrupted();
    }
}
