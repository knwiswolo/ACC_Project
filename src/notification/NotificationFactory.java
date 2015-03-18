/**
 * 
 */
package notification;

/**
 * @author knwiswolo
 *
 */
public class NotificationFactory {

	public Notification createNotification(Float distanceFromLeadingVehicle, Float safetyDistance){
		if (distanceFromLeadingVehicle >= 2.5*safetyDistance){
			Notification notification = new Notification();
			notification.greenNotification();
		}
		else if (distanceFromLeadingVehicle > 1.5*safetyDistance){
			Notification notification = new Notification();
			notification.amberNotification();
		}
		else if (distanceFromLeadingVehicle <= 1.5*safetyDistance && distanceFromLeadingVehicle > safetyDistance){
			Notification notification = new Notification();
			notification.redNotification();
		}
		else if (distanceFromLeadingVehicle < safetyDistance){
			Notification notification = new Notification();
			notification.dangerNotification();
		}
		return null;
	}
}
