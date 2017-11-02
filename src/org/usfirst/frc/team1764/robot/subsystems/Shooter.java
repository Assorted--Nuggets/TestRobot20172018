package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

public class Shooter extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Spark shooterMotor;
    Encoder encoder = new Encoder(RobotMap.PORT_SHOOTER_ENCODER_A, RobotMap.PORT_SHOOTER_ENCODER_B);

    public Shooter()
    {
        super(0.1,0.1,0.1);
        this.shooterMotor = new Spark(RobotMap.PORT_SHOOTER);
    }

    public void setSpeed(double speed)
    {
        shooterMotor.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        return encoder.getRate();
    }

    @Override
    protected void usePIDOutput(double output) {
        shooterMotor.pidWrite(output);
    }
}

