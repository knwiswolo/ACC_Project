package vehicle_states;

public class ZoneBState implements VehicleState{

	@Override
	public void doAction(VehicleStateContext vsContext) {
		System.out.println("Vehicle is in <Zone B>");
		vsContext.setVehicleState(this);
	}
	
	public String toString(){
		return "ZONE B";
	}
}
