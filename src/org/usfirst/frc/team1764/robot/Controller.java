package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1764.robot.commands.RunFuelIntake;
import org.usfirst.frc.team1764.robot.commands.ShooterQueueNextState;

public abstract class Controller {
    Joystick j;
    JoystickButton fuelIntakeButton;
    JoystickButton shooterQueueButton;
    JoystickButton shiftUpButton;
    JoystickButton shiftDownButton;

    public Controller(int port)
    {
        this.j = new Joystick(port);
    }

    public void initButtonActions()
    {
        fuelIntakeButton.whenActive(new RunFuelIntake());
        shooterQueueButton.whenActive(new ShooterQueueNextState());

    }

    public abstract double getThrottle();
    public abstract double getTurn();
}
