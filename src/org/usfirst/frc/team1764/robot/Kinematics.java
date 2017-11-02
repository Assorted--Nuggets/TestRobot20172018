package org.usfirst.frc.team1764.robot;

public class Kinematics {
    /*
    This function is used to calculate the expected position and orientation of the robot given
    left and right speeds
     */
    public static Twist2d forwardKinematics(double left, double right, double angle, double drad, double dt)
    {
        double tangentialVelocity = (left + right)/2.0;     // tangential velocity on uniform circular motion
        Vector2d v = Vector2d.genVectorFromMagnitude(tangentialVelocity, angle).scale(dt);
        return new Twist2d(v, new Vector2d(drad));
    }

    /*
    This function is used to move the robot to a specified position by using the current position and final position
    to find a path to take and calculates left and right speeds to be used on the drivetrain
     */
    public static double[] inverseKinematics(RobotPose currentPose, RobotPose desiredPose)
    {
        Twist2d t = desiredPose.sub(currentPose);   // Subtract the two poses to get a Twist2d
        double deltaTheta = t.getDeltaTheta();      // Get the change in orientation angle
        double dv = deltaTheta/2;

        // return left and right speeds in an array
        return new double[] {t.getDeltaPos().getY()-dv, t.getDeltaPos().getY()+dv};

    }
}
