
package org.usfirst.frc.team5082.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;


/**
  _____    ____       ____       _____  U _____ u    _      __  __        ____    ___       ___     ____                                                                                
 |" ___|U |  _"\ u U /"___|     |_ " _| \| ___"|/U  /"\  uU|' \/ '|u    U|"___|u / _"\  u U( " ) u |___"\                                                                               
U| |_  u \| |_) |/ \| | u         | |    |  _|"   \/ _ \/ \| |\/| |/    \|___ \/| / U |/  \/   \/  U __) |                                                                              
\|  _|/   |  _ <    | |/__       /| |\   | |___   / ___ \  | |  | |       ___) || \// |,-.| ( ) |  \/ __/ \                                                                             
 |_|      |_| \_\    \____|     u |_|U   |_____| /_/   \_\ |_|  |_|      |____/  \___/(_/  \___/>> |_____|u                                                                             
 )(\\,-   //   \\_  _// \\      _// \\_  <<   >>  \\    >><<,-,,-.      ,-,>>\,-. //        )( (__)<<  //                                                                               
(__)(_/  (__)  (__)(__)(__)    (__) (__)(__) (__)(__)  (__)(./  \.)      \ ) (_/ (__)      (__)   (__)(__)                                                                              
  ____     ___       _     __           ____    U  ___ u   ____     U  ___ u _____                ____  ____          ____      ____    U  ___ u   ____     ____        _      __  __   
 |___"\   / _"\  u  /"| U /"/_ u     U |  _"\ u  \/"_ \/U | __")u    \/"_ \/|_ " _|     ___    U /"___|/ __"| u     U|  _"\ uU |  _"\ u  \/"_ \/U /"___|uU |  _"\ u U  /"\  uU|' \/ '|u 
 U __) | | / U |/ u | |u\| '_ \/      \| |_) |/  | | | | \|  _ \/    | | | |  | |      |_"_|   \| | u <\___ \/      \| |_) |/ \| |_) |/  | | | |\| |  _ / \| |_) |/  \/ _ \/ \| |\/| |/ 
 \/ __/ \| \// |,-.\| |/ | (_) |       |  _ <.-,_| |_| |  | |_) |.-,_| |_| | /| |\      | |     | |/__ u___) |       |  __/    |  _ <.-,_| |_| | | |_| |   |  _ <    / ___ \  | |  | |  
 |_____|u \___/(_/  |_|   \___/        |_| \_\\_)-\___/   |____/  \_)-\___/ u |_|U    U/| |\U    \____||____/>>      |_|       |_| \_\\_)-\___/   \____|   |_| \_\  /_/   \_\ |_|  |_|  
 <<  //    //     _//<,-,_// \\_       //   \\_    \\    _|| \\_       \\   _// \\_.-,_|___|_,-._// \\  )(  (__)     ||>>_     //   \\_    \\     _)(|_    //   \\_  \\    >><<,-,,-.   
(__)(__)  (__)   (__)(_/(__) (__)     (__)  (__)  (__)  (__) (__)     (__) (__) (__)\_)-' '-(_/(__)(__)(__)         (__)__)   (__)  (__)  (__)   (__)__)  (__)  (__)(__)  (__)(./  \.)
      _                                 __                                     ____         _    __   _     __                     
     L]    ___ _     ___ _     ___ _   LJ    ____      ____     _ ___        F ___J     ___FJ   LJ  FJ_    LJ    ____     _ ___   
     | L  F __` L   F __` L   F __` L  FJ   F __ J    F __ J   J '__ J      J |___:    F __  L     J  _|        F __ J   J '__ J  
     | | | |--| |  | |--| |  | |--| | J  L | |--| |  | |--| |  | |__| |     | _____|  | |--| |  FJ | |-'   FJ  | |--| |  | |__| | 
.--__J J F L__J J  F L__J J  F L__J J J  L F L__J J  F L__J J  F L  J J     F L____:  F L__J J J  LF |__-.J  L F L__J J  F L  J J 
J\_____/J\____,__L )-____  LJ\____,__LJ__LJ\______/FJ\______/FJ__L  J__L   J________LJ\____,__LJ__L\_____/J__LJ\______/FJ__L  J__L
 J_____/ J____,__FJ\______/F J____,__F|__| J______F  J______F |__L  J__|   |________| J____,__F|__|J_____F|__| J______F |__L  J__|
                   J______F                                                                                                      
 Code created by Pimp Thomas and Zach Watson
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Spark ballLift;
	Spark ballLift2;
	private int position = 0; // initialize default mode
	SendableChooser chooser;
	private int defense = 0; // initialize default mode
	SendableChooser chooser2;
	int timerCounter;
	double Kp = 0.00;
	Joystick stick;
	RobotDrive chasisMotors;
	Ultrasonic ultrasonic;
	Servo horizontalCameraServo;
	Servo verticalCameraServo;
	AnalogGyro gyro;
	
    public void robotInit() {
    	NetworkTable.initialize();
    	ballLift = new Spark(6);
    	ballLift2 = new Spark(5);
    	chooser = new SendableChooser();
    	chooser2 = new SendableChooser();
    	ultrasonic = new Ultrasonic(1, 2);
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
    	horizontalCameraServo = new Servo(8);
        verticalCameraServo = new Servo(7);
        CameraServer server = CameraServer.getInstance();
        server.setQuality(50);
        gyro = new AnalogGyro(1); 
        server.startAutomaticCapture("cam0");
    	chasisMotors = new RobotDrive(0,1,2,3);
    	stick = new Joystick(0);
    }

public void autonomousInit() {
        position = (int) chooser.getSelected();
        defense = (int) chooser2.getSelected();
    }
    public void autonomousPeriodic() {
    	gyro.reset();
    	SmartDashboard.putNumber("Gyroscope Value", gyro.getAngle());
    	SmartDashboard.putNumber("Ultrasonic Value", ultrasonic.getRangeInches());
    	double positionAngle = gyro.getAngle();
    		switch(defense) {
        		case 1:
        			System.out.println("defprint");
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
    		double afterDefenseAngle = gyro.getAngle();
			if (afterDefenseAngle >= positionAngle) {
				chasisMotors.tankDrive(0.0, 1*positionAngle);
			}
			else if (afterDefenseAngle <= positionAngle) {
				chasisMotors.tankDrive(0.0, -1*positionAngle);
			}
    	switch(position) {
        case 1:
        	System.out.println("posprint");
    			Timer.delay(0.01);
        	break;
        case 2:
        	break;
        case 3:
        	break;
        case 4:
        	break;
    	}
    }


    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if (stick.getRawButton(6)) { 
    		chasisMotors.tankDrive(stick.getRawAxis(2)*1.00, stick.getRawAxis(5)*1.00);
        } 
    	else {
			chasisMotors.arcadeDrive(stick.getRawAxis(2)*0.75, stick.getRawAxis(5)*0.75);
        }
    	if (Math.abs(stick.getRawAxis(3)) > .1) {
	        	ballLift.set(stick.getRawAxis(3)*-1.00); //up
	        	ballLift2.set(stick.getRawAxis(3)*-1.00); //up
    	}
    	if (Math.abs(stick.getRawAxis(2)) > .1) {
	        	ballLift.set(stick.getRawAxis(2)*1.00); //up
	        	ballLift2.set(stick.getRawAxis(2)*1.00); //up
    	}
	        	 if (stick.getRawAxis(6) == 1) {
	             	horizontalCameraServo.set(0.25);
	             }
	             else if (stick.getRawAxis(6) == -1) {
	             	horizontalCameraServo.set(0);
	             }
	             else {
	             		horizontalCameraServo.set(0.5);
	             	}
	             
	             if (stick.getRawAxis(7) == 1) {
	             	verticalCameraServo.set(1.0);
	             }
	             else if (stick.getRawAxis(7) == -1) {
	             	verticalCameraServo.set(0.7);
	             	}
	             else {
	         		verticalCameraServo.set(0.85);
	         	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
   
    }
    
}
