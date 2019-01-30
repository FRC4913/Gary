/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;
/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class RearLifterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid rearLifter = new DoubleSolenoid(RobotMap.LIFTER_REAR_FORWARD,RobotMap.LIFTER_REAR_BACKWARD);//placeholders

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new Drive());
  }

  public void Up(){
    rearLifter.set(DoubleSolenoid.Value.kForward);
  }

  public void Down(){
    rearLifter.set(DoubleSolenoid.Value.kReverse);
  }

  public void Stop(){
    rearLifter.set(DoubleSolenoid.Value.kOff);
  }
}
