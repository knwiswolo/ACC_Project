package control_system_impl;
import control_system.DistanceControl;

/** This is Java implementation of the atomic component distanceControl
		*/

public class DistanceControlImpl implements DistanceControl {

	/**
	 * Constructor of atomic component distanceControl
	 */
	public DistanceControlImpl() {}
		
	public Float calculateDistanceFromSafetyDistance (Float distanceFromLeadingVehicle, Float safetyDistance) {
		
		// difference btw set safety distance and current distance
	    Float distanceFromSafetyDistance = distanceFromLeadingVehicle - safetyDistance; 
	    return distanceFromSafetyDistance;
	}
	
	public void decrementDistance(Float distanceFromLeadingVehicle, Float distanceFromSafetyDistance, Float safetyDistance){
		distanceFromLeadingVehicle--;
		distanceFromSafetyDistance--;
	}
	
	public void incrementDistance(Float distanceFromLeadingVehicle, Float distanceFromSafetyDistance, Float safetyDistance){
		distanceFromLeadingVehicle++;
		distanceFromSafetyDistance++;
	}

	@Override
	public Float calculateThrottlePosition(Float currentSpeed, Float cruiseControlSpeed) {
		// TODO Auto-generated method stub
		return null;
	}
}

//displacement = (currentSpeed*time) + (0.5*acceleration*Math.pow(time,2));
