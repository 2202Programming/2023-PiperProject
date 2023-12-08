// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Launch;

public class Launch_setSpeed extends CommandBase {
  /** Creates a new ejectBall. */
  final Launch launch;
  final double pct_speed;

  /*
   * pct_speed - percent +- 0.0  to 1.0 for motor speed
   */
  public Launch_setSpeed(double pct_speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.launch = RobotContainer.RC().launch;
    this.pct_speed = pct_speed;
    addRequirements(launch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launch.runMotor(pct_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launch.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    //TODO - Mr. L wants to know when this command should end?
    return false;
  }
}
