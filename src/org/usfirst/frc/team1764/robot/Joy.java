package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Joy extends Controller {
    public Joy(int port)
    {
        super(port);
        this.fuelIntakeButton = new JoystickButton(j, 2);
        this.shooterQueueButton = new JoystickButton(j, 7);
    }
    @Override
    public double getThrottle() {
        return j.getY();
    }

    @Override
    public double getTurn() {
        return j.getZ();
    }
}
