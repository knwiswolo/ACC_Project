package vehicle_states;

public class ZoneCState implements VehicleState {

	@Override
	public void doAction(VehicleStateContext vsContext) {
		System.out.println("Vehicle is in <Zone C>");
		vsContext.setVehicleState(this);
	}
	
	public String toString(){
		return "ZONE C";
	}
}
