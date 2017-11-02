package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team1764.robot.subsystems.SuperStructure;

public class Robot extends IterativeRobot {
    public static OI oi;
    public static SuperStructure superStructure;
    Command autoCommand;

    @Override
    public void robotInit() {
        oi = new OI();
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        if (autoCommand != null)
            autoCommand.start();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autoCommand != null)
            autoCommand.cancel();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
