package control_system;
/*
		* This is Java interface of the component SpeedControl
		*/
		
				
public interface SpeedControl {
	public Float speedControl (Float currentSpeed, Float cruiseControlSpeed, Float distanceFromLeadingVehicle, Float distanceFromSafetyDistance, Float safetyDistance); 
	public Float calculateThrottlePosition();
}