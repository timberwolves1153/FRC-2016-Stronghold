package org.usfirst.frc.team1154.robot.commands;

import org.usfirst.frc.team1154.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmCheval extends Command {
	
	
	public ArmCheval() {
		requires(Robot.arm);
	}
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.arm.enablePID();
		Robot.arm.resetArmEncoder();
		Robot.arm.setSetpoint(150);
		
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
		SmartDashboard.putNumber("Current Arm Position" , Robot.arm.getArmPosition());
		SmartDashboard.putNumber("Arm PID Output", Robot.arm.getArmOutput());
		
	}

	@Override
	protected boolean isFinished() {
		return false;
//		 double currDifference = Math.abs(Robot.arm.getSetpoint() - Robot.arm.getArmPosition());
//		SmartDashboard.putNumber("Current Difference", currDifference);
//		return Math.abs(Robot.arm.getSetpoint() - Robot.arm.getArmPosition()) < 5;
//		if(Robot.arm.getArmPosition() => 150){
//			return true;
//
//		}
	}

	@Override
	protected void end() {
		Robot.arm.disablePID();
		Robot.arm.stopArm();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
