package actuators_impl;
import actuators.Accelerator;
/*
		* This is Java implementation of the atomic component Accelerator
		*/
		
		
public class AcceleratorImpl implements Accelerator {
	

	//Constructor of atomic component Accelerator
	public AcceleratorImpl() {}
	
	public  void  Accelerate (Float throttlePosition, Float currentSpeed) {
		if(throttlePosition==0){
			System.out.println("no acceleration");
		}
		else if(throttlePosition != 0 && currentSpeed < 250){
			for(float i = 0; i <= throttlePosition; i+=throttlePosition){
				currentSpeed++;
			}			
		}
	}
	public  void  Decelerate (Float throttlePosition, Float currentSpeed) {
		if(throttlePosition==0){
			System.out.println("no deceleration");
		}
		else if(throttlePosition != 0 && currentSpeed > 0){
			for(float i = 0; i <= throttlePosition; i-=throttlePosition){
				currentSpeed--;
			}					}
	}
	
}