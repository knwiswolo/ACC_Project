package vehicle_states;

public class ZoneAState implements VehicleState{

	@Override
	public void doAction(VehicleStateContext vsContext) {
		System.out.println("Vehicle is in <Zone A>");
		vsContext.setVehicleState(this);
	}
	
	public String toString(){
		return "ZONE A";
	}
}
