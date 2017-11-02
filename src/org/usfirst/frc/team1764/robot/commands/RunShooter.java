package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class RunShooter extends Command {
    public RunShooter() {
        requires(superStructure.getShooter());
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getShooter().setSpeed(0.65);

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        superStructure.getShooter().setSpeed(0);

    }

    protected void interrupted() {
        superStructure.getShooter().setSpeed(0);
        super.interrupted();
    }
}
