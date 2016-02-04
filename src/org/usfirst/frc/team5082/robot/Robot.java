
package org.usfirst.frc.team5082.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Ultrasonic;

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
	//Talon garage;
	Spark ballLift;
	Spark ballLift2;
	private int mode = 0; // initialize default mode
	SendableChooser chooser;
	private int mode2 = 0; // initialize default mode
	SendableChooser chooser2;
	int timerCounter;
	Joystick stick;
	//RobotDrive chasisMotors;
	Ultrasonic ultrasonic = new Ultrasonic(1, 2);
	int gogogo;
	
    public void robotInit() {
    	NetworkTable.initialize();
    	//garage = new Talon(6);
    	ballLift = new Spark(6);
    	ballLift2 = new Spark(5);
    	chooser = new SendableChooser();
    	chooser2 = new SendableChooser();
    	SmartDashboard.putData("Autonomous Defense Selector", chooser);
    	chooser.addDefault("Position 1", 1);
    	chooser.addObject("Position 2", 2);
    	chooser.addObject("Position 3", 3);
    	chooser.addObject("Position 4", 4);
    	chooser.addObject("Position 5", 5);
    	SmartDashboard.putData("Autonomous Position Selector", chooser2);
    	chooser2.addDefault("Moat", 1);
    	chooser2.addObject("Ramp", 2);
    	chooser2.addObject("Rock Wall", 3);
    	chooser2.addObject("Rough Terrain", 4);
    	ultrasonic.setAutomaticMode(true);
    	//chasisMotors = new RobotDrive(2,3,4,1);
    	stick = new Joystick(0);
    	gogogo = 0;
    }

public void autonomousInit() {
        mode = (int) chooser.getSelected();
        mode2 = (int) chooser2.getSelected();
    }
    public void autonomousPeriodic() {
    	SmartDashboard.putNumber("Ultrasonic Value", ultrasonic.getRangeInches());
    		switch(mode2) {
        		case 1:
        			System.out.println("positionprint");
        			for (timerCounter = 0; timerCounter < 400; timerCounter++) //sets the limits for the timer
        			{
        				if (timerCounter < 200)
        			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
        				//garage.set(-1);
        			}
        			Timer.delay(0.01);
        		}
        		break;
        		case 2:
        			for (timerCounter = 0; timerCounter < 400; timerCounter++) //sets the limits for the timer
        			{
        				if (timerCounter < 200)
        				{	
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
        				//garage.set(-1);
        			}
        			Timer.delay(0.01);
        		}
        		break;
        		case 3:
        			for (timerCounter = 0; timerCounter < 400; timerCounter++) //sets the limits for the timer
        			{
        				if (timerCounter < 200)
        				{	
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
        				//garage.set(-1);
        			}
        			Timer.delay(0.01);
        		}
        		break;
        		case 4:
        			for (timerCounter = 0; timerCounter < 400; timerCounter++) //sets the limits for the timer
        			{
        				if (timerCounter < 200)
        				{	
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
        				//garage.set(-1);
        			}
        			Timer.delay(0.01);
        		}
        		break;
        		case 5:
        			for (timerCounter = 0; timerCounter < 400; timerCounter++) //sets the limits for the timer
        			{
        				if (timerCounter < 200)
        				{	
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
        				//garage.set(-1);
        			}
        			Timer.delay(0.01);
        		}
        		break;
    		}
    	switch(mode) {
        case 1:
        	System.out.println("defenseprint");
        	for (timerCounter = 400; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				//garage.set(-1);
    			}
    			Timer.delay(0.01);
    		}
        	break;
        case 2:
        	for (timerCounter = 400; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				//garage.set(-1);
    			}
    			Timer.delay(0.01);
    		}
        	break;
        case 3:
        	for (timerCounter = 400; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				//garage.set(-1);
    			}
    			Timer.delay(0.01);
    		}
        	break;
        case 4:
        	for (timerCounter = 400; timerCounter < 1500; timerCounter++) //sets the limits for the timer
    		{
    			if (timerCounter < 200)
    			{
    				//chasisMotors.arcadeDrive(-0.65, 0.0); //forward and reset
    				//garage.set(-1);
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
    	if (stick.getRawButton(2)) { 
    		double rotation = stick.getY();
			double speed = stick.getX();
    //chasisMotors.arcadeDrive(rotation*1.00, speed*-1.00);
    		if (stick.getRawButton(6)) {
    			while (gogogo == 0) {
    			ballLift.set(0.4); //up
            	ballLift2.set(0.4); //up
            	Timer.delay(0.5);
            	ballLift.set(0.55); //up
            	ballLift2.set(0.55); //up
            	Timer.delay(0.5);
            	gogogo = 1;
    			}
            	while (gogogo == 1 && stick.getRawButton(6)) {
            	ballLift.set(0.75); //up
            	ballLift2.set(0.75); //up
            	}
            }
            else if (stick.getRawButton(4)) {
            	while (gogogo == 0) {
            	ballLift.set(-0.4); //up
            	ballLift2.set(-0.4); //up
            	Timer.delay(0.5);
            	ballLift.set(-0.55); //up
            	ballLift2.set(-0.55); //up
            	Timer.delay(0.5);
            	gogogo = 1;
            	}
            	while (gogogo == 1 && stick.getRawButton(4)) {
                	ballLift.set(-0.75); //up
                	ballLift2.set(-0.75); //up
                	}
            }
            else {
	        	ballLift.set(0); //down
	        	ballLift2.set(0); //up
	        	gogogo = 0;
	        }
        	 
        } else {
			double rotation = stick.getY();
			double speed = stick.getX();
			//chasisMotors.arcadeDrive(rotation*0.75, speed*-0.75);
			if (stick.getRawButton(6)) {
	        	ballLift.set(0.3); //up
	        	ballLift2.set(0.3); //up
	        }
	        else if (stick.getRawButton(4)) {
	        	ballLift.set(-0.3); //down
	        	ballLift2.set(-0.3); //up
	        }
	        else {
	        	ballLift.set(0); //down
	        	ballLift2.set(0); //up
	        	gogogo = 0;
	        }
    	}
    	if (stick.getRawButton(3)) {
    		ballLift.set(0); //down
        	ballLift2.set(0); //up
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
   
    }
    
}
