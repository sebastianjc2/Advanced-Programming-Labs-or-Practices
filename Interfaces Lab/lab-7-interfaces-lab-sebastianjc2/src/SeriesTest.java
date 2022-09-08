import static org.junit.Assert.*;

import org.junit.Test;


public class SeriesTest {
	MediaWrapper.Actor actor1 = new MediaWrapper.Actor("Scarlett Johanson", 35000000, 4);
	MediaWrapper.Actor actor2 = new MediaWrapper.Actor("The Rock", 10000000, 3);
	MediaWrapper.Actor actor3 = new MediaWrapper.Actor("Adam Sandler", 1000000, 2);
	MediaWrapper.Actor actor4 = new MediaWrapper.Actor("Kevin James", 100000, 1);
	MediaWrapper.Actor actor5 = new MediaWrapper.Actor("Jules Knight", 45000000, 5);
	MediaWrapper.Actor actor6 = new MediaWrapper.Actor("SVictoria Eyenoke", 1000000, 2);
	MediaWrapper.Actor actor7 = new MediaWrapper.Actor("Zack Efron", 15000000, 3);
	MediaWrapper.Actor actor8 = new MediaWrapper.Actor("Scarlett Johanson", 3000000, 2);
	MediaWrapper.Actor actor9 = new MediaWrapper.Actor("Hayden Christensen", 5000000, 3);
	MediaWrapper.Actor actor10 = new MediaWrapper.Actor("Christina Wolf", 300000, 1);
	
	MediaWrapper.Actor[] cast1 = {actor1, actor3, actor5, actor7};
	MediaWrapper.Actor[] cast2 = {actor2, actor4, actor6, actor8};
	MediaWrapper.Actor[] cast3 = {actor9, actor10, actor5, actor6};
	MediaWrapper.Actor[] cast4 = {actor1, actor2, actor7, actor8};
	
	MediaWrapper.Series series1 = new MediaWrapper.Series("The Royals", cast1, 152000000, 3);
	MediaWrapper.Series series2 = new MediaWrapper.Series("The 100", cast2, 521000, 2);
	MediaWrapper.Series series3 = new MediaWrapper.Series("Your Funeral", cast3, 62000, 6);
	MediaWrapper.Series series4 = new MediaWrapper.Series("That's a No", cast4, 105000000, 7);

	@Test
	public void implementsInterfaceTest() {
		assertTrue("Series does not implement Filmable interface", series1 instanceof MediaWrapper.Filmable);
		assertTrue("Series does not implement Filmable interface", series2 instanceof MediaWrapper.Filmable);
	}
	
	@Test
	public void getFilmBudgetTest() {
		assertEquals("getFilmBudget() is not working properly", 440000000, series1.getFilmBudget());
		assertEquals("getFilmBudget() is not working properly", 28721000, series2.getFilmBudget());
		assertEquals("getFilmBudget() is not working properly", 307862000, series3.getFilmBudget());
		assertEquals("getFilmBudget() is not working properly", 546000000, series4.getFilmBudget());
		
	}
	
	@Test
	public void isClassicTest() {
		assertFalse("isClassic() is not working properly", series1.isClassic());
		assertFalse("isClassic() is not working properly", series2.isClassic());
		assertTrue("isClassic() is not working properly", series3.isClassic());
		assertTrue("isClassic() is not working properly", series4.isClassic());
	}
	
	@Test
	public void isSuccesful() {
		assertTrue("isSuccessful() is not working properly", series1.isSuccessful());
		assertFalse("isSuccessful() is not working properly", series2.isSuccessful());
		assertTrue("isSuccessful() is not working properly", series3.isSuccessful());
		assertTrue("isSuccessful() is not working properly", series4.isSuccessful());
	}

}
