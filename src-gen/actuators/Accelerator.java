package actuators;
/** This is Java interface of the component Accelerator
		*/
				
		
public interface Accelerator {
	
	public  void  Accelerate (Float throttlePosition, Float currentSpeed); 
	public  void  Decelerate (Float throttlePosition, Float currentSpeed);
	
}