import static org.junit.Assert.*;

import org.junit.Test;

public class PlanetTester {

	// Milky Way
	Planet Earth = new Planet("Earth", 0, "Milky Way", 6.3, 7000);
	Planet Jupiter = new Planet("Jupiter", 3.98, "Milky Way", 69.9, 0);
	Planet Mars = new Planet("Mars", 0.39, "Milky Way", 3.3, 0);
	Planet Venus = new Planet("Venus", 1.70, "Milky Way", 6.1, 0);
	Planet Saturn = new Planet("Saturn", 8.05, "Milky Way", 58.2, 0);

	//Hoag's Object.
	Planet DSTucanae = new Planet("DS Tucanae Ab", 172.3, "Hoag's Object", 0.5, 500);
	Planet Gliese143 = new Planet("Gliese 143 b", 180.2, "Hoag's Object", 0.2, 450);
	Planet HATP69b = new Planet("HAT-P-69b", 162.3, "Hoag's Object", 1.6, 1000);
	Planet HD15337 = new Planet("HD 15337 b", 154.5, "Hoag's Object", 0.2, 2145);
	Planet HD202772 = new Planet("HD 202772 Ab", 180.6, "Hoag's Object", 1.5, 369);

	//Andromeda
	Planet COROT25b = new Planet("COROT-25b", 285.0, "Andromeda", 1.1, 245);
	Planet HATS2b = new Planet("HATS-2b", 241.6, "Andromeda", 1.6, 582);
	Planet KELT3b = new Planet("KELT-3b", 241.8, "Andromeda", 1.3, 2114);
	Planet PH2b = new Planet("PH2b", 236.4, "Andromeda", 0.9, 789);
	Planet WASP75b = new Planet("WASP-75b", 236.5, "Andromeda", 1.2, 156);

	Planet[] nullGalaxy = {null, null, null}; 
	Planet[] milkyWay = {Earth, Jupiter, Mars, Venus, Saturn};
	Planet[] milkyWay1 = {Earth, null, null, null};
	Planet[] hoagsObject = {DSTucanae, Gliese143, HATP69b, HD15337, HD202772};
	Planet[] hoagsObject1 = {Gliese143, DSTucanae};
	Planet[] andromeda = {COROT25b, HATS2b, KELT3b, PH2b, WASP75b};
	Planet[] andromeda1 = {COROT25b, null, null, null};
	Planet[] universe1 = {Earth, Jupiter, DSTucanae, Gliese143, COROT25b};
	Planet[] universe2 = {Mars, Venus, HATP69b, HD15337, HATS2b};
	Planet[] universe3 = {Saturn, HD202772, KELT3b, PH2b, WASP75b};

	@Test
	public void sameGalaxyTest() {
		assertEquals("The method is not verifying galaxy correctly", 5, Planet.sameGalaxy(milkyWay, "Milky Way").length);
		assertEquals("The method is not verifying galaxy correctly", 0, Planet.sameGalaxy(milkyWay, "Andromeda").length);
		assertEquals("The method is not verifying galaxy correctly", 2, Planet.sameGalaxy(universe1, "Hoag's Object").length);
		assertEquals("The method is not verifying galaxy correctly", 1, Planet.sameGalaxy(universe3, "Milky Way").length);
		assertEquals("The method is not verifying galaxy correctly", 1, Planet.sameGalaxy(universe2, "Andromeda").length);
	}

	@Test
	public void highestPopulationTest() {
		assertEquals("The method is not outputing the correct string", "Planet Earth", Planet.hightestPopulation(universe1));
		assertEquals("The method is not outputing the correct string", "Planet HD 15337 b", Planet.hightestPopulation(universe2));
		assertEquals("The method is not outputing the correct string", "Planet KELT-3b", Planet.hightestPopulation(universe3));
		assertEquals("The method is not outputing the correct string", "Planet KELT-3b", Planet.hightestPopulation(andromeda));
		assertEquals("The method is not outputing the correct string", "Planet Earth", Planet.hightestPopulation(milkyWay));
	}

	@Test
	public void closestToEarthTest() {
		assertEquals("The method is not outputing the correct planet", Earth, Planet.closestToEarth(universe1));
		assertEquals("The method is not outputing the correct planet", Mars, Planet.closestToEarth(universe2));
		assertEquals("The method is not outputing the correct planet", Saturn, Planet.closestToEarth(universe3));
		assertEquals("The method is not outputing the correct planet", PH2b, Planet.closestToEarth(andromeda));
		assertEquals("The method is not outputing the correct planet", HD15337, Planet.closestToEarth(hoagsObject));
	}

	@Test
	public void planetSmallerThanTest() {
		assertEquals("The method is not outputing the correct array", 1, Planet.planetsSmallerThan(andromeda, 1.0).length);
		assertEquals("The method is not outputing the correct array", 3, Planet.planetsSmallerThan(hoagsObject, 1.0).length);
		assertEquals("The method is not outputing the correct array", 3, Planet.planetsSmallerThan(milkyWay, 10.0).length);
		assertEquals("The method is not outputing the correct array", 3, Planet.planetsSmallerThan(universe1, 2.0).length);
		assertEquals("The method is not outputing the correct array", 4, Planet.planetsSmallerThan(universe2, 5.0).length);
	}

	@Test
	public void moreThanTwoPlanets() {
		assertFalse("The method is not outputing the correct boolean", Planet.moreThanTwoPlanets(milkyWay1));
		assertTrue("The method is not outputing the correct boolean", Planet.moreThanTwoPlanets(hoagsObject1));
		assertTrue("The method is not outputing the correct boolean", Planet.moreThanTwoPlanets(andromeda));
		assertFalse("The method is not outputing the correct boolean", Planet.moreThanTwoPlanets(nullGalaxy));
		assertFalse("The method is not outputing the correct boolean", Planet.moreThanTwoPlanets(andromeda1));
	}

}
