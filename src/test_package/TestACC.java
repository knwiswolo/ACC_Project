/**
 * 
 */
package test_package;

import java.util.Scanner;

import actuators_impl.AcceleratorImpl;
import actuators_impl.BrakeSystemImpl;
import control_system_impl.DistanceControlImpl;
import control_system_impl.SpeedControlImpl;
import simulators_impl.RadarSimulatorImpl;
import simulators_impl.SpeedSensorSimulatorImpl;
import throttle.Throttle;
import vehicle_states.VehicleState;
import vehicle_states.VehicleStateContext;
import vehicle_states.VehicleStateFactory;

/**
 * @author knwiswolo
 *
 */
public class TestACC {

	private static Scanner scanner;
	private static Float safetyDistance;
	private static Float cruisingSpeed;
	
	private static Float clearance;
	
	public static void main(String[] args) {
		
		VehicleStateFactory vsFactory = new VehicleStateFactory();
		VehicleState vehicleState;
		
		RadarSimulatorImpl radarSimulator = new RadarSimulatorImpl();
		DistanceControlImpl distanceControl = new DistanceControlImpl();
		
		//NotificationFactory notification = new NotificationFactory();
		SpeedSensorSimulatorImpl speedSimulator = new SpeedSensorSimulatorImpl();
		SpeedControlImpl speedControl = new SpeedControlImpl();
		AcceleratorImpl accelerator = new AcceleratorImpl();
		BrakeSystemImpl brake = new BrakeSystemImpl();
		Throttle throttle = new Throttle();
	
		Float currentSpeed = speedSimulator.simulateSpeedSensor();
		clearance = radarSimulator.simulateRadar();		
		
		
		while (true){
			
			System.out.println("-------------------------");
			System.out.println("Current Speed of ACC_Vehicle: " + currentSpeed + " m/s.");
			System.out.println("Clearance: " + clearance + " m");
			System.out.println("-------------------------");
			
			// ask to Switch on ACC.
			System.out.println("Press 'ON' to activate ACC.");
			System.out.println("-------------------------");
			
			try{
				scanner = new Scanner(System.in);
				String input;
				input = scanner.nextLine();
							
				/**start simulation
				ACC vehicle is moving at randomly generated speed. - ACC OFF.
				- show current speed.
				*/
				
				if(input.equalsIgnoreCase("ON")){
					
					System.out.println("-------------------------");
					System.out.println("ACC System ACTIVATED!");
					System.out.println("-------------------------");
					
					//Initiate ACC System.
							
					// ask for minimum distance from driver
					System.out.println("Input safety distance (m): ");
					float distanceFromSafetyDistance; // current distance - safety distance (distance to safety distance)
					scanner = new Scanner(System.in);
					safetyDistance = scanner.nextFloat();
					
					// ask for maximum speed from driver
					System.out.println("Input cruising speed (m/s): ");
					scanner = new Scanner(System.in);
					cruisingSpeed = scanner.nextFloat();
					
					System.out.println("");
					System.out.println("-------------------------");
					System.out.println("A: Accelerate");
					System.out.println("B: Brake");
					System.out.println("-------------------------");
					System.out.println("");
					
					System.out.println("Press <RETURN> to continue...");
					input = scanner.nextLine();
					
					if(input.equals("")){
						
						input = scanner.nextLine();
						
						if(input.equalsIgnoreCase("A")){
							accelerator.accelerate(throttle.getThrottlePostion(), currentSpeed);
						}
						else if(input.equalsIgnoreCase("B")){
							brake.applyBrakes(throttle.getThrottlePostion(), currentSpeed);
						}
						
						distanceFromSafetyDistance = distanceControl.calculateDistanceFromSafetyDistance(clearance, safetyDistance);
						speedControl.speedControl(currentSpeed, cruisingSpeed, clearance, distanceFromSafetyDistance, safetyDistance);
						
					}
										
				}
			//}
		}catch(Exception ex){ex.printStackTrace();}}
		

	}

}