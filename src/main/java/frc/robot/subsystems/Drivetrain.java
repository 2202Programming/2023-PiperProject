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
   * TODO: In constructor where I defined CANSparkMax, need to define the type of motor before testing
   * Using differential drive class for tank drive
   * Read:https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
   * for documentation
   */

   // TODO - MrL Check there isn't a 3rd motor controller, I thought the front wheel had its own motor 
   //  and the back two had two motors ganged together.  (not 100% sure on this)
   //  This looks like a good start!
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

    //TODO MrL - Device ID numbers should come from the Constants file per our convention.
    //TODO MrL - Are they really SParkMax,  I would have guessed Talon or something older,  good placeholders though.
    // The specific controller will take up a PWM port on the RIO, see the updated Constants.java

    FR_Motor = new CANSparkMax(1, null);
    BR_Motor = new CANSparkMax(2, null);
    rightMotors = new MotorControllerGroup(FR_Motor, BR_Motor);
    FL_Motor = new CANSparkMax(3, null);
    BL_Motor = new CANSparkMax(4, null);
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
