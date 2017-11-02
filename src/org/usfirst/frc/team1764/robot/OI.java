package org.usfirst.frc.team1764.robot;

public class OI {
    Controller c;
    public OI() {
        c  = new Joy(0);
    }

    public double getThrottle()
    {
        return c.getThrottle();
    }
    public double getTurn()
    {
        return c.getTurn();
    }
}
