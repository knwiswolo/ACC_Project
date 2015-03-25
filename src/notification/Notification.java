/**
 * 
 */
package notification;

/**
 * @author knwiswolo
 *
 */
public class Notification {
	
	public void greenNotification(){
		System.out.println("---------------");
		System.out.println("OK Distance."); // reach/maintain Cruise Control Speed
		System.out.println("---------------");
	}

	public void amberNotification(){
		System.out.println("---------------------------------------------");
		System.out.println("Approaching Safety Distance!! - DECELERATE."); // signal to accelerator for DECELERATION
		System.out.println("---------------------------------------------");
	}
	
	public void redNotification(){
		System.out.println("---------------");
		System.out.println("APPLY BRAKES!"); // signal to CBS or OVERRIDE
		System.out.println("---------------");
	}
	
	public void dangerNotification(){
		System.out.println("---------------");
		System.out.println("<<DANGER>>"); // signal to CBS or OVERRIDE
		System.out.println("---------------");
	}
}
