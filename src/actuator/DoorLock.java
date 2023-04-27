package actuator;

public class DoorLock extends Actuator{

	private boolean isLocked;

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean locked) {
		isLocked = locked;
	}


}
