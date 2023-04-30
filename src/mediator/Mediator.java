package mediator;

import actuator.DoorLock;
import actuator.LightBulb;
import actuator.Thermostat;
import controlPanel.ControlPanel;
import randomNumberGenerator.RandomNumberGenerator;
import sensor.LightSensor;
import sensor.MotionSensor;
import sensor.TemperatureSensor;

import java.text.DecimalFormat;

public class Mediator {

	private final ControlPanel controlPanel;
	private final LightSensor lightSensor;
	private final MotionSensor motionSensor;
	private final TemperatureSensor temperatureSensor;
	private final Thermostat thermostat;
	private final DoorLock doorLock;
	private final LightBulb lightBulb;

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
		double usersTemp = controlPanel.setTemperature();
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		System.out.println("Temperature set to " + df.format(usersTemp));
		thermostat.setTemperature(usersTemp);
		String sensorReading = temperatureSensor.sendReading(usersTemp);
		if (20 > usersTemp || usersTemp > 25){
			double rearrangedTemp = RandomNumberGenerator.getRandomDouble(20, 25);
			thermostat.setTemperature(rearrangedTemp);
			sensorReading = temperatureSensor.sendReading(rearrangedTemp, usersTemp);
		}
		System.out.println(sensorReading);
	}

	private void setLight(){
		boolean newStatus = controlPanel.turnOnOffLights();
		lightBulb.setStatus(newStatus);
		String sensorReading = lightSensor.sendReading(newStatus);
		System.out.println(sensorReading);
	}

	private void setLock(){
		boolean newStatus = controlPanel.lockUnlockDoors();
		doorLock.setStatus(newStatus);
		String sensorReading = motionSensor.sendReading(newStatus);
		System.out.println(sensorReading);
	}
	public void run(){
		int count = 0;
		while (count < 20) {
			System.out.println("second " + ++count + ":");
			setTemperature();
			setLight();
			setLock();
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
