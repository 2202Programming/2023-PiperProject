// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PCM1;
import frc.robot.Constants.PWM;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;




public class deploy extends CommandBase {
  private Intake intake;
  /** Creates a new deploy. */
  public deploy(Intake intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = intake;



  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.deploy();


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
