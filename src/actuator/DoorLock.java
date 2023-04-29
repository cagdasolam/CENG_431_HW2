package actuator;

public class DoorLock extends Actuator{

	private boolean status;

	public boolean isStatus() {
		return status;
	}

	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}


}
