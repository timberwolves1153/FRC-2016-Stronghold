package org.usfirst.frc.team1154.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1154.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driveStick = new Joystick(RobotMap.DRIVER_JOYSTICK);
	private Joystick opStick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	/**
	 * The abbreviations are as follows: LB = left Bumper RB = right Bumper BA = Back button ST = Start Button
	 * 									LJ = left Joystick RJ = right Joystick
	 */
	private Button opA = new JoystickButton(opStick,0); // Articulate the collector in or out of the robot.
	private Button opB = new JoystickButton(opStick,1);
	private Button opX = new JoystickButton(opStick,2);
	private Button opY = new JoystickButton(opStick,3);
	private Button opLB = new JoystickButton(opStick,4);
	private Button opRB = new JoystickButton(opStick,5);
	private Button opBA = new JoystickButton(opStick,7);
	private Button opST = new JoystickButton(opStick,6);
	private Button opLJ = new JoystickButton(opStick,8);
	private Button opRJ = new JoystickButton(opStick,9);
	
	
	public Joystick getDriverStick(){
		return driveStick;
	}
	
}


