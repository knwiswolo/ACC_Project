package control_system_impl;
import throttle.Throttle;
import control_system.SpeedControl;
import notification.NotificationFactory;
/** This is Java implementation of the atomic component SpeedControl
*/
		
				
public class SpeedControlImpl implements SpeedControl {

	//Constructor of atomic component distanceControl
	public SpeedControlImpl() {}
	
	NotificationFactory notification = new NotificationFactory();
	Throttle throttle = new Throttle();
	
	public Float speedControl (Float currentSpeed, Float cruiseControlSpeed, Float distanceFromLeadingVehicle, Float distanceFromSafetyDistance, Float safetyDistance) {
		Float finalSpeed = null;
		throttle.setThrottlePostion(currentSpeed);
		
		for(float i = (distanceFromLeadingVehicle-1); i >0; i--){
			if(currentSpeed > cruiseControlSpeed && currentSpeed < 100){
				try{
					Thread.sleep(1000);
					distanceFromLeadingVehicle--;
					distanceFromSafetyDistance--;
					System.out.println("Current Speed: " + currentSpeed + " m/s");
					System.out.println("Distance from Leading Vehicle: " + distanceFromLeadingVehicle + "m");
					System.out.println("Distance Gap (distance from safety distance): " + distanceFromSafetyDistance + "m");
					
					notification.createNotification(distanceFromLeadingVehicle, safetyDistance);
				}
				catch(Exception ex){ex.printStackTrace();}
			}
		}
		
	    return finalSpeed;
	}
	
	public Float calculateThrottlePosition(){
		
		Float throttlePosition = null;
		
	    return throttlePosition;
	}

}

//finalSpeed = currentSpeed + (acceleration*time)