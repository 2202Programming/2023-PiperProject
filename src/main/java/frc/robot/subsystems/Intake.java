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
    
    // intake motor 1 and motor 2 are the same motor, but one object is bound to motor controller 9 and the other to 10, even though it's the same motor -ER
  private final Spark intake_motor1; 
  private final Spark intake_motor2; 

  private final Solenoid intake_pneumatics;


  public Intake() {

    // intake motor is a PW9 and is split into motor controllers 9 and 10!!! - Elena
    intake_motor1 = new Spark(PWM.Intake_MotorControl1); // motor controller 9 
    intake_motor2 = new Spark(PWM.Intake_MotorControl2); // motor controller 10 

    intake_pneumatics = new Solenoid(PneumaticsModuleType.REVPH, PWM.INTAKE_PNEUMATICS);

    // any motors, devices, sensors, etc. add here and define in constants.java


    //TODO - MrL any other sub-systems?  if so add their place holders

  }


  /*Control for intake mechanisms 



   /*intake pneumonics deploy */
  public void intakePneumonics_deploy() {
    intake_pneumatics.set(true);
  }

  // turns on and sets speed for motors
  public void intakeMotors_deploy(){
    intake_motor1.set(1);
    intake_motor2.set(1);
  }

  /*intake will retract */
  public void intakePneumonics_retract() {
    intake_pneumatics.set(false);
  }

  // turns off motors; sets speed to 0
  public void intakeMotors_retract(){
    intake_motor1.set(0);
    intake_motor2.set(0);
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
