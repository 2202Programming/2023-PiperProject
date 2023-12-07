// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.hid.HID_Xbox_Subsystem;

/*
 * Commands for RobotCentricDrive.
 * Using input from HID_Xbox_Subsystem and claculate the speeds of right/left motors.
 * Currently front wheel and back wheel is using same calculated output value.
 * 
 */
public class RobotCentricDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private HID_Xbox_Subsystem dc;
  private double leftSpeed;
  private double rightSpeed;
  /** Creates a new RobotCentricDrive. */
  public RobotCentricDrive(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    this.dc = RobotContainer.RC().dc;
  }

  private void calculate(){
    //new calculation--simply just using Y as base speed and Rot as the difference between left and right
    //Rot speed can be adjusted by the constant in HID_Xbox_Subsystem
    double YInput = dc.getVelocityY();
    double RotInput = dc.getVelocityRot();
    
    double rotFactor = 1.5; // rotation multiply factor
    leftSpeed= YInput - RotInput* rotFactor;
    rightSpeed = YInput + RotInput* rotFactor;

    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    calculate();
    drivetrain.drive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
