package sensor;

public class LightSensor{

	private boolean lightStatus;

	public boolean isLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(boolean lightStatus) {
		this.lightStatus = lightStatus;
	}

	public String sendReading(boolean lightStatus){
		String status = lightStatus ? "on" : "off";
		return "Lights are " + status;
	}

}
