/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
//import frc.robot.Robot;
import static frc.robot.Robot.pusherSub;

/**
 * An example command. You can replace me with your own command.
 */
public class PusherToggle extends Command {
    Command PusherPull;
    Command PusherPush;
    boolean toggle = true;

    public PusherToggle(Command a, Command b) {
        // Use requires() here to declare subsystem dependencies
        requires(pusherSub);
        PusherPull = a;
        PusherPush = b;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (toggle)
            PusherPull.start();
        else
            PusherPush.start();
        toggle = !toggle;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        pusherSub.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
