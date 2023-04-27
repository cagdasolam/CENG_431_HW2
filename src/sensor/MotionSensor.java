package sensor;

public class MotionSensor {

	public String sendReading(boolean doorStatus){
		String status = doorStatus ? "locked" : "unlocked";
		return "Doors are " + status;
	}
}
