package vehicle_states;

public class ZoneDState implements VehicleState {

	@Override
	public void doAction(VehicleStateContext vsContext) {
		System.out.println("Vehicle is in <Zone D>");
		vsContext.setVehicleState(this);
	}
	
	public String toString(){
		return "ZONE D";
	}

}
