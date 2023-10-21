// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PWM;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class Intake extends SubsystemBase{
    /** Creates intake subsystem. */
  private final Spark intake_motor;
  private final Solenoid intake_pneumatics;


  public Intake() {
    intake_motor = new Spark(PWM.INTAKE_MOTOR);
    intake_pneumatics = new Solenoid(PneumaticsModuleType.REVPH, PWM.INTAKE_PNEUMATICS);
    //TODO - MrL what motors, devices, sensors are part of this system?  
    //  add them here and put their IDs into Constants.java
    //  I merged from drivetrain branch so you would have updated Constants.java
    // get the devices on the robot into code placeholders.


    //TODO - MrL any other sub-systems?  if so add their place holders






  }


  /*Control for intake pneumatics
   *true deploys it and false retracts*/
  public void intake_deploy() {
    intake_pneumatics.set(true);
  }
  public void intake_retract() {
    intake_pneumatics.set(false);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
