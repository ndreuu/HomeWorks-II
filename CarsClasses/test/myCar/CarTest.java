package myCar;

import Cars.LadaPriora;
import Cars.Volga;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

	private LadaPriora myPriora;
	private Volga myVolga;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		myPriora = new LadaPriora(200, 4, 2000000, "Russia","Lada Priora", 2010);
		myVolga = new Volga(100,4,1000000,"USSR","Volga","Black");
	}

	@org.junit.jupiter.api.Test
	void getInfo() {
		assertEquals("Lada Priora | made in Russia | count of seats: 4 | max speed: 200 | cost: 2000000 | year: 2010", myPriora.getInfo());
		assertEquals("Volga | made in USSR | count of seats: 4 | max speed: 100 | cost: 1000000 | color: Black", myVolga.getInfo());
	}

	@org.junit.jupiter.api.Test
	void maxSpeed() {
		assertEquals(200, myPriora.MaxSpeed());
		assertEquals(100, myVolga.MaxSpeed());
	}

	@org.junit.jupiter.api.Test
	void maxPassengers() {
		assertEquals(4, myPriora.MaxPassengers());
		assertEquals(4, myVolga.MaxPassengers());
	}

	@org.junit.jupiter.api.Test
	void price() {
		assertEquals(2000000, myPriora.Price());
		assertEquals(1000000, myVolga.Price());
	}

	@org.junit.jupiter.api.Test
	void country() {
		assertEquals("Russia", myPriora.Country());
		assertEquals("USSR", myVolga.Country());
	}

	@org.junit.jupiter.api.Test
	void name() {
		assertEquals("Lada Priora", myPriora.Name());
		assertEquals("Volga", myVolga.Name());
	}
}