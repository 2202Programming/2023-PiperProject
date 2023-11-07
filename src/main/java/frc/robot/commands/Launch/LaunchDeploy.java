// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Launch;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launch;

public class LaunchDeploy extends CommandBase {
  /** Creates a new LaunchDeploy. */
  private Launch launch;
  public LaunchDeploy(Launch launch) {
   
    this.launch = launch;
    addRequirements(launch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
