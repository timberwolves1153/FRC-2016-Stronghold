package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ActuatorInCommand extends Command {
	
	public ActuatorInCommand() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
	Robot.drive.armReverse();
		
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.armSthap();

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}