package vehicle_states;

public class VehicleStateFactory {
	
	public VehicleState createVehicleState(Float clearance, Float safetyDistance){
		if (clearance == null){
			return null;
		}
		else if(clearance <= safetyDistance/2){
			DangerZoneState dangerZoneState = new DangerZoneState();
			return dangerZoneState;
		}
		else if(clearance <= safetyDistance && clearance > safetyDistance/2){
			ZoneAState zoneAState = new ZoneAState();
			return zoneAState;
		}
		else if(clearance > safetyDistance && clearance <= 1.5*safetyDistance){
			ZoneBState zoneBState = new ZoneBState();
			return zoneBState;
		}
		else if(clearance > safetyDistance && clearance <= 2*safetyDistance){
			ZoneCState zoneCState = new ZoneCState();
			return zoneCState;
		}
		else if(clearance > 2*safetyDistance){
			ZoneDState zoneDState = new ZoneDState();
			return zoneDState;
		}
		return null;
	} 
}
