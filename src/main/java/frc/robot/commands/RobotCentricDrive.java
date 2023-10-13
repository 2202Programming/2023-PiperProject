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
 * TODO: To check the calculation and output limit
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
    double YInput = dc.getVelocityY();
    double XInput = dc.getVelocityRot();
    double calculateLeftSpeed;
    double calculateRightSpeed;
    final double maxSpeed = 1.0;
    /*
     * Calculation for constant curvature control
     * L = 12 * (((Y + abs(Y)*X) + (Y + X)) / 2)
     * R = 12 * (((Y - abs(Y)*X) + (Y - X)) / 2)
     * There will be a bug when both Y and X value are 1(Right speed is going to be 0)
     * This is now solved by multiplying X input by 0.5 inside of the dc so that X input is not going to be 1.
     */
    
    calculateLeftSpeed  = 12 * (((YInput + Math.abs(YInput)*XInput) + (YInput + XInput))/2);
    calculateRightSpeed = 12 * (((YInput - Math.abs(YInput)*XInput) + (YInput - XInput))/2);

    //Set limit of output
    if(calculateLeftSpeed > calculateRightSpeed  && calculateLeftSpeed > maxSpeed){
      double scaleFactor = calculateLeftSpeed/maxSpeed;
      calculateLeftSpeed = calculateLeftSpeed / scaleFactor;
      calculateRightSpeed = calculateRightSpeed / scaleFactor;
    }
    else if(calculateRightSpeed > calculateRightSpeed && calculateRightSpeed > maxSpeed){
      double scaleFactor = calculateRightSpeed /maxSpeed;
      calculateRightSpeed = calculateRightSpeed / scaleFactor;
      calculateLeftSpeed = calculateLeftSpeed / scaleFactor;
    }
    leftSpeed = calculateLeftSpeed;
    rightSpeed = calculateRightSpeed;
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
