package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotPose;
import org.usfirst.frc.team1764.robot.commands.DriveTeleop;

public class SuperStructure extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Drivetrain drivetrain;
    FuelIntake fuelIntake;
    Queue queue;
    Shooter shooter;
    ShooterQueue shooterQueue;
    CameraTracker cameraTracker;



    public SuperStructure()
    {
        this.drivetrain = new Drivetrain();
        this.fuelIntake = new FuelIntake();
        this.queue = new Queue();
        this.shooter = new Shooter();
        this.shooterQueue = new ShooterQueue(queue, shooter);
        this.cameraTracker = new CameraTracker();
    }


    public Drivetrain getDrivetrain()
    {
        return drivetrain;
    }

    public FuelIntake getFuelIntake()
    {
        return fuelIntake;
    }

    public Queue getQueue()
    {
        return queue;
    }

    public Shooter getShooter()
    {
        return shooter;
    }

    public ShooterQueue getShooterQueue()
    {
        return shooterQueue;
    }

    public CameraTracker getCameraTracker()
    {
        return cameraTracker;
    }
    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveTeleop());
    }
}

