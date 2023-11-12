// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.RotateCommand;
import frc.robot.commands.SwerveMoveCommand;
import frc.robot.subsystems.MecDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController m_driverController = new XboxController(OperatorConstants.kDriverControllerPort);

  private final MecDrive m_MecDrive = new MecDrive();
  private final SwerveMoveCommand c_SwerveMove = new SwerveMoveCommand(m_MecDrive);
  private final RotateCommand c_Rotate = new RotateCommand(m_MecDrive);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  
  XboxController xboxLeftJoystick = m_driverController.leftStick();
  XboxController xboxRightJoystick = m_driverController.rightStick(); 

  public double getLeftJoyStickXAxis() {
    return xboxLeftJoystick.getLeftX();
  }
  public double getLeftJoyStickYAxis() {
    return xboxLeftJoystick.getLeftY();
  }


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_driverController.axisGreaterThan(Constants.xboxLeftJoystickX, 0, null)
    m_driverController.axisLessThan(Constants.xboxLeftJoystickY, 0,null).whileTrue(c_SwerveMove);

    m_driverController.axisGreaterThan(Constants.xboxRightJoystickX, 0,null).whileTrue(c_Rotate);
    m_driverController.axisLessThan(Constants.xboxRightJoystickX, 0,null).whileTrue(c_Rotate);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Autos.exampleAuto(m_exampleSubsystem);
  //}
}
