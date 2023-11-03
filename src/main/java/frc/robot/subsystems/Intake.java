// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PCM1;
import frc.robot.Constants.PWM;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class Intake extends SubsystemBase{
    /** Creates intake subsystem. */
    
    // intake motor 1 and motor 2 are the same motor, but one object is bound to motor controller 9 and the other to 10, even though it's the same motor -ER
  private final Spark motors; 

  private final DoubleSolenoid arm;


  public Intake() {

    // intake motor is a PW9 and is split into motor controllers 9 and 10!!! - Elena
    motors = new Spark(PWM.Intake_Motors); // motor controller 9 and 10

    arm = new DoubleSolenoid(PneumaticsModuleType.REVPH, PCM1.intakeForward, PCM1.intakeReverse);

  }


  /*Control for intake mechanisms 

   /*pneumonics deploy */
  public void deploy(){
    arm.set(DoubleSolenoid.Value.kForward);
  }

   /*pneumonics retract */
   public void retract() {
    arm.set(DoubleSolenoid.Value.kReverse);
  }

  // turns on and sets speed for motors
  public void intakeSpeed(double speed){
    motors.set(speed);
  }

  public double getIntakeSpeed(){
    return motors.get();
  }

  @Override
  public void periodic() {
    // not needed for this subsystem
  }

  // WIP commands for intake - Elena
  public class Deploy extends CommandBase{

  }

}
