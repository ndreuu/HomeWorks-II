package myCar;

public abstract class Car {
	private int maxSpeed;
	private  int maxPassengers;
	private int price;
	private String country;
	private String name;

	public Car(int maxSpeed, int maxPassengers, int price, String country, String name) {
		this.maxSpeed = maxSpeed;
		this.maxPassengers = maxPassengers;
		this.price = price;
		this.country = country;
		this.name = name;
	}

	public String getInfo() {
		return name + " | " + "made in " + country + " | " + "count of seats: " + maxPassengers + " | " + "max speed: " + maxSpeed + " | " + "cost: " + price;
	}

	public int MaxSpeed() {
		return maxSpeed;
	}

	public int MaxPassengers() {
		return maxPassengers;
	}

	public int Price() {
		return price;
	}

	public String Country() {
		return country;
	}

	public String Name() {
		return name;
	}
}
