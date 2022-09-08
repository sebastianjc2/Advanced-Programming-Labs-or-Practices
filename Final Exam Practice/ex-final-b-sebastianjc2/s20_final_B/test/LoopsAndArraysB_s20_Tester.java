import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LoopsAndArraysB_s20_Tester {

	LoopsAndArraysB_s20.Gadget g0;
	LoopsAndArraysB_s20.Gadget g1;
	LoopsAndArraysB_s20.Gadget g2;
	LoopsAndArraysB_s20.Gadget g3;
	LoopsAndArraysB_s20.Gadget g4;
	LoopsAndArraysB_s20.Gadget g5;
	LoopsAndArraysB_s20.Gadget g6;
	LoopsAndArraysB_s20.Gadget g7;
	LoopsAndArraysB_s20.Gadget g8;
	LoopsAndArraysB_s20.Gadget g9;
	//
	LoopsAndArraysB_s20.Gadget gA;
	LoopsAndArraysB_s20.Gadget gB;
	LoopsAndArraysB_s20.Gadget gC;
	LoopsAndArraysB_s20.Gadget gD;
	

	@Before
	public void loadGadgets() {
		//Gadget(Brand brand, Type type, int rewardPoints, double rewardPrice, double fullPrice)
		g0 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.ACME,LoopsAndArraysB_s20.Gadget.Type.TABLET,
				200, 179.97, 359.99);
		g1 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.DEALDEAL,LoopsAndArraysB_s20.Gadget.Type.MOBILE,
				400, 399.97, 699.99);
		g2 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.EASYBUY,LoopsAndArraysB_s20.Gadget.Type.CHROMEBOOK,
				450, 199.97, 299.99);
		g3 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.CHEAPO,LoopsAndArraysB_s20.Gadget.Type.NOTEBOOK,
				650, 249.97, 309.99);
		g4 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.FUNTOY,LoopsAndArraysB_s20.Gadget.Type.LAPTOP,
				850, 419.97, 619.99);
		g5 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.BASICO,LoopsAndArraysB_s20.Gadget.Type.DESKTOP,
				1200, 399.97,749.99);
		g6 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.CHEAPO,LoopsAndArraysB_s20.Gadget.Type.WORKSTATION,
				9500, 3199.97, 4399.99);
		g7 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.EASYBUY,LoopsAndArraysB_s20.Gadget.Type.TABLET,
				500, 159.97, 249.99);
		g8 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.CHEAPO,LoopsAndArraysB_s20.Gadget.Type.MOBILE,
				600, 444.97, 555.99);
		g9 = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.FUNTOY,LoopsAndArraysB_s20.Gadget.Type.CHROMEBOOK,
				750, 234.97, 299.99);
		//
		gA = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.CHEAPO,LoopsAndArraysB_s20.Gadget.Type.NOTEBOOK,
				750, 299.97, 329.99);
		gB = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.ACME,LoopsAndArraysB_s20.Gadget.Type.LAPTOP,
				1200, 399.97, 799.99);
		gC = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.FUNTOY,LoopsAndArraysB_s20.Gadget.Type.WORKSTATION,
				3200, 3299.97, 3399.99);
		gD = new LoopsAndArraysB_s20.Gadget(LoopsAndArraysB_s20.Gadget.Brand.FUNTOY,LoopsAndArraysB_s20.Gadget.Type.WORKSTATION,
				1000, 1999.97, 6999.99);
	}

	
	@Test
	public void betterValueExistsTest() {
		LoopsAndArraysB_s20.Gadget[] emptyStore = {};
		LoopsAndArraysB_s20.Gadget[] oneGadget = { g4 } ;
		LoopsAndArraysB_s20.Gadget[] firstStore = { g0, g1, g2, g3, g4};
		LoopsAndArraysB_s20.Gadget[] secondStore = { g5, g6, g7, g8, g9};

		assertFalse("No Gadget exists in a empty list.", gA.betterValueExists(emptyStore));
		assertTrue("There is a better Type of Gadget.", gA.betterValueExists(oneGadget)); 
		assertFalse("There is not a better Type of Gadget.", gB.betterValueExists(oneGadget)); 
		assertTrue("There is a better Type of Gadget.", gA.betterValueExists(firstStore));    
		assertFalse("There is not a better Type of Gadget.", gB.betterValueExists(firstStore)); 
		assertTrue("There is a higher ranking Gadget.", gB.betterValueExists(secondStore));      
		assertFalse("There is not a better value.", gD.betterValueExists(secondStore));
	}
	
	
	@Test
	public void compareToTest() {
		LoopsAndArraysB_s20.CompareHelper testComp = new LoopsAndArraysB_s20.CompareHelper();
		
		assertTrue("message", testComp.compare(g1,g2) < 0);  //     
		assertFalse("message", testComp.compare(g2,g1) < 0); //
		assertFalse("message", testComp.compare(g1,g2) == 0); //
		assertTrue("message", testComp.compare(g5,gB) == 0); //
		
		assertTrue("message", testComp.compare(g9,gA) < 0);  //     
		assertFalse("message", testComp.compare(gA,g9) < 0); //
		
		assertTrue("message", testComp.compare(gA,g9) > 0);  //     
		assertFalse("message", testComp.compare(g9,gA) > 0); //
	}
	
	@Test
	public void gadgetStatsTest() {
		
		double delta = 0.01;
		int i=0,j=1,k=2;
		 
		LoopsAndArraysB_s20.Gadget[] emptyStore = {};
		LoopsAndArraysB_s20.Gadget[] oneGadgetStore = { g4 } ;
		LoopsAndArraysB_s20.Gadget[] firstStore = { g0, g1, g2, g3, g4};
		LoopsAndArraysB_s20.Gadget[] secondStore = { g5, g6, g7, g8, g9};
		
		  assertEquals("Expected null", null, LoopsAndArraysB_s20.Gadget.gadgetStats(emptyStore));
		  assertNotEquals("Should not return zero", 0.0, LoopsAndArraysB_s20.Gadget.gadgetStats(emptyStore));
		  
		  assertEquals("min", 619.99, LoopsAndArraysB_s20.Gadget.gadgetStats(oneGadgetStore)[i], delta);
		  assertEquals("max", 619.99, LoopsAndArraysB_s20.Gadget.gadgetStats(oneGadgetStore)[j], delta);
		  assertEquals("avg", 619.99, LoopsAndArraysB_s20.Gadget.gadgetStats(oneGadgetStore)[k], delta);
		  
		  assertEquals("min", 299.99, LoopsAndArraysB_s20.Gadget.gadgetStats(firstStore)[i], delta);
		  assertEquals("max", 699.99, LoopsAndArraysB_s20.Gadget.gadgetStats(firstStore)[j], delta);
		  assertEquals("avg", 457.99, LoopsAndArraysB_s20.Gadget.gadgetStats(firstStore)[k], delta);
		  
		  assertEquals("min", 249.99, LoopsAndArraysB_s20.Gadget.gadgetStats(secondStore)[i], delta);
		  assertEquals("max", 4399.99, LoopsAndArraysB_s20.Gadget.gadgetStats(secondStore)[j], delta);
		  assertEquals("avg", 1251.19, LoopsAndArraysB_s20.Gadget.gadgetStats(secondStore)[k], delta);
		
	}
	
	@Test
	public void intersectionOfLotsTest() {
    LoopsAndArraysB_s20.Gadget[] emptyLot = {};
	LoopsAndArraysB_s20.Gadget[] oneTrooperLot = { g4 } ; 
	LoopsAndArraysB_s20.Gadget[] firstLot = { g0, g2, g4, g6, g8};  
	LoopsAndArraysB_s20.Gadget[] secondLot = { g1, g3, g5, g9, g7}; 
	LoopsAndArraysB_s20.Gadget[] thirdLot = { g3, g5, g8}; 

	LoopsAndArraysB_s20.Gadget[] assert1Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(emptyLot, emptyLot);
	assertFalse("It should return a new array instance.", assert1Result==emptyLot);
	assertEquals("It should have returned an empty Lot array", 0 ,assert1Result.length);
	
	LoopsAndArraysB_s20.Gadget[] assert2Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(firstLot, emptyLot);
	LoopsAndArraysB_s20.Gadget[] expectedResult2 = new LoopsAndArraysB_s20.Gadget[emptyLot.length];
	assertFalse("It should return a new array instance.", assert2Result==firstLot);
	assertFalse("It should return a new array instance.", assert2Result==emptyLot);
	assertEquals("Array size is incorrect, may not contain null values", 0 ,assert2Result.length);
 	assertTrue("Items in array are those as expected", Arrays.equals(expectedResult2 ,assert2Result));	

	LoopsAndArraysB_s20.Gadget[] assert3Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(emptyLot, firstLot);
	LoopsAndArraysB_s20.Gadget[] expectedResult3 = new LoopsAndArraysB_s20.Gadget[emptyLot.length];
	assertFalse("It should return a new array instance.", assert3Result==emptyLot);
	assertFalse("It should return a new array instance.", assert3Result==firstLot);
	assertEquals("Array size is incorrect, may not contain null values", 0 ,assert3Result.length); 	
	assertTrue("Items in array are not those expected", Arrays.equals(expectedResult3 ,assert3Result));	
	
	LoopsAndArraysB_s20.Gadget[] asserg4Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(oneTrooperLot, firstLot);
	LoopsAndArraysB_s20.Gadget[] expectedResulg4 = {g4};
	assertFalse("It should return a new array instance.", asserg4Result==oneTrooperLot);
	assertFalse("It should return a new array instance.", asserg4Result==firstLot);
	assertEquals("Array size is incorrect, may contain null values", 1 ,asserg4Result.length); 	
	assertTrue("Items in array are not those expected", Arrays.equals(expectedResulg4 ,asserg4Result));
	
	LoopsAndArraysB_s20.Gadget[] assert5Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(firstLot, oneTrooperLot);
	LoopsAndArraysB_s20.Gadget[] expectedResult5 = { g4};
	assertFalse("It should return a new array instance.", assert5Result==firstLot);
	assertFalse("It should return a new array instance.", assert5Result==oneTrooperLot);
	assertEquals("Array size is incorrect, may not contain null values", 1 ,assert5Result.length); 	
	assertTrue("Items in array are not those expected", Arrays.equals(expectedResult5 ,assert5Result));	

	LoopsAndArraysB_s20.Gadget[] assert6Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(firstLot, firstLot);
	LoopsAndArraysB_s20.Gadget[] expectedResult6 = { g0, g2, g4, g6, g8};
	assertFalse("It should return a new array instance.", assert6Result==firstLot);
	assertFalse("It should return a new array instance.", assert6Result==firstLot);
	assertEquals("Array size is incorrect, may contain null values", 5 ,assert6Result.length); 	
	assertTrue("Items in array are not those expected", Arrays.equals(expectedResult6 ,assert6Result));	
	
	LoopsAndArraysB_s20.Gadget[] assert7Result = LoopsAndArraysB_s20.Gadget.intersectionOfLots(secondLot, thirdLot);
	LoopsAndArraysB_s20.Gadget[] expectedResult7 = { g3, g5};
	assertFalse("It should return a new array instance.", assert7Result==secondLot);
	assertFalse("It should return a new array instance.", assert7Result==thirdLot);
	assertEquals("Array size is incorrect, may contain null values", 2 ,assert7Result.length); 	
	assertTrue("Items in array are not those expected", Arrays.equals(expectedResult7,assert7Result));		
	}

}
