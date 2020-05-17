package Cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadaPrioraTest {

	private LadaPriora myPriora;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		myPriora = new LadaPriora(200, 4, 2000000, "Russia","Lada Priora", 2010);
	}

	@org.junit.jupiter.api.Test
	void getInfo() {
		assertEquals("Lada Priora | made in Russia | count of seats: 4 | max speed: 200 | cost: 2000000 | year: 2010", myPriora.getInfo());
	}

	@org.junit.jupiter.api.Test
	void maxSpeed() {
		assertEquals(200, myPriora.MaxSpeed());
	}

	@org.junit.jupiter.api.Test
	void maxPassengers() {
		assertEquals(4, myPriora.MaxPassengers());
	}

	@org.junit.jupiter.api.Test
	void price() {
		assertEquals(2000000, myPriora.Price());
	}

	@org.junit.jupiter.api.Test
	void country() {
		assertEquals("Russia", myPriora.Country());
	}

	@org.junit.jupiter.api.Test
	void name() {
		assertEquals("Lada Priora", myPriora.Name());
	}

	@Test
	void getYear() {
		assertEquals(2010, myPriora.getYear());
	}
}