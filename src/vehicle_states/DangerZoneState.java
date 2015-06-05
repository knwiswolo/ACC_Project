package vehicle_states;

public class DangerZoneState implements VehicleState{

	@Override
	public void doAction(VehicleStateContext vsContext) {
		System.out.println("Vehicle is in <Danger Zone>");
		vsContext.setVehicleState(this);
	}
	
	public String toString(){
		return "DANGER ZONE!";
	}
}
