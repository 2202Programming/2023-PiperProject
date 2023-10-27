// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PWM;
import frc.robot.Constants.DigitalIO;
import frc.robot.Constants.DrivetrainConstants;
public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain for tank drive
   * Check differential drive documentation
   * Using differential drive class for tank drive
   * Read:https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
   * for documentation
   */

  private final MotorController FR_Motor;
  private final MotorController BR_Motor;
  private final MotorControllerGroup rightMotors;
  private final MotorController FL_Motor;
  private final MotorController BL_Motor;
  private final MotorControllerGroup leftMotors;
  private final DifferentialDrive drive;
  private final Encoder leftEncoder;
  private final PIDController leftPID;
  private final double maxSpeed;
  private final double wheelDiameter;
  private double lastLeftEncoderCount;
  private double lastRightEncoderCount;
  private double leftDistanceMoved;
  private double rightDistanceMoved;
  private double heading;
  private double y;
  private double x;

  public Drivetrain(){

    // The specific controller will take up a PWM port on the RIO, see the updated Constants.java
    FR_Motor = new Spark(PWM.DT_FR);
    BR_Motor = new Spark(PWM.DT_BR);
    rightMotors = new MotorControllerGroup(FR_Motor, BR_Motor);
    FL_Motor = new Spark(PWM.DT_FL);
    BL_Motor = new Spark(PWM.DT_BL);
    leftMotors = new MotorControllerGroup(FL_Motor, BL_Motor);
    // more docs - https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
    drive = new DifferentialDrive(leftMotors,rightMotors);
    drive.setExpiration(0.1);

    leftEncoder = new Encoder(DigitalIO.DT_LEFT_ENCODER_A, DigitalIO.DT_LEFT_ENCODER_B);
    leftEncoder.setDistancePerPulse(1.0/360.0);//360 ticks per revolution
    wheelDiameter = DrivetrainConstants.wheelDiameter;
    leftPID = new PIDController(0.1, 0.0, 0.0); //TODO: Tune PID values
    maxSpeed = DrivetrainConstants.MaxSpeed;
    
    
    //For position calculation
    x = 0.0; // x position of the robot(initial)
    y = 0.0; // y position of the robot(initial)
    heading = 0.0; // heading of the robot(initial) in radians
    lastLeftEncoderCount = 0.0;
    lastRightEncoderCount = 0.0;

    leftDistanceMoved = 0.0;
    rightDistanceMoved = 0.0;
  }

  //Calculate 
  public void drive(double leftSpeed,double rightSpeed) {
    /*leftSpeed and rightSpeed are input between -1 and 1
     * maxSpeed is the maximum speed of the robot
    */
    double leftTargetSpeed = leftSpeed * maxSpeed;
    double rightTargetSpeed = rightSpeed * maxSpeed;

    //Use PID to calculate the output for the left
    double leftSpeedError = leftTargetSpeed - leftEncoder.getRate();
    double leftOutput = leftPID.calculate(leftSpeedError);

    //Use PID to calculate the output for the right
    //Use the left encoder to approximate the pseudo right encoder output
    double pseudoRightEncoderSpeed= leftEncoder.getRate() + (rightTargetSpeed - leftTargetSpeed);
    double rightSpeedError = rightTargetSpeed -pseudoRightEncoderSpeed;
    double rightOutput = leftPID.calculate(rightSpeedError);

    drive.tankDrive(leftOutput, rightOutput);


    /*
     * Calculate the distance traveled by each side of the robot
     */
    leftEncoder.setDistancePerPulse((Math.PI * wheelDiameter) / leftEncoder.getDistancePerPulse());
    double leftDistance = leftEncoder.getDistance() - lastLeftEncoderCount;
    double pseudoRightDistance = leftEncoder.getDistance() + (rightTargetSpeed - leftTargetSpeed) * 
                                      (Math.PI * wheelDiameter) / leftEncoder.getDistancePerPulse();

    // claculate change in distance and cnange in heading
    double deltaDistance = (leftDistance + pseudoRightDistance) / 2.0;
    double deltaHeading = (pseudoRightDistance - leftDistance) / DrivetrainConstants.wheelBaseWidth;
    /*
     * |-----|  <- wheelBaseWidth
     * |     |  <- use the difference between left nad right to calculate the angle
     * |_____|
     */
    x+= deltaDistance * Math.cos(Math.toRadians(heading));
    y+= deltaDistance * Math.sin(Math.toRadians(heading));
    
    heading += deltaHeading;

    lastLeftEncoderCount = leftEncoder.getDistance();
    lastRightEncoderCount = pseudoRightDistance;
  }
  
  @Override
  public void periodic() {

  }

  public void stop(){
    drive.tankDrive(0, 0);
  }


}