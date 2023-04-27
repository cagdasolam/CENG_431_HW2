package actuator;

public class LightBulb extends Actuator{

	private boolean isLightOn;

	public boolean isLightOn() {
		return isLightOn;
	}

	public void setLightOn(boolean lightOn) {
		isLightOn = lightOn;
	}
}
