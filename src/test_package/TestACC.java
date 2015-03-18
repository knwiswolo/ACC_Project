/**
 * 
 */
package test_package;

import java.util.Scanner;

import notification.NotificationFactory;
import control_system_impl.DistanceControlImpl;
import simulators_impl.RadarSimulatorImpl;

/**
 * @author knwiswolo
 *
 */
public class TestACC {

	private static Scanner scanner;
	private static Float safetyDistance;
	private static Float maxSpeed;
	
	private static Float distanceFromLeadingVehicle;
	
	public static void main(String[] args) {
		
		RadarSimulatorImpl radarSimulator = new RadarSimulatorImpl();
		DistanceControlImpl distanceControl = new DistanceControlImpl();
		NotificationFactory notification = new NotificationFactory();
		
		while (true){
			
			System.out.println("Input minimum distance: ");
			try{
				scanner = new Scanner(System.in);
				float distanceFromSafetyDistance; // current distance - safety distance (distance to safety distance)
				safetyDistance = scanner.nextFloat();
				
				System.out.println("Input maximum speed: ");
				scanner = new Scanner(System.in);
				maxSpeed = scanner.nextFloat();
				
				System.out.println("Safety Distance: " + safetyDistance + "m");
				System.out.println("Maximum Set Speed: " + maxSpeed + "m/s");
								
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
					catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
								
				System.out.println("-------------------------");
				System.out.println("");
				System.out.println("Current Distance: " + distanceFromLeadingVehicle + "m");
				System.out.println("Safety Distance: " + safetyDistance + "m");
				System.out.println("");
				System.out.println("Distance Gap: " + distanceFromSafetyDistance + "m");
				System.out.println("-------------------------");
				System.out.println("");
			}
			catch (Exception ex){
				System.out.println("Exception: " + ex.toString());
			}
		}

	}

}
