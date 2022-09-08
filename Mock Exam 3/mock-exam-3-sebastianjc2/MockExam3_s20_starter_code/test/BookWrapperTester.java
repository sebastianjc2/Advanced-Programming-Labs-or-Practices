import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookWrapperTester {
	BookWrapper.EBook[] eLibrary;
	BookWrapper.Paperback[] libros; 

    @Before
    public void setUp() {
    	
    	// 8 eBooks -- Disclaimer: Fictional Titles, Authors, etc.
    	eLibrary = new BookWrapper.EBook[8];
    	eLibrary[0] = (new BookWrapper.EBook("Aprenda Java", "B. Velez", BookWrapper.Genres.CONTEMPORARY, 2019,
    			35000L, 500L, BookWrapper.Format.KINDLE));
    	eLibrary[1] = (new BookWrapper.EBook("Aprenda Python", "A.Downey", BookWrapper.Genres.ACTION, 2018,
    			20000L, 300L, BookWrapper.Format.HTML));
    	eLibrary[2] = (new BookWrapper.EBook("Aprenda VB", "A. Valle", BookWrapper.Genres.FANTASY, 1985,
    			25000L, 400L, BookWrapper.Format.IBOOK));
    	eLibrary[3] = (new BookWrapper.EBook("Aprenda Scratch", "N.Rusk", BookWrapper.Genres.SCIENCEFICTION, 2018,
    			15000L, 200L, BookWrapper.Format.PDF));
    	eLibrary[4] = (new BookWrapper.EBook("Aprenda Fortran", "I.Civil", BookWrapper.Genres.LITERARY, 1999,
    			50000L, 500L, BookWrapper.Format.PDF));
    	eLibrary[5] = (new BookWrapper.EBook("Aprenda SmallTalk", "A.Goldberg", BookWrapper.Genres.THRILLER, 1975,
    			22000L, 400L, BookWrapper.Format.KINDLE));
    	eLibrary[6] = (new BookWrapper.EBook("Aprenda Scheme", "R.Kent", BookWrapper.Genres.LITERARY, 1990,
    			20000L, 450L, BookWrapper.Format.IBOOK));
    	eLibrary[7] = (new BookWrapper.EBook("Aprenda Lisp", "P.Norvig", BookWrapper.Genres.LITERARY, 1995,
    			30000L, 400L, BookWrapper.Format.KINDLE));
    	
    	// 8 Paperbacks -- Disclaimer: Fictional Titles, Authors, etc.
    	libros = new BookWrapper.Paperback[8];
    	libros[0] = new BookWrapper.Paperback("Aprenda Java", "B. Velez", BookWrapper.Genres.CONTEMPORARY, 2019, 400);
    	libros[1] = new BookWrapper.Paperback("Aprenda Python", "A.Downey", BookWrapper.Genres.ACTION, 2018, 550);
    	libros[2] = new BookWrapper.Paperback("Aprenda VB", "A. Valle", BookWrapper.Genres.FANTASY, 1985, 600);
    	libros[3] = new BookWrapper.Paperback("Aprenda Scratch", "N.Rusk", BookWrapper.Genres.SCIENCEFICTION, 2018, 750);
    	libros[4] = new BookWrapper.Paperback("Aprenda Fortran", "I.Civil", BookWrapper.Genres.LITERARY, 1999, 375);
    	libros[5] = new BookWrapper.Paperback("Aprenda SmallTalk", "A.Goldberg", BookWrapper.Genres.THRILLER, 1975, 250);
    	libros[6] = new BookWrapper.Paperback("Aprenda Scheme", "R.Kent", BookWrapper.Genres.DRAMA, 1990, 300);
    	libros[7] = new BookWrapper.Paperback("Aprenda Lisp", "P.Norvig", BookWrapper.Genres.LITERARY, 1995, 650);
    	
    }
    
    
    
    
	// Test for EX #1
	@Test
	public void testAbstractBookClass() {
		BookWrapper.Paperback pb1 = new BookWrapper.Paperback(null, null, null, 0, 0);
		BookWrapper.EBook eb1 = new BookWrapper.EBook(null, null, null, 0, 0, 0, null);
		assertTrue("Paperback should be instance of abstract class Book", pb1 instanceof BookWrapper.Book );
		assertTrue("eBook should be instance of abstract class Book", eb1 instanceof BookWrapper.Book);
		
    	boolean has4Fields = false;    	
    	try {
    		Class<?> c = Class.forName("BookWrapper");
    		Class<?> cl[] = c.getDeclaredClasses();
    		for(Class<?> cls : cl) {
    			if(cls.toString().contains("BookWrapper$Book")) {
    				Field[] fields = cls.getDeclaredFields();
    				if(fields.length == 4)
    					has4Fields = true;
    				break;
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
    	assertTrue("The abstract Book class should have 4 fields", has4Fields);

	}
	
	
	

    // Test for EX #2 (Parts A & B)
	@Test
	public void testRefactoring() {
		// Check fields were moved to abstract class
		boolean fieldsMoved = true;
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("BookWrapper$Paperback") ||
						cls.toString().contains("BookWrapper$eBook")) {
					Field[] fields = cls.getDeclaredFields();
					for(Field f: fields) {
						if(f.toString().contains("title") || f.toString().contains("authors") 
								|| f.toString().contains("genre") || f.toString().contains("year")) {
							fieldsMoved = false;
							break;
						}
					}
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The original clases still contain methods that should be in the abstract class", fieldsMoved);

		// testNumberOfFieldsCorrectForPaperback
    	boolean has1Field = false;    	
    	try {
    		Class<?> c = Class.forName("BookWrapper");
    		Class<?> cl[] = c.getDeclaredClasses();
    		for(Class<?> cls : cl) {
    			if(cls.toString().contains("BookWrapper$Paperback")) {
    				Field[] fields = cls.getDeclaredFields();
    				if(fields.length == 1)
    					has1Field = true;
    				break;
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
    	assertTrue("The Paperback class should have 1 field", has1Field);

    	// testNumberOfFieldsCorrectForEBook
    	boolean has3Fields = false;    	
    	try {
    		Class<?> c = Class.forName("BookWrapper");
    		Class<?> cl[] = c.getDeclaredClasses();
    		for(Class<?> cls : cl) {
    			if(cls.toString().contains("BookWrapper$EBook")) {
    				Field[] fields = cls.getDeclaredFields();
    				if(fields.length == 3)
    					has3Fields = true;
    				break;
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
    	assertTrue("The eBook class should have 3 fields", has3Fields);
    }
    
	
	
	
	// Test for EX #3
	@Test 
	public void testHasSellableInterace() {
		boolean hasMethods = false;
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("Sellable")) {
					Method[] methods = cls.getDeclaredMethods();
					assertEquals("Sellable should only contain one method", 1, methods.length);
					for(Method method: methods) {
						if(method.toString().contains("getPrice()")) {
							hasMethods = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("This interface Sellable should contain the method getPrice", hasMethods);
	}
	
	
	
	
    // Test for EX #4
	@Test 
	public void testGetPriceBookMethod() {
		// test Paperback Implements Abstract getPrice Method
		boolean hasMethod = false;    	
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("BookWrapper$Paperback")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("getPrice()"))
							hasMethod = true;
					}
					break;
				}
			}
		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class Paperback is missing implementation getPrice()",hasMethod);
		
		double delta = 0.0001;
		
		assertEquals("incorrect price, Paperback class", 92.0, libros[0].getPrice(), delta);
		assertNotEquals("incorrect price, Paperback class", 0, libros[0].getPrice(), delta);
		assertEquals("incorrect price, Paperback class", 172.5, libros[3].getPrice(), delta);
		assertEquals("incorrect price, Paperback class", 149.5, libros[7].getPrice(), delta);
	}

	
	
	
    // Test for EX #5
	@Test 
	public void testNewAbstractMethod() {
		//test Book Has Abstract Method PageCount
		boolean hasAbstractMethod = false;    	
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("BookWrapper$Book")) {
					Method method = cls.getMethod("pageCount");
					if(method.toString().contains("pageCount()"))
						hasAbstractMethod = true;
					break;
				}
			}

		} catch (Exception e) {
			// NOTE: java.lang.NoSuchMethodException: BookWrapper$Book.pageCount()
			fail(e.toString());
		}
		assertTrue("The class Book is missing a abstract method pageCount()",hasAbstractMethod);

		// test EBook Implements Abstract pageCount Method
		boolean hasMethod = false;    	
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("BookWrapper$EBook")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("pageCount()"))
							hasMethod = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class eBook is missing implementation pageCount()",hasMethod);
		
		double delta = 0.0001;
		
		assertEquals("incorrect page count, eBook class", 70.0, eLibrary[0].pageCount(), delta);
		assertNotEquals("incorrect page count, eBook class", 0, eLibrary[0].pageCount(), delta);
		assertEquals("incorrect page count, eBook class", 75.0, eLibrary[3].pageCount(), delta);
		assertEquals("incorrect page count, eBook class", 75.0, eLibrary[7].pageCount(), delta);

	}	
    
	
	
	
    // Test for EX #6
    @Test
    public void testImplementComparable(){
    	
		// test eBook Implements Comparable Method
		Boolean hasMethod = false;    	
		try {
			Class<?> c = Class.forName("BookWrapper");
			Class<?> cl[] = c.getDeclaredClasses();
			for(Class<?> cls : cl) {
				if(cls.toString().contains("BookWrapper$EBook")) {
					Method[] methods = cls.getDeclaredMethods();
					for(Method m : methods) {
						if(m.toString().contains("compareTo"))
							hasMethod = true;
					}
					break;
				}
			}

		} catch (Exception e) {
			fail(e.toString());
		}
		assertTrue("The class EBook is missing compareTo method",hasMethod);       	
    	
		// tests comparisons
    	assertTrue("target is larger than other, should be >0", eLibrary[0].compareTo(eLibrary[2])>0);
    	assertTrue("target is smaller than other, should be <0", eLibrary[2].compareTo(eLibrary[0])<0);
    	assertNotEquals("page counts are NOT the same, should not be 0", 0, eLibrary[1].compareTo(eLibrary[7]));
    	assertEquals("page counts are the same, should be 0", 0, eLibrary[1].compareTo(eLibrary[6]));
    }

    
    
    
    
	@Rule
	public final ExpectedException exception = ExpectedException.none();
    
	// Test for EX #7    
    @Test
    public void testFindNewestYearMethodPaperBack(){
    	assertEquals("newest book year is incorrect", 2019, BookWrapper.Paperback.findNewestYear(libros));
    	
    	libros[0].setYear(2009);
    	assertEquals("newest book year is incorrect", 2018, BookWrapper.Paperback.findNewestYear(libros)); 
    	
    	libros[1].setYear(2007);
    	assertEquals("newest book year is incorrect", 2018, BookWrapper.Paperback.findNewestYear(libros));
    	
		// Add 100,000 eBooks to libros2 to cause stack overflow
    	BookWrapper.Paperback[] libros2 = new BookWrapper.Paperback[100000];
		for (int i = 0; i < 100000; i++) {
			libros2[i] = (new BookWrapper.Paperback("Otro Mas", "Editor", BookWrapper.Genres.LITERARY, 1999, 100));
		}
	    exception.expect(StackOverflowError.class);
		assertEquals("StackOverflowError was expected", 1975, 
				BookWrapper.Paperback.findNewestYear(libros2));
	}
    
    
    
	
	// Test for EX #8
	@Test
	public void testExistsFormatMethodEBook(){
		assertTrue("PDF format exists",BookWrapper.EBook.existsFormat(eLibrary, BookWrapper.Format.PDF));
		assertTrue("Kindle format exists",BookWrapper.EBook.existsFormat(eLibrary, BookWrapper.Format.KINDLE));
		assertTrue("iBook format exists",BookWrapper.EBook.existsFormat(eLibrary, BookWrapper.Format.IBOOK));
		assertFalse("ePub format does not exist",BookWrapper.EBook.existsFormat(eLibrary, BookWrapper.Format.EPUB));
		assertFalse("Audio format does not exist",BookWrapper.EBook.existsFormat(eLibrary, BookWrapper.Format.AUDIO));
		
		// Add 500,000 to new library to cause stack overflow
		BookWrapper.EBook[] muchoslibros = new BookWrapper.EBook[500000];
		for (int i = 0; i < muchoslibros.length; i++) {
			muchoslibros[i] = new BookWrapper.EBook("Another Book", "Editor", BookWrapper.Genres.LITERARY, 1995,
					35000L, 500L, BookWrapper.Format.KINDLE);
		}
	    exception.expect(StackOverflowError.class);
		assertTrue("StackOverflowError was expected",
				BookWrapper.EBook.existsFormat(muchoslibros, BookWrapper.Format.PDF));		
	}

}
