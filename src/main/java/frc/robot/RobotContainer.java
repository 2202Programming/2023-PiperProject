// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.IntakeSpeed;
import frc.robot.commands.RobotCentricDrive;
import frc.robot.commands.deploy;
import frc.robot.commands.retract;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.hid.HID_Xbox_Subsystem;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer rc;
  public final HID_Xbox_Subsystem dc;
  private Drivetrain drivetrain;
  private Intake intake;

  public static RobotContainer RC() {
    return rc;
  }

  enum Bindings {
    test,
  }

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    RobotContainer.rc = this;
    dc = new HID_Xbox_Subsystem(0.3, 0.9, 0.05);
    drivetrain = new Drivetrain();
    intake = new Intake();

    configureBindings(Bindings.test);

    // set default commands, if sub-system exists
    if (drivetrain != null) {
      drivetrain.setDefaultCommand(new RobotCentricDrive(drivetrain));
    }
  }

  private void configureBindings(Bindings bindings) { // binds buttons to commands

    switch (bindings) {
      case test:
        dc.Operator().leftBumper().onTrue(new deploy(intake)); // intake deploy on left bumper
        dc.Operator().rightBumper().onTrue(new retract(intake)); // intake retract on right bumper
        dc.Operator().x().whileTrue(new IntakeSpeed(intake)); // binds intake motor control to X
      default:
    }
  }
}
