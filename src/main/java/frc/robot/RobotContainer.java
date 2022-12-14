// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.kOI;
import frc.robot.commands.TeleopSwerveDrive;
import frc.robot.subsystems.Swerve;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  Swerve swerve;

  public RobotContainer() {
    swerve = Swerve.getInstance();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    swerve.setDefaultCommand(new TeleopSwerveDrive(
        swerve,
        new XboxController(0),
        kOI.DRIVE_TRANSLATION_Y,
        kOI.DRIVE_TRANSLATION_X,
        kOI.DRIVE_ROTATE,
        true,
        false
    )
);
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
