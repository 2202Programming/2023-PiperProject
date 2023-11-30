// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Launch;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Launch;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html


public class LaunchSetSpeed extends InstantCommand {
  private Launch launch;
  private double speed;

  public LaunchSetSpeed(double speed, Launch launch) {
    this.speed = speed;
    this.launch = launch;
    addRequirements(launch);
   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launch.setLaunchSpeed(speed);
  }
}
