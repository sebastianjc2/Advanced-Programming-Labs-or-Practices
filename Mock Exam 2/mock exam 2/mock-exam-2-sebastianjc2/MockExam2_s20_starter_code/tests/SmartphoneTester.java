import static org.junit.Assert.*;
import org.junit.Test;

public class SmartphoneTester {

	Smartphone Iphone8 = new Smartphone("Apple", "8", 799);	
	Smartphone IphoneSE = new Smartphone("Apple", "SE", 360);
	Smartphone IphoneX = new Smartphone("Apple", "X", 1000);
	Smartphone GalaxyS8 = new Smartphone("Samsung", "Galaxy S8", 600);
	Smartphone Note8 = new Smartphone("Samsung", "Galaxy Note 8", 870);
	Smartphone GalaxyS7 = new Smartphone("Samsung", "Galaxy S7", 480);
	Smartphone Pixel2 = new Smartphone("Google", "Pixel 2", 649);
	Smartphone Nexus5 = new Smartphone("Google", "Nexus 5", 400);
	Smartphone OnePlus5T = new Smartphone("OnePlus", "5T", 500);
	Smartphone V30 = new Smartphone("LG", "V30", 850);
	Smartphone G5 = new Smartphone("LG", "G5", 408);
	Smartphone Revvl = new Smartphone("Tmobile", "Revvl", 150);
	Smartphone Cymbal = new Smartphone("ZTE", "Z-320", 75);
	Smartphone ZForce2 = new Smartphone("Motorola", "ZForce Edition 2nd Gen", 375);
	Smartphone DuraForce = new Smartphone("Kyocera", "DuraForce XD", 240);
	Smartphone Desire = new Smartphone("HTC", "Desire 530", 120);
	Smartphone Catalyst = new Smartphone("Coolpad", "Catalyst", 96);
	Smartphone RazerPhone = new Smartphone("Razer", "JustRazerPhone", 700);
	Smartphone OneTouch = new Smartphone("Alcatel", "Onetouch Fierce", 144);
	
	Smartphone[] stock1 = {IphoneX, GalaxyS8, Note8, OneTouch, ZForce2, OnePlus5T, GalaxyS7, IphoneX, IphoneX, GalaxyS7};
	Smartphone[] stock2 = {IphoneX, Note8, IphoneSE, Iphone8, Revvl, V30, G5, G5};
	Smartphone[] stock3 = {Nexus5, Pixel2, Cymbal, RazerPhone, DuraForce, Desire, Catalyst, RazerPhone, Cymbal};
	
	@Test
	public void testcountSameBrand() {

		assertEquals("The method is counting incorrectly", 4, GalaxyS7.countSameBrand(stock1));
		assertEquals("The method is counting incorrectly", 3, IphoneSE.countSameBrand(stock2));
		assertEquals("The method is counting incorrectly", 2, RazerPhone.countSameBrand(stock3));
		assertEquals("The method is counting incorrectly", 2, Pixel2.countSameBrand(stock3));
		assertNotEquals("The method is counting incorrectly", 8, Revvl.countSameBrand(stock3));
		assertNotEquals("The method is counting incorrectly", 5, G5.countSameBrand(stock1));
	}

	@Test
	public void testIsAvailable() {

		assertTrue("The method is returning the incorrect boolean", IphoneX.isAvailable(stock1));
		assertTrue("The method is returning the incorrect boolean", OneTouch.isAvailable(stock1));
		assertTrue("The method is returning the incorrect boolean", RazerPhone.isAvailable(stock3));
		assertFalse("The method is returning the incorrect boolean", OnePlus5T.isAvailable(stock2));
		assertFalse("The method is returning the incorrect boolean", Cymbal.isAvailable(stock2));
		assertFalse("The method is returning the incorrect boolean", Nexus5.isAvailable(stock2));
	}

