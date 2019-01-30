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
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static XboxController controller = new XboxController(RobotMap.XBOX_CONTROLLER);

  public Button GrabberButton = new JoystickButton(controller, RobotMap.GRABBER_BUTTON_Y);
  public Button ArmButton = new JoystickButton(controller, RobotMap.ARM_BUTTON_A);

  public boolean yButtonState;
  public boolean yToggle;

  public boolean aButtonState;
  public boolean aToggle;

  public OI() {

    yButtonState = controller.getYButtonPressed();
    aButtonState = controller.getAButtonPressed();

    // grabber
    if (yButtonState)
      yToggle = !yToggle;

    if (yButtonState && yToggle)
      GrabberButton.whileHeld(new GrabberClose());
    else if (yButtonState && !yToggle)
      GrabberButton.whileHeld(new GrabberOpen());

    // arm
    if (aButtonState)
      aToggle = !aToggle;

    if (aButtonState && aToggle)
      ArmButton.whileHeld(new ArmDown());
    else if (aButtonState && !aToggle)
      ArmButton.whileHeld(new ArmUp());
  }
}
