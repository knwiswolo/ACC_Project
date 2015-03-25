/**
 * 
 */
package throttle;

/**
 * @author knwiswolo
 *
 */
public class Throttle {

	private Float throttlePostion = null;
	
	public Throttle(){}

	public Float getThrottlePostion() {
		return throttlePostion;
	}

	public void setThrottlePostion(Float speed) {
		this.throttlePostion = speed/10;
	}
	
	
}
