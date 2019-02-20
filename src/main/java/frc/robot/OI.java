/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static XboxController controller = new XboxController(RobotMap.XBOX_CONTROLLER);

  public Button GrabberButton = new JoystickButton(controller, 4); //Y
  public Button ArmButton = new JoystickButton(controller, 1); //A
  public Button PusherButton = new JoystickButton(controller, 2); //B
  public Button FrontLifterButton = new JoystickButton(controller, 8);
  public Button RearLifterButton = new JoystickButton(controller, 7);

  // method 1
  // public boolean grabberToggle = false;
  // public boolean armToggle = false;
  // public boolean pusherToggle = false;
  // public boolean frontLifterToggle = false;
  // public boolean rearLifterToggle = false;

  public OI() {

    // method 1
    // grabberToggle = runSubsystem(4, grabberToggle, GrabberButton, new
    // GrabberClose(), new GrabberOpen());
    // armToggle = runSubsystem(1, armToggle, ArmButton, new ArmDown(), new
    // ArmUp());
    // pusherToggle = runSubsystem(2, pusherToggle, PusherButton, new PusherPull(),
    // new PusherPush());
    // frontLifterToggle = runSubsystem(8, frontLifterToggle, FrontLifterButton, new
    // FrontLifterUp(), new FrontLifterDown());
    // rearLifterToggle = runSubsystem(7, rearLifterToggle, RearLifterButton, new
    // RearLifterUp(), new RearLifterDown());

    // method 2
    // GrabberButton.whenPressed(new GrabberOpen());
    // GrabberButton.toggleWhenPressed(new GrabberClose());

    // method 3&4
    GrabberButton.whenPressed(new GrabberToggle(new GrabberOpen(), new GrabberClose()));
    ArmButton.whenPressed(new ArmToggle(new ArmUp(), new ArmDown()));
    PusherButton.whenPressed(new PusherToggle(new PusherPull(), new PusherPull()));
    FrontLifterButton.whileActive(new FrontLifterToggle(new FrontLifterUp(), new FrontLifterDown()));
    RearLifterButton.whileHeld(new RearLifterToggle(new RearLifterUp(), new RearLifterDown()));
  }

  /*
   * Method is for running a subsystem by using a button to toggle between
   * commands. Each time method runs, it returns a new value for the toggle
   */

  // method 1
  // public boolean runSubsystem(int buttonNumber, boolean oldToggle, Button
  // buttonName, Command firstCommand,
  // Command alternateCommand) {
  // boolean newToggle = false;// initialized value of newToggle doesn't matter
  // if (controller.getRawButtonPressed(buttonNumber)) {
  // newToggle = !oldToggle;
  // if (newToggle)
  // buttonName.whileHeld(firstCommand);
  // else if (!newToggle)
  // buttonName.whileHeld(alternateCommand);
  // } else {
  // newToggle = oldToggle;
  // }
  // return newToggle;
  // }
}
