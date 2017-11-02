package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team1764.robot.Robot.*;

public class TurnToAngle extends Command {
    double setpoint;
    public TurnToAngle(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(superStructure.getDrivetrain());
        this.setpoint = setpoint;
    }

    protected void initialize() {
        superStructure.getDrivetrain().setSetpoint(setpoint);

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return superStructure.getDrivetrain().onTarget();
    }

    protected void end() {
        superStructure.getDrivetrain().disable();
    }

    protected void interrupted() {
        superStructure.getDrivetrain().disable();
        super.interrupted();
    }
}
