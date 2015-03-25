package actuators;
/** This is Java interface of the component Accelerator
		*/
				
		
public interface Accelerator {
	
	public  Float  accelerate (Float throttlePosition, Float currentSpeed); 
	public  Float  decelerate (Float throttlePosition, Float currentSpeed);
	
}