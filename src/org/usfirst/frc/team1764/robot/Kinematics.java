package org.usfirst.frc.team1764.robot;

public class Kinematics {
    public static Twist2d forwardKinematics(double left, double right, double angle, double drad, double dt)
    {
        double tangentialVelocity = (left + right)/2.0;
        Vector2d v = Vector2d.genVectorFromMagnitude(tangentialVelocity, angle).scale(dt);
        return new Twist2d(v, new Vector2d(drad));
    }

    public static double[] inverseKinematics(RobotPose currentPose, RobotPose desiredPose)
    {
        Twist2d t = desiredPose.sub(currentPose);
        double deltaTheta = t.getDeltaTheta();
        double dv = deltaTheta/2;

        return new double[] {t.getDeltaPos().getY()-dv, t.getDeltaPos().getY()+dv};

    }
}
