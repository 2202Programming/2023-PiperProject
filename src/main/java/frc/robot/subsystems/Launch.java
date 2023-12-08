// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PCM1;
import frc.robot.Constants.PWM;

public class Launch extends SubsystemBase {
  private DoubleSolenoid launch_pneumatics;
  private DoubleSolenoid transfer_pneumatics;
  private Spark left_motor;
  private Spark right_motor;

  /** Creates a new Launch. */
  public Launch() {
    left_motor = new Spark(PWM.launchLeft);
    right_motor = new Spark(PWM.launchRight);
    launch_pneumatics = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PCM1.launchForward, PCM1.launchReverse);
    transfer_pneumatics = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PCM1.transferForward, PCM1.transferReverse);
  }

  public void LaunchDeploy() {
    launch_pneumatics.set(DoubleSolenoid.Value.kForward);
  }

  public void LaunchRetract() {
    launch_pneumatics.set(DoubleSolenoid.Value.kReverse);
  }

  public void TransferDeploy() {
    transfer_pneumatics.set(DoubleSolenoid.Value.kForward);
  }

  public void TransferRetract() {
    transfer_pneumatics.set(DoubleSolenoid.Value.kReverse);
  }

  public void runMotor(double pct_speed) {
    left_motor.set(pct_speed);
    right_motor.set(pct_speed);
  }

  public void stopMotor() {
    left_motor.set(0);
    right_motor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
