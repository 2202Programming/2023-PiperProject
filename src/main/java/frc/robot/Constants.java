// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. 
 * This class should not be used for any other purpose. 
 * All constants should be declared globally (i.e. public static). 
 * Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

  // RoboRio and CAN ports

  public static final class CAN {
    // FRC DEFAULTS
    public static final int PDP = 1; // for rev
    public static final int PCM1 = 2; // for rev

  }

  public static final class PWM {
    public static final int DT_FL = 1;
    public static final int DT_BL = 2;
    public static final int DT_FR = 3;
    public static final int DT_BR = 4;

    //intake motor 1 and motor 2 are the same motor, but one object is bound to motor controller 9 
    //and the other to 10, even though it's the same motor -ER

   // electrically this controller goes to 9 & 10
    public static final int Intake_Motors = 9;
    
    
    
  }

  // Digital IO on the RIO
  public static final class DigitalIO {
    //DIO Ports for encoders
    public static final int DT_LEFT_ENCODER_A = 1;
    public static final int DT_LEFT_ENCODER_B = 2;
  }

  public static final class AnalogIn {
    // public static final int MAGAZINE_ANGLE = 0;
  }

  // PWM assignments on the Rio
  public static final class PCM1 {

    // dual solenoid for intake
    public static final int intakeForward = 0;
    public static final int intakeReverse = 1;


  }

  // if we use a second PCM
  public static final class PCM2 {
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class DriverControls {

    public enum Id {
      Driver(0), Operator(1), SwitchBoard(2), Phantom(3);

      public final int value;

      Id(int value) {
        this.value = value;
      }
    }

    public enum DriverMode {
      Arcade(0), Tank(1), XYRot(2);

      public final int value;

      DriverMode(int value) {
        this.value = value;
      }
    }
  }
}
