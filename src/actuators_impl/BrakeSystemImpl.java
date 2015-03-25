package actuators_impl;

import actuators.BrakeSystem;

/** This is Java implementation of the atomic component BrakeSystem
		*/
		
public class BrakeSystemImpl implements BrakeSystem {

	//Constructor of atomic component BrakeSystem
	public BrakeSystemImpl() {}
	
	public void applyBrakes (Float throttlePosition, Float currentSpeed) {
		if(throttlePosition==0){
			System.out.println("no brake application");
		}
		else if(throttlePosition != 0 && currentSpeed > 0){
			for(float i = 0; i <= throttlePosition; i-=throttlePosition){
				currentSpeed--;
			}					
		}
	}
	
}