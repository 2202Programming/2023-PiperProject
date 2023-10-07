// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain for tank drive
   * Check differential drive documentation
   * TODO: BEFORE Pushing/ Consider separating some stuffs may be not
   */

  private MotorController FR_Motor;
  private MotorController BR_Motor;
  private MotorControllerGroup rightMotors;
  private MotorController FL_Motor;
  private MotorController BL_Motor;
  private MotorControllerGroup leftMotors;
  private DifferentialDrive drive;
  public Drivetrain(CANSparkMax FR, CANSparkMax BR, CANSparkMax FL, CANSparkMax BL) {
    FR_Motor = FR;
    BR_Motor = BR;
    rightMotors = new MotorControllerGroup(FR_Motor, BR_Motor);
    FL_Motor = FL;
    BL_Motor = BL;
    leftMotors = new MotorControllerGroup(FL_Motor, BL_Motor);
    drive = new DifferentialDrive(leftMotors,rightMotors);
    //timeout value for safety
    drive.setExpiration(0.1);
    drive.setMaxOutput(1.0);
  }
  //Calculate 
  public void drive(double YInput,double XInput) {
    double leftSpeed;
    double rightSpeed;
    final double maxSpeed = 1.0;
    /*
     * Calculation for constant curvature control(similar to arcade drive)
     * L = 12 * (((Y + abs(Y)*X) + (Y + X)) / 2)
     * R = 12 * (((Y - abs(Y)*X) + (Y - X)) / 2)
     */
    
    leftSpeed  = 12 * (((YInput + Math.abs(YInput)*XInput) + (YInput + XInput))/2);
    rightSpeed = 12 * (((YInput - Math.abs(YInput)*XInput) + (YInput - XInput))/2);

    //Set limit of output
    if(leftSpeed > rightSpeed  && leftSpeed > maxSpeed){
      double scaleFactor = leftSpeed/maxSpeed;
      leftSpeed = leftSpeed / scaleFactor;
      rightSpeed = rightSpeed / scaleFactor;
    }
    else if(rightSpeed > rightSpeed && rightSpeed > maxSpeed){
      double scaleFactor = rightSpeed /maxSpeed;
      rightSpeed = rightSpeed / scaleFactor;
      leftSpeed = leftSpeed / scaleFactor;
    }
    drive.tankDrive(leftSpeed, rightSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
