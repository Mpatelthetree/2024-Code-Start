// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MecDrive extends SubsystemBase {
  /** Creates a new MecDrive. */
  private PWMSparkMax topRightMotor = new PWMSparkMax(Constants.topRightMecWheel);
  private PWMSparkMax topLeftMotor = new PWMSparkMax(Constants.topLeftMecWheel);
  private PWMSparkMax bottomRightMotor = new PWMSparkMax(Constants.bottomRightMecWheel);
  private PWMSparkMax bottomLeftMotor = new PWMSparkMax(Constants.bottomLeftMechWheel);
  
  public MecDrive() {
  }

  public void SetMotors(double theta,double power,double turn) {
    double sin = Math.sin(theta-Math.PI/4);
    double cos = Math.cos(theta-Math.PI/4);
    double max = Math.abs(Math.abs(sin));
    
    double topLeft = power*cos/max+turn;
    double topRight = power*sin/max-turn;
    double bottomLeft = power*sin/max+turn;
    double bottomRight = power*cos/max-turn;

    if ((power+Math.abs(turn))>1) {
      topLeft = power*cos/max+turn;
      topRight = power*sin/max-turn;
      bottomLeft = power*sin/max+turn;
      bottomRight = power*cos/max-turn;
    }

    topLeftMotor.set(topLeft);
    topRightMotor.set(topRight);
    bottomLeftMotor.set(bottomLeft);
    bottomRightMotor.set(bottomRight);
  }

  //@Override
  //public void periodic() {
    // This method will be called once per scheduler run
  //}
}
