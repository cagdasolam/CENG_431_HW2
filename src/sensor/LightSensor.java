package sensor;

public class LightSensor extends Sensor{

	@Override
	public String sendReading(boolean lightStatus){
		String status = lightStatus ? "on" : "off";
		return "Lights are " + status;
	}

}
