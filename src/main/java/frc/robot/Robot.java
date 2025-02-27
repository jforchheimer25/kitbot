// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
   private final TalonSRX m_leftDrive1 = new TalonSRX(1);
   private final TalonSRX m_leftDrive2 = new TalonSRX(2);
   private final TalonSRX m_rightDrive1 = new TalonSRX(3);
   private final SparkMax m_rightDrive2 = new SparkMax(4  , SparkLowLevel.MotorType.kBrushed);

   private final XboxController m_controller = new XboxController(0);



  /** Called once at the beginning of the robot program. */
  public Robot() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

  }
  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    m_leftDrive1.set(ControlMode.PercentOutput, m_controller.getLeftY());
    m_leftDrive2.set(ControlMode.PercentOutput, m_controller.getLeftY());
    m_rightDrive1.set(ControlMode.PercentOutput, -m_controller.getRightY());
    m_rightDrive2.set(m_controller.getRightY());
   
  }
  @Override
  public void disabledPeriodic(){

  }

  @Override
  public void robotPeriodic() {
    // TODO Auto-generated method stub
    super.robotPeriodic();
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
