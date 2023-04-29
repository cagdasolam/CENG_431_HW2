package actuator;

public class LightBulb extends Actuator{

	private boolean status;

	public boolean isStatus() {
		return status;
	}

	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}
}
