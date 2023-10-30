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

    // intake motor is a PW9 and is split into motor controllers 9 and 10!!! - Elena
    intake_motor = new Spark(PWM.INTAKE_MOTOR);
    intake_pneumatics = new Solenoid(PneumaticsModuleType.REVPH, PWM.INTAKE_PNEUMATICS);




    //TODO - MrL what motors, devices, sensors are part of this system?  
    //  add them here and put their IDs into Constants.java


    //  I merged from drivetrain branch so you would have updated Constants.java
    // get the devices on the robot into code placeholders.


    //TODO - MrL any other sub-systems?  if so add their place holders






  }


  /*Control for intake mechanisms 



   /*intake pneumonics deploy */
  public void intakePneumonics_deploy() {
    intake_pneumatics.set(true);
  }

  // turns on and sets speed for motors
  public void intakeMotors_deploy(){
    intake_motor.set(1);
  }

  /*intake will retract */
  public void intakePneumonics_retract() {
    intake_pneumatics.set(false);
  }

  // turns off motors; sets speed to 0
  public void intakeMotors_retract(){
    intake_motor.set(0);
  }

  /* TODO: Mr. L, should we combine the motor and pneumatic methods into a full intake on/off method? komei and i were discussing
  and he wants them seperate but i feel like it would be more intuitive to have the pneumatics and motor deploy in one method and 
  pneumatic and motor retract in another method. idk tho you know more than i do ~~ Elena*/ 

  /* like this:
  public void intakeDeploy(){
    intake_peumatics.set(true);
    intake_motor.set(1);
  }

  public void intakeRetract(){
    intake_pneumatics.set(false);
    intake_motor.set(0);
  }
   */


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
