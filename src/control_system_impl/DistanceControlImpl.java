package control_system_impl;
import control_system.DistanceControl;
import notification.Notification;

/** This is Java implementation of the atomic component distanceControl
		*/


		
public class DistanceControlImpl implements DistanceControl {

	/**
	 * Constructor of atomic component distanceControl
	 */
	public DistanceControlImpl() {}
	
	public Notification notification = new Notification(); 
	
	public Float DistanceControl (Float currentDistance, Float safetyDistance) {
		
		Float displacement = null;
		
		//displacement = (currentSpeed*time) + (0.5*acceleration*Math.pow(time,2));
		
		// difference btw set safety distance and current distance
	    Float distanceDifference = currentDistance - safetyDistance; 
	    return distanceDifference;
	}
	
	public Float calculateThrottlePosition(Float currentSpeed, Float maxSpeed){
		Float throttlePosition = null;
		
		return throttlePosition;
	}
}