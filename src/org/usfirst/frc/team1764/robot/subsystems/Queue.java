package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class Queue extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Spark queueMotor;

    public Queue()
    {
        this.queueMotor = new Spark(RobotMap.PORT_QUEUE);
    }

    public void setSpeed(double speed)
    {
        this.queueMotor.set(speed);
    }

    public boolean hasFuel()
    {
        return false;
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

