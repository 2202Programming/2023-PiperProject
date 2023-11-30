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
  private Spark Left_Motors;
  private Spark Right_Motors;




  /** Creates a new Launch. */
  public Launch() {
    launch_pneumatic = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,1);//TODO: check PCM Port number

    // 1 pwm controls 2 motor controllers
    Left_Motors = new Spark(PWM.LaunchLeft); // MC 5&6
    Right_Motors = new Spark(PWM.LaunchRight);  ; // MC 7&8
   
    Right_Motors.set(0);
    Left_Motors.set(0);
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
    Left_Motors.set(speed);
    Right_Motors.set(speed);
  
  }
}
