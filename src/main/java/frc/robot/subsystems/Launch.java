// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PWM;

public class Launch extends SubsystemBase {
  private DoubleSolenoid launch_pneumatic;
  private Spark FL_Motor;
  private Spark BL_Motor;
  private Spark FR_Motor;
  private Spark BR_Motor;

  /** Creates a new Launch. */
  public Launch() {
    launch_pneumatic = new DoubleSolenoid(PneumaticsModuleType.REVPH,0,1);//TODO: check PCM Port number

    FL_Motor = new Spark(PWM.Launch_FL);
    BL_Motor = new Spark(PWM.Launch_BL);
    FR_Motor = new Spark(PWM.Launch_FR);
    BR_Motor = new Spark(PWM.Launch_BR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Deploy penumatics
  public void deploy() {
    launch_pneumatic.set(DoubleSolenoid.Value.kForward);
  }
  //Retract penumatics
  public void retract(){
    launch_pneumatic.set(DoubleSolenoid.Value.kReverse);
  }
  //Check the current_state of penumatics
  public boolean isDeployed(){
    return (launch_pneumatic.get() == DoubleSolenoid.Value.kForward);
  }

  //Move motors at a certain speed 
  //TODO: Check motor direction.
  public void setLaunchSpeed(double speed){
    FL_Motor.set(speed);
    BL_Motor.set(speed);
    FR_Motor.set(speed);
    BR_Motor.set(speed);
  }
}
