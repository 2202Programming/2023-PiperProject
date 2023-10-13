// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class Intake extends SubsystemBase{
    /** Creates intake subsystem. */
  public Intake() {

    //TODO - MrL what motors, devices, sensors are part of this system?  
    //  add them here and put their IDs into Constants.java
    //  I merged from drivetrain branch so you would have updated Constants.java
    // get the devices on the robot into code placeholders.

    //TODO - MrL any other sub-systems?  if so add their place holders



  }


  // MrL - general comment, this is an example of having the command code in the same file as the sub-system.
  //  we don't often do this but it is a workable pattern.
  
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
    
}
