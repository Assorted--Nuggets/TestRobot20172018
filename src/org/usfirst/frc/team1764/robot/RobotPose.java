package org.usfirst.frc.team1764.robot;

public class RobotPose {
    private Vector2d position;
    private Vector2d heading;
    private Vector2d velocity;

    public RobotPose(Vector2d pos, Vector2d head, Vector2d vel)
    {
        this.position = pos;
        this.heading = head;
        this.velocity = vel;
    }

    public void addTwist(Twist2d t)
    {
        this.position = this.position.add(t.getDeltaPos());
        this.heading = this.heading.add(t.getDeltaHeading());
    }

    public Twist2d sub(RobotPose p)
    {
        return new Twist2d(this, p);
    }

    public Vector2d getPosition()
    {
        return position;
    }
    public Vector2d getHeading()
    {
        return heading;
    }

}
