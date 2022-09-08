import static org.junit.Assert.*;

import org.junit.Test;

public class StreetWrapperTester {

	@Test
	public void testNameableInterface() {

		
		StreetWrapper.Street street1 = new StreetWrapper.Street("Rodeo Drive", 3200);
		StreetWrapper.Street street2 = new StreetWrapper.Street("Mulholland Drive", 34000);
		StreetWrapper.Street street3 = new StreetWrapper.Street("Hollywood Boulevard", 7400);
		StreetWrapper.Street street4 = new StreetWrapper.Street("Sunset Boulevard", 35000);
		StreetWrapper.Street street5 = new StreetWrapper.Street("Melrose Avenue", 3500);

		assertTrue("Street does not implement Nameable interface", street1 instanceof StreetWrapper.Nameable);
		
		assertEquals("getName() is not properly implemented", "Rodeo Drive", street1.getName());
		assertEquals("getName() is not properly implemented", "Mulholland Drive", street2.getName());
		assertEquals("getName() is not properly implemented", "Hollywood Boulevard", street3.getName());
		assertEquals("getName() is not properly implemented", "Sunset Boulevard", street4.getName());
		assertEquals("getName() is not properly implemented", "Melrose Avenue", street5.getName());
		
		assertEquals("getDistance() is not properly implemented", 3200, street1.getDistance());
		assertEquals("getDistance() is not properly implemented", 34000, street2.getDistance());
		assertEquals("getDistance() is not properly implemented", 7400, street3.getDistance());
		assertEquals("getDistance() is not properly implemented", 35000, street4.getDistance());
		assertEquals("getDistance() is not properly implemented", 3500, street5.getDistance());


	}
}

