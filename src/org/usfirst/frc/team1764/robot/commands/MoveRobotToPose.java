package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1764.robot.Kinematics;
import org.usfirst.frc.team1764.robot.RobotPose;

import static org.usfirst.frc.team1764.robot.Robot.*;
public class MoveRobotToPose extends Command {
    private RobotPose desiredPose;
    public MoveRobotToPose(RobotPose pose) {
        requires(superStructure.getDrivetrain());
        this.desiredPose = pose;
    }

    protected void initialize() {

    }

    protected void execute() {
        superStructure.getDrivetrain().updatePose();
        double[] speeds = Kinematics.inverseKinematics(superStructure.getDrivetrain().getCurrentPose(),
                desiredPose);

        superStructure.getDrivetrain().setSpeed(speeds[0], speeds[1]);
    }

    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
        super.interrupted();
    }
}
