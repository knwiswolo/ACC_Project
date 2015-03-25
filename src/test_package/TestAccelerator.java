/**
 * 
 */
package test_package;

import control_system_impl.DistanceControlImpl;
import actuators_impl.AcceleratorImpl;

/**
 * @author knwiswolo
 * Test acceleration... 
 */
public class TestAccelerator {
	
	private static Float speed = (float) 5;
	private static Float cruiseControlSpeed = (float) 35;
	private static Float throttlePosition = (float) 5;
	private static long timing = (long) ((1/throttlePosition)*2000);
	
	private static Float distanceFromLeadingVehicle = (float) 20;
	private static Float safetyDistance = (float) 5;
	
	private static Float tempDistSD = null;
	private static Float tempDistLV = null;
	
	public static void main(String[] args) {
	
		AcceleratorImpl accelerator = new AcceleratorImpl();
		DistanceControlImpl distanceControl = new DistanceControlImpl();
		
		Float distanceFromSafetyDistance = distanceControl.calculateDistanceFromSafetyDistance(distanceFromLeadingVehicle, safetyDistance);

		System.out.println("Current Speed: " + speed + " m/s");
		System.out.println("Distance From Leading Vehicle: " + distanceFromLeadingVehicle + " m");
		System.out.println("Distance From Safety Dustance: " + distanceFromSafetyDistance + " m");
		System.out.println("-----------------------------");
		
		while(speed < cruiseControlSpeed){
			if(distanceFromSafetyDistance !=0){
				System.out.println("Accelerating...");
				try{
					speed = accelerator.accelerate(throttlePosition, speed);
					Thread.sleep(timing);
					distanceFromSafetyDistance--;
					distanceFromLeadingVehicle--;
					System.out.println("Current Speed: " + speed + " m/s");
					System.out.println("Distance From Leading Vehicle: " + distanceFromLeadingVehicle + " m");
					System.out.println("Distance From Safety Dustance: " + distanceFromSafetyDistance + " m");
				}
				catch(Exception ex){ex.printStackTrace();}
	
			}
			if(distanceFromSafetyDistance == 0){
				System.out.println("Cancel Acceleration.");
				try{					
					System.out.println("Current Speed: " + speed + " m/s");
					System.out.println("Distance From Leading Vehicle: " + distanceFromLeadingVehicle + " m");
					System.out.println("Distance From Safety Dustance: " + distanceFromSafetyDistance + " m");
				}
				catch(Exception ex){ex.printStackTrace();}
				System.out.println("-----------------------------");
				System.out.println("Safety Distance Reached.");
				System.out.println("-----------------------------");
				System.exit(0);
			}
			
			
		}
		
		while(speed > cruiseControlSpeed){
			if(distanceFromSafetyDistance !=0){
				System.out.println("Decelerating...");
				try{
					
					speed = accelerator.decelerate(throttlePosition, speed);
					Thread.sleep(timing);
					distanceFromSafetyDistance--;
					distanceFromLeadingVehicle--;
					System.out.println("Current Speed: " + speed + " m/s");
					System.out.println("Distance From Leading Vehicle: " + distanceFromLeadingVehicle + " m");
					System.out.println("Distance From Safety Dustance: " + distanceFromSafetyDistance + " m");
				}
				catch(Exception ex){ex.printStackTrace();}
				
				System.out.println("-----------------------------");
				System.out.println("Safety Distance Reached.");
				System.out.println("-----------------------------");
				//take current value of dSD and dLV
				tempDistSD = distanceFromSafetyDistance;
				tempDistLV = distanceFromLeadingVehicle;
			}
			if(distanceFromSafetyDistance == 0){			
				System.out.println("Decelerating...");
				try{
					speed = accelerator.decelerate(throttlePosition, speed);
					Thread.sleep(timing);
					
					System.out.println("Current Speed: " + speed + " m/s");
					System.out.println("Distance From Leading Vehicle: " + tempDistLV++ + " m");
					System.out.println("Distance From Safety Dustance: " + tempDistSD++ + " m");
				}
				catch(Exception ex){ex.printStackTrace();}
				System.out.println("-----------------------------");
				System.out.println("Cruise Control Speed Reached.");
				System.out.println("-----------------------------");
			}
		}
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Current Speed: " + speed + " m/s");
		System.out.println("-----------------------------");
	}

}
