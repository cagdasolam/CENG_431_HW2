package randomNumberGenerator;

import java.util.Random;

public class RandomNumberGenerator {

	public static int generateRandomNumber(int n, int k) {
		return new Random().nextInt(k - n + 1) + n;
	}

	public static int generateRandomNumber(int n) {
		return new Random().nextInt(n) + 1;
	}

	public static double getRandomDouble(double min, double max) {
		return min + (max - min) * new Random().nextDouble();
	}

}