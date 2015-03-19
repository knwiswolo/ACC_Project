/*
		* This is Java interface of the component Accelerator
		*/
		
		
		import java.util.*;
		
		public interface Accelerator {public  void  Accelerate (
    		Float throttlePosition, 
    		    		Float currentSpeed
    		 ); 
public  void  Decelerate (
    		Float throttlePosition, 
    		    		Float currentSpeed
    		 ); 
}