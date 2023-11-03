// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.IntakeSpeed;
import frc.robot.commands.RobotCentricDrive;
//import frc.robot.commands.deploy;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.hid.HID_Xbox_Subsystem;
import frc.robot.Constants.OperatorConstants;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
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
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
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

    if (intake != null) {
      //TODO bind whatever is needed 
      
      // binds intake motor control to X --ER
      dc.Operator().x().whileTrue(new IntakeSpeed(intake)); // binds intake motor control to X --ER
    }

  }

  private void configureBindings(Bindings bindings) {

    //var driver = dc.Driver();
    //var operator = dc.Operator();
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */


  //deploy command button bindings
/* 
    switch(bindings) {
      case test:
        dc.Operator().povLeft().whileTrue(new deploy(intake)); // intake deploy on left bumper/trigger; 

      default:
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
  //  // An example command will be run in autonomous
  //  return Autos.exampleAuto(m_Intake);
  //}

  
  } 
}
  
