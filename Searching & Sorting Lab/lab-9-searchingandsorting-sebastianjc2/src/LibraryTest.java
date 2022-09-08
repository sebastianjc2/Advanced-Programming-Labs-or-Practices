import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LibraryTest {

	Library.Book[] emptyShelve = {};
	
	Library.Book[] sortedShelve1 = {
			new Library.Book(0, "Somebody once told me", "Shrek", 2001, 1000),
			new Library.Book(1, "the world is gonna roll me", "Donkey", 2001, 1000),
			new Library.Book(2, "I ain't the sharpest tool in the shed", "Fiona", 2001, 1000),
			new Library.Book(3, "She was looking kind of dumb", "Puss in boots", 2001, 1000),
			new Library.Book(4, "with her finger and her thumb", "Dragon", 2001, 1000),
			new Library.Book(5, "In the shape of an \"L\" on her forehead", "Gingerbread man", 2001, 1000),
			new Library.Book(6, "Well, the years start coming and they don't stop coming", "Pinocchio", 2001, 1000),
			new Library.Book(7, "Fed to the rules and I hit the ground running", "Doris", 2001, 1000),
			new Library.Book(8, "Didn't make sense not to live for fun", "Lord Farquaad", 2001, 1000),
			new Library.Book(9, "Your brain gets smart but your head gets dumb", "Fairy Godmother", 2001, 1000),
			new Library.Book(10, "So much to do, so much to see", "Princess Charming", 2001, 1000),
			new Library.Book(11, "So what's wrong with taking the back streets?", "Captain Hook", 2001, 1000),
			new Library.Book(12, "You'll never know if you don't go", "OG Fiona", 2001, 1000),
			new Library.Book(13, "You'll never shine if you don't glow", "Handsome Shrek", 2001, 1000),
			new Library.Book(14, "Hey, now, you're an all-star, get your game on, go play", "Three Blind Mice", 2001, 1000),
			new Library.Book(15, "Hey, now, you're a rock star, get the show on, get paid", "Magic Mirror", 2001, 1000),
			new Library.Book(17, "And all that glitters is gold", "Cookie", 2001, 1000),
			new Library.Book(18, "Only shooting stars break the mold", "Sadly no Bee Movie reference", 2001, 1000)
	};
	
	Library.Book[] unsortedShelve1 = {
			new Library.Book(0, "Somebody once told me", "Shrek", 2001, 1000),
			new Library.Book(14, "Hey, now, you're an all-star, get your game on, go play", "Sadly no Bee Movie reference", 2001, 1000),
			new Library.Book(1, "the world is gonna roll me", "Donkey", 2001, 1000),
			new Library.Book(3, "She was looking kind of dumb", "Puss in boots", 2001, 1000),
			new Library.Book(4, "with her finger and her thumb", "Dragon", 2001, 1000),
			new Library.Book(10, "So much to do, so much to see", "Princess Charming", 2001, 1000),
			new Library.Book(6, "Well, the years start coming and they don't stop coming", "Pinocchio", 2001, 1000),
			new Library.Book(7, "Fed to the rules and I hit the ground running", "Doris", 2001, 1000),
			new Library.Book(17, "And all that glitters is gold", "Cookie", 2001, 1000),
			new Library.Book(8, "Didn't make sense not to live for fun", "Lord Farquaad", 2001, 1000),
			new Library.Book(9, "Your brain gets smart but your head gets dumb", "Fairy Godmother", 2001, 1000),
			new Library.Book(11, "So what's wrong with taking the back streets?", "Captain Hook", 2001, 1000),
			new Library.Book(2, "I ain't the sharpest tool in the shed", "Fiona", 2001, 1000),
			new Library.Book(12, "You'll never know if you don't go", "OG Fiona", 2001, 1000),
			new Library.Book(13, "You'll never shine if you don't glow", "Handsome Shrek", 2001, 1000),
			new Library.Book(15, "Hey, now, you're a rock star, get the show on, get paid", "Magic Mirror", 2001, 1000),
			new Library.Book(18, "Only shooting stars break the mold", "Three Blind Mice", 2001, 1000),
			new Library.Book(5, "In the shape of an \"L\" on her forehead", "Gingerbread man", 2001, 1000)
	};
	
	@Test
    public void testBinarySearch() {
        assertEquals(-1, Library.binarySearch(emptyShelve, new Library.Book(0, "Somebody once told me", "Shrek", 2001, 1000)));
        assertEquals(-1, Library.binarySearch(unsortedShelve1, new Library.Book(19, "You thought it would be a test case but it was me", "Dio", 2001, 1000)));
        assertEquals(-1, Library.binarySearch(unsortedShelve1, new Library.Book(20, "Ora ora ora ora", "Some guy", 2001, 1000)));
        long st = System.nanoTime();
        assertEquals(16, Library.binarySearch(sortedShelve1, new Library.Book(17, "And all that glitters is gold", "Cookie", 2001, 1000)));
        long et = System.nanoTime();
        //System.out.println("Binary Search Time (Found): " + (et-st) + " nanoseconds.");
        st = System.nanoTime();
        assertEquals(-1, Library.binarySearch(sortedShelve1, new Library.Book(900, "You thought it would be a test case but it was me", "Dio", 2001, 1000)));
        et = System.nanoTime();
        //System.out.println("Binary Search Time (Not Found): " + (et-st) + " nanoseconds.");
    }   
	
    @Test 
    public void testBubbleSort() {
        Library.Book[] toBeSortedShelve1 = Library.copyOf(unsortedShelve1);
        long st = System.nanoTime();
        toBeSortedShelve1 = Library.bubbleSort(toBeSortedShelve1);  // Returns the sorted array
        long et = System.nanoTime();
        //System.out.println("Bubble Sort Time: " + (et-st) + " nanoseconds.");
        assertEquals("These should be the same size", unsortedShelve1.length, toBeSortedShelve1.length);
        for(int i = 1; i < toBeSortedShelve1.length; i++) { 
            assertTrue("These should be in ascending order.", 
                    toBeSortedShelve1[i-1].compareTo(toBeSortedShelve1[i]) < 0);
        }
    }
    
    @Test 
    public void testInsertionSort() {
    	Library.Book[] toBeSortedShelve1 = Library.copyOf(unsortedShelve1);
        long st = System.nanoTime();
        toBeSortedShelve1 = Library.insertionSort(toBeSortedShelve1);  // Returns the sorted array
        long et = System.nanoTime();
        //System.out.println("Insertion Sort Time: " + (et-st) + " nanoseconds.");
        assertEquals("These should be the same size", unsortedShelve1.length, toBeSortedShelve1.length);
        for(int i = 1; i < toBeSortedShelve1.length; i++) { 
            assertTrue("These should be in ascending order.", toBeSortedShelve1[i-1].compareTo(toBeSortedShelve1[i]) < 0);
        }
    }
    
    @Test 
    public void testSelectionSort() {
	Library.Book[] toBeSortedShelve1 = Library.copyOf(unsortedShelve1);
        long st = System.nanoTime();
        toBeSortedShelve1 = Library.selectionSort(toBeSortedShelve1);  // Returns the sorted array
        long et = System.nanoTime();
        //System.out.println("Insertion Sort Time: " + (et-st) + " nanoseconds.");
        assertEquals("These should be the same size", unsortedShelve1.length, toBeSortedShelve1.length);
        for(int i = 1; i < toBeSortedShelve1.length; i++) { 
            assertTrue("These should be in ascending order.", toBeSortedShelve1[i-1].compareTo(toBeSortedShelve1[i]) < 0);
        }
    }

}