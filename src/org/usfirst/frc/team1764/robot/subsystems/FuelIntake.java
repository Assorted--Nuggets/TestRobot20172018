package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class FuelIntake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Spark intakeMotor;
    public FuelIntake()
    {
        this.intakeMotor = new Spark(RobotMap.PORT_FUEL_INTAKE);
    }

    public void setSpeed(double speed)
    {
        this.intakeMotor.setSpeed(speed);
    }


    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

