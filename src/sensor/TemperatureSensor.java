package sensor;

import java.text.DecimalFormat;

public class TemperatureSensor extends Sensor{

	@Override
	public String sendReading(boolean status){
		if (status){
			return "Temperature is increased";
		}
		return "Temperature is decreased";
	}

	public String sendReading(double temperature, double usersTemp) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		if (usersTemp > 25){
			return df.format(usersTemp) + " is too hot, temperature is set to " + df.format(temperature);
		}
		if (usersTemp < 20){
			return df.format(usersTemp) + " is too cold, temperature is set to " + df.format(temperature);
		}
		return "The temperature is " + df.format(temperature);
	}

	public String sendReading(double temperature) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		return "The temperature is " + df.format(temperature);
	}



}
