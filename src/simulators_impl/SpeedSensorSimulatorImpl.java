package simulators_impl;
import java.util.Date;

import simulators.SpeedSensorSimulator;

/** This is Java implementation of the atomic component SpeedSensorSimulator
		*/
		
		
public class SpeedSensorSimulatorImpl implements SpeedSensorSimulator {

	// Constructor of atomic component SpeedSensorSimulator
	public SpeedSensorSimulatorImpl() {}
	
	public Float simulateSpeedSensor() {
		Float currentSpeed = null;
		
		float min = 20;
		float max = 100;
		currentSpeed = (float) (Math.random() < 0.5 ? ((1-Math.random()) * (max-min) + min) : (Math.random() * (max-min) + min));

    	return currentSpeed;			
	}
	
	public void speedDistanceRelationship(Float speed, Float distance, Date time){
		
	}
}

/*
 * Speed = Distance/Time

Time = Distance/Speed

Distance = Speed × Time
 * */
 