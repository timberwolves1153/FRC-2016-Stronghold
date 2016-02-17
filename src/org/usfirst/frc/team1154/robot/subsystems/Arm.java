package org.usfirst.frc.team1154.robot.subsystems;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.Robot;
import org.usfirst.frc.team1154.robot.RobotMap;
import org.usfirst.frc.team1154.robot.commands.ArmWithJoysticks;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Arm extends PIDSubsystem {
	
//  private Encoder armEncoder;
	private Potentiometer armEncoder;
	private AnalogInput ai;
	private Victor armMotor;
	private DigitalInput armInSwitch;
	private DigitalInput armOutSwitch;
	private PIDController armEncoderPID;
	
	
	public enum ArmHeight {
		LOW,
		HIGH,
		PORT,
		DRAW
	}
	
	public Arm() {
		
		super("Arm", 0.01, 0, 0);
		
		
		ai = new AnalogInput(0);
		
		armEncoder = new AnalogPotentiometer(ai,360,0);
		
//		armEncoder = new Encoder(RobotMap.ARM_ENCODER_A_CHANNEL, RobotMap.ARM_ENCODER_B_CHANNEL, false, EncodingType.k4X);
		
		armMotor = new Victor(RobotMap.ARM_MOTOR);
		
		armInSwitch = new DigitalInput(RobotMap.ARM_IN_SWITCH);
		
		armOutSwitch = new DigitalInput(RobotMap.ARM_OUT_SWITCH);
		
		armEncoderPID = new PIDController(.2, 0, 0, armEncoder, armMotor);
		
		init();
		
	}
	
	public void init() {
		armEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

		armEncoderPID.setOutputRange(-0.8, 0.8);
		
		LiveWindow.addSensor("Arm Encoder", "Potentiometer",  armEncoderPID);
	}
	
	public void enablePID() {
		
		armEncoderPID.enable();
		
	}
	
	public void disablePID() {
	
		armEncoderPID.disable();
		
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand (new ArmWithJoysticks(Constants.defaultArmSpeed));
	}
	
//	public void resetArmEncoder(){
//		//Resets the encoder distance value back to zero.
//		
//		armEncoder.reset();
//	}
	
	public void stopArm(){
		//Stops the Arm motor
		armMotor.set(0);
	}
	
	public boolean getArmIn(){
		//Returns the state of the in switch 
		return armInSwitch.get();
	}
	
	public boolean getArmOut(){
		//Returns the state of the out switch
		return armOutSwitch.get();
	}
	
	public void out(){
		//Sets the Arm motor to move the collector out
		armMotor.set(1);
	}

	public void in(){
		//Sets the Arm motor to move the collector in
		armMotor.set(-1);
	}
	
	public void driveArm(Joystick stick) {
		armMotor.set(-stick.getRawAxis(1) * Constants.defaultArmSpeed);
	}
	
	public double getArmOutput() {
		return armMotor.get();
	}
	
	public double getArmPosition() {
		return armEncoder.get();
	}
	
	public double getArmVoltage() {
		return ai.getAverageVoltage();
	}
	
	public void setArmPIDOutput(double speed) {
		armEncoderPID.setOutputRange(-speed, speed);
	}
	
	public double getArmPIDOutput() {
		return armEncoderPID.get();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return getArmPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		armMotor.set(output);
		
	}

}
