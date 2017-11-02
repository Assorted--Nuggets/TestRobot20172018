package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class DriveTeleop extends Command {
    public DriveTeleop() {
        requires(superStructure.getDrivetrain());
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getDrivetrain().setSpeed(-oi.getThrottle() + oi.getTurn(), oi.getThrottle() - oi.getTurn());
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
