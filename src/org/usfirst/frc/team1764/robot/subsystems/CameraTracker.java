package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CameraTracker extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    NetworkTable cameraTrackData;

    public CameraTracker()
    {
        cameraTrackData = NetworkTable.getTable("cameradata");

    }

    public double getTargetAngleX()
    {
        return cameraTrackData.getNumber("targetAngleX", 0);
    }

    public double getTargetAngleY()
    {
        return cameraTrackData.getNumber("targetAngleY", 0);
    }

    public double getTargetDistance()
    {
        return cameraTrackData.getNumber("targetDist", 0);
    }


    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }
}

