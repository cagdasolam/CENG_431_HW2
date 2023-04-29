package actuator;

public abstract class Actuator {

	private boolean status;
	public abstract void setStatus(boolean newStatus);
}
