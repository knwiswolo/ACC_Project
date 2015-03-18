package simulators_impl;

import simulators.RadarSimulator;

/** This is Java implementation of the atomic component RadarSimulator
		*/
		

public class RadarSimulatorImpl implements RadarSimulator {
	
	// Constructor of atomic component RadarSimulator
	public RadarSimulatorImpl() {}
	
	public  Float  RadarSimulator () {
		
		Float relativeDistance = null;
		// TODO: auto-generated code, to be implemented by developers
		float min = 5;
		float max = 30;
		
		relativeDistance = (float) (Math.random() < 0.5 ? ((1-Math.random()) * (max-min) + min) : (Math.random() * (max-min) + min));

		return relativeDistance;		
	}
	
}