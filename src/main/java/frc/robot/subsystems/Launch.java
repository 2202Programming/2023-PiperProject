// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launch extends SubsystemBase {
  /** Creates a new Launch. */
  public Launch() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  // TODO: Launch does not use pneumatics- what are the motor controller and PWM values?? ~ER

  // public void deploy() {
  //   rt_intake_solenoid.set(DEPLOY);
  //   lt_intake_solenoid.set(DEPLOY);
  // }

  // public void retract() {
  //   rt_intake_solenoid.set(RETRACT);
  //   lt_intake_solenoid.set(RETRACT);
  // } 

  // public boolean isDeployed() {
  //   return (rt_intake_solenoid.get() == DEPLOY); 
  // }
}
