// Remember to add your name & repo name below
// Name: LastNames, First Name
// GitHub Classroom Repository: 

/**
 * Wrapper class used to enclose all classes as static nested classes.
 * These classes would normally be top-level classes, but are enclosed
 * for compatibility with the Moodle JUnit plugin.
 */

public class BookWrapper {
	
	enum Genres { ROMANCE, FANTASY, SCIENCEFICTION, LITERARY, MYSTERY, THRILLER, ACTION, CONTEMPORARY, DRAMA }
	enum Format { PDF, KINDLE, IBOOK, HTML, EPUB, AUDIO}

	/** EXERCISE #1 -- ADD AN ABSTRACT BOOK CLASS
	 * 
	 * Re-factor Paperback and eBook classes.
	 * An abstract class that holds the properties and implements the methods that are
	 * common to paperBook and eBook classes. All the moved properties must remain 
	 * PRIVATE and the methods PUBLIC.
	 * 
	 * Any method that is different in the subclasses should be added
	 * as an abstract method in this abstract class and then overridden
	 * by each subclass. 
	 * 
	 * The abstract class should supply an appropriate constructor to be used by 
	 * subclass constructors to initialize the private properties in the abstract class.
	 */
    public static abstract class Book {
    	// TODO #1 -- Add abstract class here       
    } // End of abstract class Book

    
    /**
     * Exercise #2 (Part A)
	 * Re-factor this class to remove any property or method that
	 * were moved to the Abstract Book class.  You should modify the
	 * constructor to call the super constructor appropriately.
	 * 
     * This represents a Paperback book.
     */
    public static class Paperback extends Book implements Sellable {
    	// TODO #2A -- Refactor Paperback class
    	private String title;
    	private String authors;
    	private Genres genre;
    	private int year;
    	private int pages;

        public String getTitle() {return title;}
		public String getAuthors() {return authors;}
		public Genres getGenre() {return genre;}
		public int getYear() {return year;}
    	public int getPages() { return pages; }
		
		public void setTitle(String title) {this.title = title;}
		public void setAuthors(String authors) {this.authors = authors;}
		public void setGenre(Genres genre) {this.genre = genre;	}
		public void setYear(int year) {	this.year = year;}
		public void setPages(int pages) { this.pages = pages; }
		
		public Paperback(String title, String authors, Genres genre, int year, int pages) {
			setTitle(title);
			setAuthors(authors);
			setGenre(genre);
			setYear(year);
			setPages(pages);
		}

		/**
		 * Page count for paperbacks returns the number of 
		 * paper sheets,two pages per sheet.
		 */
		public int pageCount() {
			return getPages()/2; 
		}

	   
	    /** EXERCISE #4 -- IMPLEMENT THE NEW INTERFACE CREATED IN #3
	     * 	Printed versions of paperbacks are sold for $0.23 per page
	     */
	    public double getPrice() {
	    	// TODO EX#4 - Implement new Interface
	    	return 0.00; // Dummy return
	    }    

        
        /** EXERCISE #7 IMPLEMENT RECURSIVE MAX METHOD -- PAPERBACK
         * 
         *  This method finds the newest book (highest year) in an array of
         *  paperbacks. You may assume that no book has a year less than 0. 
         * 
         *  The method MUST BE RECURSIVE
         */
        public static int findNewestYear(Paperback[] myBooks) {
            return findNewestYear(myBooks, 0, myBooks.length-1);		
        }
        // Implement the following helper method
        public static int findNewestYear(Paperback[] myBooks, int start, int end) {
            //TODO EX#7 - Implement Recursive Max Method
            return 0;	// Dummy return
        }
               	
    } // End of Paperback Class
    

    /**
     * Exercise #2 (Part B)
	 * Re-factor this class to remove any property or method that was 
	 * moved to the Abstract Book class.  You should modify the
	 * constructor to call the super constructor appropriately.
	 * 
     * This class represents an eBook (electronic book)
     * 
     */
    public static class EBook extends Book implements Comparable<EBook> { 
    	// TODO #2B - Refactor EBook class
    	private String title;
    	private String authors;
    	private Genres genre;
    	private int year;
		private long wordCount;
    	private long wordsPerPage;
    	private Format format;

        public String getTitle() {return title;}
		public String getAuthors() {return authors;}
		public Genres getGenre() {return genre;}
		public int getYear() {return year;}
		public long getWordCount() {return wordCount;}
		public long getWordsPerPage() {return wordsPerPage;}
        public Format getFormat() {return format;}
		
		public void setTitle(String title) {this.title = title;}
		public void setAuthors(String authors) {this.authors = authors;}
		public void setGenre(Genres genre) {this.genre = genre;	}
		public void setYear(int year) {	this.year = year;}
		public void setWordCount(Long wordCount) {this.wordCount = wordCount;}
		public void setWordsPerPage(Long wordsPerPage) {this.wordsPerPage = wordsPerPage;}   	
		public void setFormat(Format format) {this.format = format;}
		
		public EBook(String title, String authors, Genres genre, int year,
				     long wordCount, long wordsPerPage, Format format) {
			setTitle(title);
			setAuthors(authors);
			setGenre(genre);
			setYear(year);
			setWordCount(wordCount);
			setWordsPerPage(wordsPerPage);
			setFormat(format);
		}

	    /** Exercise #5 -- IMPLEMENT ABSTRACT METHOD THAT YOU REFACTORED
	     *  Page count for eBooks returns the number of pages,
	     *  the number that results from the division of the
	     *  eBook word count by the number of words per page.
	     *  10,000 word eBook with 500 words/page yields 20 pages.
	     */	
	    public int pageCount() {
			// TODO EX# 5 - Implement Abstract Method
	        return 0; //Dummy return
	    }
            
	    /** EXERCISE #6 IMPLEMENT COMPARABLE INTERFACE METHOD -- EBOOK
	     * 
	     * Compares eBooks books based on size (words) in ascending order;
	     * returns a negative integer, zero, or a positive integer if words for
	     * target is less than, equal to, or greater than the parameter eBook.
	     */
	    public int compareTo(EBook otherBook) {
	        // TODO EX#6 - Implement Comparable Interface
	        return (int) 0L; // Dummy return
	    }	    

		
	    /** EXERCISE #8 IMPLEMENT RECURSIVE SEARCH METHOD -- EBOOK
	     * 
	     *  RECURSIVELY returns true if and only if a specified format (enum) appears 
	     *  in the array of eBooks starting at position start, up to position end-1. 
	     *  
	     *  The method MUST BE RECURSIVE
	     */
	    public static boolean existsFormat(EBook[] myEBooks, Format f) {
	        return existsFormat(myEBooks, f, 0, myEBooks.length-1);
	    }
	    // Complete the following helper method
	    public static boolean existsFormat(EBook[] e, Format f, int start, int end) {
	        // TODO EX#8 - Implement recursive search method
	        return false; // Dummy return
	    }	    
	    
    } // End of eBook Class

    
    /** EXERCISE #3 -- DEFINE A NEW INTERFACE 
     *  An interface that represents a sellable item.
     */
    public static interface Sellable {
		/**
		 *  Method that returns the price
		 *  in dollars of a sellable item.
		 *  Hint: See tests
		 */
    	// TODO EX#3 - Define new Interface below
    }
    
}
