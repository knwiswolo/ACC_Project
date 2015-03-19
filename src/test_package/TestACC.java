/**
 * 
 */
package test_package;

import java.util.Scanner;

import notification.NotificationFactory;
import control_system_impl.DistanceControlImpl;
import simulators_impl.RadarSimulatorImpl;
import simulators_impl.SpeedSensorSimulatorImpl;

/**
 * @author knwiswolo
 *
 */
public class TestACC {

	private static Scanner scanner;
	private static Float safetyDistance;
	private static Float cruiseControlSpeed;
	
	private static Float distanceFromLeadingVehicle;
	
	public static void main(String[] args) {
		
		RadarSimulatorImpl radarSimulator = new RadarSimulatorImpl();
		DistanceControlImpl distanceControl = new DistanceControlImpl();
		NotificationFactory notification = new NotificationFactory();
		SpeedSensorSimulatorImpl speedSimulator = new SpeedSensorSimulatorImpl();
		
		System.out.println("-------------------------");
		System.out.println("START SIMULATION: <start>");
		System.out.println("-------------------------");
		
		while (true){
			
			try{
			scanner = new Scanner(System.in);
			String input;
			input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("start")){
				
				/**start simulation
				ACC vehicle is moving at randomly generated speed. - ACC OFF.
				- show current speed.
				*/
				
				Float initialSpeed = speedSimulator.SpeedSensorSimulator();
				System.out.println("-------------------------");
				System.out.println("Current Speed of Vehicle: " + initialSpeed + " m/s.");
				System.out.println("-------------------------");
				
				// ask to Switch on ACC.
				
				System.out.println("Press 'ON' to activate ACC.");
				System.out.println("-------------------------");
				input = scanner.nextLine();
				
				if(input.equalsIgnoreCase("ON")){
					
					System.out.println("-------------------------");
					System.out.println("ACC System ACTIVATED!");
					System.out.println("-------------------------");
					
					//Initiate ACC System.
							
					// ask for minimum distance from driver
					System.out.println("Input minimum distance (m): ");
					float distanceFromSafetyDistance; // current distance - safety distance (distance to safety distance)
					scanner = new Scanner(System.in);
					safetyDistance = scanner.nextFloat();
					
					// ask for maximum speed from driver
					System.out.println("Input cruise control speed (m/s): ");
					scanner = new Scanner(System.in);
					cruiseControlSpeed = scanner.nextFloat();
					
					System.out.println("");
					System.out.println("-------------------------");
					System.out.println("A: Accelerate");
					System.out.println("B: Brake");
					System.out.println("-------------------------");
					System.out.println("");
					
					System.out.println("Press <RETURN> to continue...");
					input = scanner.nextLine();
					
					if(input.equals("")){
						
						distanceFromLeadingVehicle = radarSimulator.RadarSimulator();
						distanceFromSafetyDistance = distanceControl.DistanceControl(distanceFromLeadingVehicle, safetyDistance);
						
						for(float i = (distanceFromLeadingVehicle-1); i >0; i--){
							try{
								Thread.sleep(1000);
								distanceFromLeadingVehicle--;
								distanceFromSafetyDistance--;
								System.out.println("Distance from Leading Vehicle: " + distanceFromLeadingVehicle + "m");
								System.out.println("Distance Gap (distance from safety distance): " + distanceFromSafetyDistance + "m");
								notification.createNotification(distanceFromLeadingVehicle, safetyDistance);
							}
							catch(InterruptedException ex){ex.printStackTrace();}
						}
						
					}
										
				}
			}
		}catch(Exception ex){ex.printStackTrace();}}
		

	}

}