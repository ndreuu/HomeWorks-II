package Cars;

import myCar.Car;

public class LadaPriora extends Car {
	private int year;

	public LadaPriora(int maxSpeed, int maxPassengers, int price, String country, String name, int year) {
		super(maxSpeed, maxPassengers, price, country, name);
		this.year = year;
	}

	public String getInfo() {
		return super.getInfo() + " | " + "year: " + year;
	}

	public int getYear() {
		return year;
	}
}
