
package org.usfirst.frc.team5082.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Talon garage;
	private int mode = 1; // initialize default mode
	SendableChooser chooser;
	int timerCounter;
	RobotDrive myDrive;
	Joystick moveStick, rotateStick;
	
    public void robotInit() {
    	NetworkTable.initialize();
    	garage = new Talon(4);
    	chooser = new SendableChooser();
    	chooser.addDefault("Command 1", 1);
    	chooser.addObject("Command 2", 2);
    	SmartDashboard.putData("Autonomous Selector", chooser);
    	myDrive = new RobotDrive(0, 1, 2, 3);
    	moveStick = new Joystick(0);
    	rotateStick = new Joystick(1);
    }

public void autonomousInit() {
        mode = (int) chooser.getSelected();
    }
    public void autonomousPeriodic() {
    	switch(mode) {
        case 1:
        	for (timerCounter = 0; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				garage.set(-1);
    			}
    			Timer.delay(0.01);
    		}
        	break;
        case 2:
        	for (timerCounter = 0; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				garage.set(-1);
    			}
    			Timer.delay(0.01);
    		}
        	break;
    	}
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	myDrive.mecanumDrive_Cartesian(moveStick.getY(), moveStick.getX(), rotateStick.getX(), 0);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