	@Test
	public void testHighestPrice() {

		assertFalse("The method isn't returning what's expected",Smartphone.highestPrice(stock1) == null);
		assertFalse("The method isn't returning what's expected",Smartphone.highestPrice(stock2) == null);
		assertFalse("The method isn't returning what's expected",Smartphone.highestPrice(stock3) == null);
		assertEquals("The method isn't returning what's expected",IphoneX, Smartphone.highestPrice(stock1));
		assertEquals("The method isn't returning what's expected",IphoneX, Smartphone.highestPrice(stock2));
		assertEquals("The method isn't returning what's expected",RazerPhone, Smartphone.highestPrice(stock3));
		assertNotEquals("The method isn't returning what's expected",Iphone8, Smartphone.highestPrice(stock1));
		assertNotEquals("The method isn't returning what's expected",DuraForce, Smartphone.highestPrice(stock3));
		assertNotEquals("The method isn't returning what's expected",Revvl, Smartphone.highestPrice(stock2));
	}
	

	@Test
	public void testPhonesInBudget() {

		Smartphone[] budgetPhones1 = Smartphone.phonesInBudget(stock1, 600);
		Smartphone[] budgetPhones2 = Smartphone.phonesInBudget(stock2, 400);
		Smartphone[] budgetPhones3 = Smartphone.phonesInBudget(stock3, 400);
		

		assertFalse("The method is returning the incorrect array", budgetPhones1 == null);
		assertTrue("The method is returning the incorrect array", budgetPhones1.length == 6);
		assertTrue("The method is returning the incorrect array", budgetPhones1[0] != null);
		assertTrue("The method is returning the incorrect array", budgetPhones1[0].getPrice() <= 600);

		for (int i = 6; i < budgetPhones1.length; i++) {

			assertTrue("The method is returning the incorrect array", budgetPhones1[i] == null);
		}
		
		assertTrue("The method is returning the incorrect array", budgetPhones2[0] != null);
		assertTrue("The method is returning the incorrect array", budgetPhones2[0].getPrice() <= 400);

		for (int i = 2; i < budgetPhones2.length; i++) {

			assertTrue("The method is returning the incorrect array", budgetPhones2[i] == null);
		}
		assertTrue("The method is returning the incorrect array", budgetPhones3[0] != null);
		assertTrue("The method is returning the incorrect array", budgetPhones3[0].getPrice() <= 400);

		for (int i = 6; i < budgetPhones3.length; i++) {

			assertTrue("The method is returning the incorrect array", budgetPhones3[i] == null);	
		}
	}
	
		
	@Test 
	public void testFindModel() {

		assertNotNull("The method is not returning what's expected",Smartphone.findModel(stock1, OnePlus5T.getModel()));
		assertEquals("The method is not returning what's expected",OnePlus5T, Smartphone.findModel(stock1, OnePlus5T.getModel()));
		assertNotNull("The method is not returning what's expected",Smartphone.findModel(stock3, RazerPhone.getModel()));
		assertEquals("The method is not returning what's expected",RazerPhone, Smartphone.findModel(stock3, RazerPhone.getModel()));
		assertNotNull("The method is not returning what's expected",Smartphone.findModel(stock2, IphoneSE.getModel()));
		assertEquals("The method is not returning what's expected",Pixel2, Smartphone.findModel(stock3, Pixel2.getModel()));
		assertNotEquals("The method is not returning what's expected",Pixel2, Smartphone.findModel(stock2, V30.getModel()));
		assertNotEquals("The method is not returning what's expected",Note8, Smartphone.findModel(stock2, Revvl.getModel()));
		assertNotEquals("The method is not returning what's expected",DuraForce, Smartphone.findModel(stock2, IphoneX.getModel()));
	}

	@Test
	public void testTwoSameModelExist() {

		assertTrue("The method is returning the incorrect boolean", Smartphone.twoWithSameModelExist(stock1));
		assertTrue("The method is returning the incorrect boolean", Smartphone.twoWithSameModelExist(stock2));
		assertTrue("The method is returning the incorrect boolean", Smartphone.twoWithSameModelExist(stock3));
		assertFalse("The method is returning the incorrect boolean", !Smartphone.twoWithSameModelExist(stock3));
		assertFalse("The method is returning the incorrect boolean", !Smartphone.twoWithSameModelExist(stock2));
		assertFalse("tThe method is returning the incorrect boolean", !Smartphone.twoWithSameModelExist(stock1));
	}

}