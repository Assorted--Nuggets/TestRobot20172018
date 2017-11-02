package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;
public class RunShooterQueue extends Command {
    public RunShooterQueue() {
        requires(superStructure.getShooterQueue());
    }

    protected void initialize() {

    }

    protected void execute() {
        switch (superStructure.getShooterQueue().getCurrentState()) {
            case IDLE:
                superStructure.getQueue().setSpeed(0);
                superStructure.getShooter().setSpeed(0);
                break;
            case WINDUP:
                superStructure.getShooter().setSpeed(1);
                break;
            case SHOOTING:
                superStructure.getQueue().setSpeed(1);
                break;
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
