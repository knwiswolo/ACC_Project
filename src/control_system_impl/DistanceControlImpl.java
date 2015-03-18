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
		
		// difference btw set safety distance and current distance
	    Float distanceDifference = currentDistance - safetyDistance; 
	    return distanceDifference;
	}
	
	public Float calculateThrottlePosition(){
		Float throttlePosition = null;
		
		
		return throttlePosition;
	}
}