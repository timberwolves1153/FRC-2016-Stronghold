package org.usfirst.frc.team1154.robot.autonomous;

import org.usfirst.frc.team1154.robot.Constants;
import org.usfirst.frc.team1154.robot.commands.ArmOutCommand;
import org.usfirst.frc.team1154.robot.commands.CollectorReleaseCommand;
import org.usfirst.frc.team1154.robot.commands.DriveWithPID;
import org.usfirst.frc.team1154.robot.commands.TurnWithPID;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoatAutonomousWithScore extends CommandGroup{
	public MoatAutonomousWithScore() {
		addSequential(new DriveWithPID(180 , Constants.moatSpeed));
		addSequential(new TurnWithPID(90));
		addSequential(new DriveWithPID(80 , Constants.moatSpeed));
		addSequential(new ArmOutCommand());
		addSequential(new CollectorReleaseCommand());
	}
}