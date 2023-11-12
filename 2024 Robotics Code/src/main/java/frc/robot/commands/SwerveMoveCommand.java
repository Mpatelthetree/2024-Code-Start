// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MecDrive;

public class SwerveMoveCommand extends CommandBase {
  /** Creates a new SwerveDrive. */
  private final MecDrive _mecDrive;

  public SwerveMoveCommand(MecDrive mec) {
    // Use addRequirements() here to declare subsystem dependencies.
      _mecDrive = mec;
      addRequirements(_mecDrive);
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double StickY = Robot.m_robotContainer.GetDriverRawAxis(Constants.STICK_Y);
    
    _mecDrive.SetMotors();
 
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
