package Cars;

import myCar.Car;

public class Volga extends Car {
	private String color;

	public Volga(int maxSpeed, int maxPassengers, int price, String country, String name, String color) {
		super(maxSpeed, maxPassengers, price, country, name);
		this.color = color;
	}

	public String getInfo() {
		return super.getInfo() + " | " + "color: " + color;
	}

	public String getColor() {
		return color;
	}
}
