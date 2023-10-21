// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PWM;
public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain for tank drive
   * Check differential drive documentation
   * Using differential drive class for tank drive
   * Read:https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
   * for documentation
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
    drive.setExpiration(0.1);
  }

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
  }
  //Calculate 
  public void drive(double leftSpeed,double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    drive.tankDrive(0, 0);
  }




}
