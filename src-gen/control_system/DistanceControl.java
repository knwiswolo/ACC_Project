package control_system;
/** This is Java interface of the component distanceControl
*/
		
		
		
public interface DistanceControl {
	public Float calculateDistanceFromSafetyDistance (Float currentDistance, Float safetyDistance); 
	public Float calculateThrottlePosition(Float currentSpeed, Float cruiseControlSpeed);
}