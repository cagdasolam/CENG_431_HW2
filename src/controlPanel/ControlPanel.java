package controlPanel;

import randomNumberGenerator.RandomNumberGenerator;

public class ControlPanel implements IControlPanel{

	@Override
	public double setTemperature() {
		return RandomNumberGenerator.getRandomDouble(10, 35);
	}

	@Override
	public boolean turnOnOffLights() {
		int randInt = RandomNumberGenerator.generateRandomNumber(0,1);
		return randInt != 0;
	}

	@Override
	public boolean lockUnlockDoors() {
		int randInt = RandomNumberGenerator.generateRandomNumber(0,1);
		return randInt != 0;
	}
}
