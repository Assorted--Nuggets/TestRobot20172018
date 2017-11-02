package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team1764.robot.RobotMap;

public class GyroAccelCombo extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Gyro gyro;
    private Accelerometer accel;

    private double angle;

    private long lastTime;

    public GyroAccelCombo()
    {
        this.gyro = new AnalogGyro(RobotMap.PORT_GYRO);
        this.accel = new BuiltInAccelerometer();
        this.angle = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public void reset()
    {
        gyro.reset();
        this.angle = 0;
    }

    public void update()
    {
        angle = gyro.getAngle();
    }

    public double getAngle()
    {
        update();
        return angle;
    }

    public double getRate()
    {
        return gyro.getRate();
    }

    public void compFilter()
    {
        double deltaTime = System.currentTimeMillis() - lastTime;
        angle = 0.98*(angle + gyro.getRate()*deltaTime) + 0.02*accel.getX();
    }


    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

