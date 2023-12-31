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
  public static final class CAN {
    // FRC DEFAULTS
    public static final int PDP = 1; // for rev
    public static final int PCM1 = 2; // for rev

  }

  public static final class PWM {
    public static final int DT_FR = 1;
    public static final int DT_BR = 2;
    public static final int DT_FL = 3;
    public static final int DT_BL = 4;

    public static final int Intake_Motor = 5;
  }

  public static final class DigitalIO {
    public static final int DT_LEFT_ENCODER_A = 1;
    public static final int DT_LEFT_ENCODER_B = 2;
  }

  public static final class AnalogIn {
  }

  public static final class PCM1 {
    public static final int intakeForward = 4;
    public static final int intakeReverse = 5;
  }

  public static final class DrivetrainConstants {
    public static final double MaxOutput = 0.5;// m/s max output to DifferentialDrive
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
