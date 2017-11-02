package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.commands.RunShooterQueue;

public class ShooterQueue extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Queue queue;
    Shooter shooter;
    ShooterQueueState currentState;

    public enum ShooterQueueState
    {
        IDLE,
        WINDUP,
        SHOOTING
    }

    public ShooterQueue(Queue queue, Shooter shooter)
    {
        this.queue = queue;
        this.shooter = shooter;
        this.currentState = ShooterQueueState.IDLE;
    }

    public void nextState()
    {
        if(currentState == ShooterQueueState.IDLE)
        {
            currentState = ShooterQueueState.WINDUP;
        }
        else if(currentState == ShooterQueueState.WINDUP)
        {
            currentState = ShooterQueueState.SHOOTING;
        }
        else if(currentState == ShooterQueueState.SHOOTING)
        {
            currentState = ShooterQueueState.IDLE;
        }
    }

    public boolean readyForNextState()
    {
        switch(currentState)
        {
            case IDLE:
                return queue.hasFuel();
            case WINDUP:
                return shooter.onTarget();
            case SHOOTING:
                return !queue.hasFuel();
        }
        return false;
    }

    public ShooterQueueState getCurrentState()
    {
        return currentState;
    }


    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RunShooterQueue());
    }
}

