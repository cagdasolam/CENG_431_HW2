package sensor;

public class MotionSensor extends Sensor {

	@Override
	public String sendReading(boolean doorStatus){
		String status = doorStatus ? "locked" : "unlocked";
		return "Doors are " + status;
	}
}
