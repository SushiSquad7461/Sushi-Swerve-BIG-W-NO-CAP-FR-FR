// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.util.SwerveModuleConstants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final boolean TUNING_MODE = false;

    public static class kPorts {
        public static final String CANIVORE_NAME = "Sussy Squad";
        public static final int PIGEON_ID = 13;
    }
    public static final class kSwerve {
        public static final boolean OPEN_LOOP = false;
        public static final boolean FEILD_RELATIVE = false;
        public static final boolean GYRO_INVERSION = false; // Always ensure Gyro is CCW+ CW-

        /* Drivetrain Constants */
        public static final double TRACK_WIDTH = Units.inchesToMeters(21.73);
        public static final double WHEEL_BASE = Units.inchesToMeters(21.73);
        public static final double WHEEL_DIAMATER = Units.inchesToMeters(4);
        public static final double WHEEL_CIRCUMFRANCE = WHEEL_DIAMATER * Math.PI;

        public static final double OPEN_LOOP_RAMP = 0.25;
        public static final double CLOSED_LOOP_RAMP = 0.0;

        public static final double DRIVE_GEAR_RATIO = 6.75; // 6.86:1
        public static final double ANGLE_GEAR_RATIO = (150.0 / 7.0); // 12.8:1

        public static final SwerveDriveKinematics SWERVE_KINEMATICS = new SwerveDriveKinematics(
                new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
                new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
                new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
                new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0));

        /* Swerve Current Limiting */
        public static final int ANGLE_CONTINUSE_CURRENT_LIMIT = 20; // 25
        public static final int ANGLE_PEAK_CURRENT_LIMIT = 20; // 40
        public static final double ANGLE_PEAK_CURRENT_DURATION = 0;
        public static final boolean ANGLE_ENABLE_CURRENT_LIMIT = true;
        public static final int DRIVE_CONTINUSE_CURRENT_LIMIT = 25; // 35
        public static final int DRIVE_PEAK_CURRENT_LIMIT = 25; // 60
        public static final double DRIVE_PEAK_CURRENT_DURATION = 0;
        public static final boolean DRIVE_ENABLE_CURRENT_LIMIT = true;

        /* Angle Motor PID Values */
        public static final double ANGLE_P = 0.15;
        public static final double ANGLE_I = 0.0;
        public static final double ANGLE_D = 12.0;
        public static final double ANGLE_F = 0.0;

        /* Drive Motor PID Values */
        public static final double DRIVE_P = 0.05;
        public static final double DRIVE_I = 0.0;
        public static final double DRIVE_D = 0.0;
        public static final double DRIVE_F = 0.05;

        /* Swerve Profiling Values */
        public static final double MAX_ACCELERATION = 3; // 2
        public static final double MAX_SPEED = 11.5; // 4.5 meters per second
        public static final double MAX_ANGULAR_VELOCITY = 20; // 11.5
        public static final PIDController X_CONTROLLER = new PIDController(2, 0, 0);
        public static final PIDController Y_CONTROLLER = new PIDController(2, 0, 0);
        public static final ProfiledPIDController ANGLE_CONTROLLER = new ProfiledPIDController(4, 0, 0,
                new Constraints(MAX_ANGULAR_VELOCITY, 17));

        /* Neutral Modes */
        public static final NeutralMode ANGLE_NEUTRAL_MODE = NeutralMode.Coast;
        public static final NeutralMode DRIVE_NEUTRAL_MODE = NeutralMode.Brake;

        /* Motor Inverts */
        public static final boolean DRIVE_INVERSION = false;
        public static final boolean ANGLE_INVERSION = true;

        /* Angle Encoder Invert */
        public static final boolean CANCODER_INVERSION = true;

        /* Module Specific Constants */
        /* Front Left Module - Module 0 */
        public static final class Mod0 {
            public static final int DRIVE_MOTOR_ID = 1;
            public static final int ANGLE_MOTOR_ID = 3;
            public static final int CAN_CODER_ID = 2;
            public static final double ANGLE_OFFSET = 89.648438;
            public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_MOTOR_ID,
                    ANGLE_MOTOR_ID, CAN_CODER_ID, ANGLE_OFFSET);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 {
            public static final int DRIVE_MOTOR_ID = 10;
            public static final int ANGLE_MOTOR_ID = 12;
            public static final int CAN_CODER_ID = 11;
            public static final double ANGLE_OFFSET = 195.380859;
            public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_MOTOR_ID,
                    ANGLE_MOTOR_ID, CAN_CODER_ID, ANGLE_OFFSET);
        }

        /* Back Left Module - Module 2 */
        public static final class Mod2 {
            public static final int DRIVE_MOTOR_ID = 4;
            public static final int ANGLE_MOTOR_ID = 6;
            public static final int CAN_CODER_ID = 5;
            public static final double ANGLE_OFFSET = 67.675781;
            public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_MOTOR_ID,
                    ANGLE_MOTOR_ID, CAN_CODER_ID, ANGLE_OFFSET);
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 {
            public static final int DRIVE_MOTOR_ID = 7;
            public static final int ANGLE_MOTOR_ID = 9;
            public static final int CAN_CODER_ID = 8;
            public static final double ANGLE_OFFSET = 69.785156;
            public static final SwerveModuleConstants CONSTANTS = new SwerveModuleConstants(DRIVE_MOTOR_ID,
                    ANGLE_MOTOR_ID, CAN_CODER_ID, ANGLE_OFFSET);
        }
    }

    public static final class kOI {
        public static final int DRIVE_TRANSLATION_Y = XboxController.Axis.kLeftY.value;
        public static final int DRIVE_TRANSLATION_X = XboxController.Axis.kLeftX.value;
        public static final int DRIVE_ROTATE = XboxController.Axis.kRightX.value;

        public static final int UPDATE_ENCODER = XboxController.Button.kY.value;
    }
}
