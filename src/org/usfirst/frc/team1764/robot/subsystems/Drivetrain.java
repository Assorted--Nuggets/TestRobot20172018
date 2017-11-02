package org.usfirst.frc.team1764.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team1764.robot.Kinematics;
import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.RobotPose;
import org.usfirst.frc.team1764.robot.Vector2d;

public class Drivetrain extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANTalon leftFront, leftBack;
    private CANTalon rightFront, rightBack;
    private DoubleSolenoid shiftSolenoid;

    private Encoder leftEncoder = new Encoder(RobotMap.PORT_LEFT_ENCODER_A, RobotMap.PORT_LEFT_ENCODER_B);
    private Encoder rightEncoder = new Encoder(RobotMap.PORT_RIGHT_ENCODER_A, RobotMap.PORT_RIGHT_ENCODER_B);
    private GyroAccelCombo gyro;

    private long lastTime;

    RobotPose currentPose;

    public Drivetrain()
    {
        super("Drivetrain", 0.1, 0.0,0.1);
        this.leftFront = new CANTalon(RobotMap.PORT_LEFT_FRONT);
        this.leftBack = new CANTalon(RobotMap.PORT_LEFT_BACK);
        this.rightFront = new CANTalon(RobotMap.PORT_RIGHT_FRONT);
        this.rightBack = new CANTalon(RobotMap.PORT_RIGHT_BACK);
        this.shiftSolenoid = new DoubleSolenoid(RobotMap.PORT_SHIFT_SOLENOID_A, RobotMap.PORT_SHIFT_SOLENOID_B);
        this.gyro = new GyroAccelCombo();
        currentPose = new RobotPose(new Vector2d(0,0), new Vector2d(0,0), new Vector2d(0,0));
        lastTime = System.nanoTime();
    }

    public void updatePose()
    {
        double dt = (double)(System.nanoTime() - lastTime);
        gyro.update();
        currentPose.addTwist(Kinematics.forwardKinematics(leftEncoder.getRate(), rightEncoder.getRate(),
                currentPose.getHeading().getAngle(),
                gyro.getAngle()-currentPose.getHeading().getAngle(),dt));
    }

    public RobotPose getCurrentPose()
    {
        return currentPose;
    }

    public void setLeftSpeed(double speed)
    {
        leftFront.set(speed);
        leftBack.set(speed);
    }

    public void setRightSpeed(double speed)
    {
        rightFront.set(speed);
        rightBack.set(speed);
    }

    public void setSpeed(double leftSpeed, double rightSpeed)
    {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    public void initDefaultCommand() {
        // Set the default command, if any, for a subsystem here. Example:
        //    setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        return gyro.getAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        leftFront.pidWrite(output);
        leftBack.pidWrite(output);
        rightFront.pidWrite(output);
        rightBack.pidWrite(output);
    }
}

