package actuators_impl;
import actuators.Accelerator;
/*
		* This is Java implementation of the atomic component Accelerator
		*/
		
		
public class AcceleratorImpl implements Accelerator {
		
	//Constructor of atomic component Accelerator
	public AcceleratorImpl() {}
	
	public Float accelerate (Float throttlePosition, Float currentSpeed) {
		return currentSpeed+=1;	
	}
	
	public Float decelerate (Float throttlePosition, Float currentSpeed) {
		return currentSpeed-=1;	
	}
	
}