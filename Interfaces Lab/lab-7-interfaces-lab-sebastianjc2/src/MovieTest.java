import static org.junit.Assert.*;

import org.junit.Test;


public class MovieTest {
    MediaWrapper.Actor actor1 = new MediaWrapper.Actor("Brad Pitt", 80000000, 2);
    MediaWrapper.Actor actor2 = new MediaWrapper.Actor("Jason Bateman", 30000000, 3);
    MediaWrapper.Actor actor3 = new MediaWrapper.Actor("Jason Statham", 3000000, 2);
    MediaWrapper.Actor actor4 = new MediaWrapper.Actor("Andrew Garfield", 40000, 4);
    MediaWrapper.Actor actor5 = new MediaWrapper.Actor("Viola Davis", 450000, 5);
    MediaWrapper.Actor actor6 = new MediaWrapper.Actor("Benedict Cumberbatch", 10000, 2);
    MediaWrapper.Actor actor7 = new MediaWrapper.Actor("Mark Sinclair", 150000, 1);
    MediaWrapper.Actor actor8 = new MediaWrapper.Actor("Scarlett Johanson", 31200000, 2);
    MediaWrapper.Actor actor9 = new MediaWrapper.Actor("Hayden Christensen", 53000000, 3);
    MediaWrapper.Actor actor10 = new MediaWrapper.Actor("Christina Wolf", 3200000, 5);

    MediaWrapper.Actor[] cast1 = {actor1, actor3, actor5, actor7};
    MediaWrapper.Actor[] cast2 = {actor2, actor4, actor6, actor8};
    MediaWrapper.Actor[] cast3 = {actor9, actor10, actor5, actor6};
    MediaWrapper.Actor[] cast4 = {actor1, actor2, actor7, actor8};

    MediaWrapper.Movie movie1 = new MediaWrapper.Movie("{Insert Generic Movie Name Here}", cast1, 124000000, 3, 5);
    MediaWrapper.Movie movie2 = new MediaWrapper.Movie("Java Reloaded", cast2, 365000, 2, 3);
    MediaWrapper.Movie movie3 = new MediaWrapper.Movie("Rise of the Shapes", cast3, 34000, 12,5);
    MediaWrapper.Movie movie4 = new MediaWrapper.Movie("Interfaces", cast4, 123000000, 18,1);

    @Test
    public void implementsInterfaceTest() {
        assertTrue("Movie does not implement Filmable interface", movie1 instanceof MediaWrapper.Filmable);
        assertTrue("Movie does not implement Filmable interface", movie2 instanceof MediaWrapper.Filmable);
    }

    @Test
    public void getFilmBudgetTest() {
        assertEquals("getFilmBudget() is not working properly", 207600000, movie1.getFilmBudget());
        assertEquals("getFilmBudget() is not working properly", 61615000, movie2.getFilmBudget());
        assertEquals("getFilmBudget() is not working properly", 56694000, movie3.getFilmBudget());
        assertEquals("getFilmBudget() is not working properly", 264350000, movie4.getFilmBudget());

    }

    @Test
    public void isClassicTest() {
        assertFalse("isClassic() is not working properly", movie1.isClassic());
        assertFalse("isClassic() is not working properly", movie2.isClassic());
        assertTrue("isClassic() is not working properly", movie3.isClassic());
        assertTrue("isClassic() is not working properly", movie4.isClassic());
    }

    @Test
    public void isSuccesful() {
        assertTrue("isSuccessful() is not working properly", movie1.isSuccessful());
        assertFalse("isSuccessful() is not working properly", movie2.isSuccessful());
        assertTrue("isSuccessful() is not working properly", movie3.isSuccessful());
        assertFalse("isSuccessful() is not working properly", movie4.isSuccessful());
    }

}
