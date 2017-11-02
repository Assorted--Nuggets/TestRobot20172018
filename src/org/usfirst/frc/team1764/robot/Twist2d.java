package org.usfirst.frc.team1764.robot;

public class Twist2d {
    private Vector2d deltaPos;
    private Vector2d deltaHeading;
    private double deltaTheta;

    public Twist2d(Vector2d deltaPos, Vector2d deltaHeading)
    {
        this.deltaPos = deltaPos;
        this.deltaHeading = deltaHeading;
        this.deltaTheta = deltaHeading.getAngle();
    }

    public Twist2d(RobotPose initialPose, RobotPose finalPose)
    {
        this.deltaPos = finalPose.getPosition().sub(initialPose.getPosition());
        this.deltaHeading = finalPose.getHeading().sub(initialPose.getHeading());
        this.deltaTheta = deltaHeading.getAngle();
    }

    public Vector2d getDeltaPos()
    {
        return deltaPos;
    }
    public Vector2d getDeltaHeading()
    {
        return deltaHeading;
    }

    public double getDeltaTheta()
    {
        return deltaTheta;
    }
}
