package org.usfirst.frc.team1764.robot;

public class Vector2d {
    private double x;
    private double y;

    public Vector2d(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2d(double angle)
    {
        this.x = Math.cos(Math.toRadians(angle));
        this.y = Math.sin(Math.toRadians(angle));
    }
    public static Vector2d genVectorFromMagnitude(double mag, double angle)
    {
        double x = mag * Math.cos(Math.toRadians(angle));
        double y = mag * Math.sin(Math.toRadians(angle));
        return new Vector2d(x,y);
    }

    public Vector2d scale(double s)
    {
        this.x = this.x*s;
        this.y = this.y*s;
        return this;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y =y;
    }

    public double getAngle()
    {
        return Math.atan2(this.x, this.y);
    }

    public double getAngle(Vector2d v)
    {
        return v.getAngle() - this.getAngle();
    }

    public Vector2d sub(Vector2d v)
    {
        return new Vector2d(x-v.getX(), y-v.getY());
    }
    public Vector2d add(Vector2d v)
    {
        return new Vector2d(x+v.getX(), y+v.getY());
    }
}
