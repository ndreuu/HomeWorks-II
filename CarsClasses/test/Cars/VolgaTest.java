package Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolgaTest {

	private Volga myVolga;

	@BeforeEach
	void setUp() {
		myVolga = new Volga(100,4,1000000,"USSR","Volga","Black");
	}

	@Test
	void getInfo() {
		assertEquals("Volga | made in USSR | count of seats: 4 | max speed: 100 | cost: 1000000 | color: Black", myVolga.getInfo());
	}

	@Test
	void getColor() {
		assertEquals("Black", myVolga.getColor());
	}


	@Test
	void maxSpeed() {
		assertEquals(100, myVolga.MaxSpeed());
	}

	@Test
	void maxPassengers() {
		assertEquals(4, myVolga.MaxPassengers());
	}

	@Test
	void price() {
		assertEquals(1000000, myVolga.Price());
	}

	@Test
	void country() {
		assertEquals("USSR", myVolga.Country());
	}

	@Test
	void name() {
		assertEquals("Volga", myVolga.Name());
	}


	@Test
	void testGetColor() {
		assertEquals("Black", myVolga.getColor());
	}
}