package mediator;

import actuator.DoorLock;
import actuator.LightBulb;
import actuator.Thermostat;
import controlPanel.ControlPanel;
import randomNumberGenerator.RandomNumberGenerator;
import sensor.LightSensor;
import sensor.MotionSensor;
import sensor.Sensor;
import sensor.TemperatureSensor;

public class Mediator {

	private ControlPanel controlPanel;
	private LightSensor lightSensor;
	private MotionSensor motionSensor;
	private TemperatureSensor temperatureSensor;
	private Thermostat thermostat;
	private DoorLock doorLock;
	private LightBulb lightBulb;

	public Mediator() {
		this.controlPanel = new ControlPanel();
		this.lightSensor = new LightSensor();
		this.temperatureSensor = new TemperatureSensor();
		this.motionSensor = new MotionSensor();
		this.thermostat = new Thermostat();
		this.lightBulb = new LightBulb();
		this.doorLock = new DoorLock();
	}

	private void setTemperature(){
		double newTemp = controlPanel.setTemperature();
		thermostat.setTemperature(newTemp);
		String sensorReadig = temperatureSensor.sendReading(newTemp);
		System.out.println(sensorReadig);
	}

	private void setLight(){
		boolean newStatus = controlPanel.turnOnOffLights();
		lightBulb.setLightOn(newStatus);
		String sensorReading = lightSensor.sendReading(newStatus);
		System.out.println(sensorReading);
	}

	private void setLock(){
		boolean newStatus = controlPanel.lockUnlockDoors();
		doorLock.setLocked(newStatus);
		String sensorReading = motionSensor.sendReading(newStatus);
		System.out.println(sensorReading);
	}

	public void run(){
		int count = 0;
		while (count < 20) {
			setTemperature();
			setLight();
			setLock();
			count++;
			try {
				Thread.sleep(1000); // 1 saniye bekle
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
