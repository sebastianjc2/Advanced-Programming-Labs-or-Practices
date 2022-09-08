/**
 * REQUIRED INFO
 * 
 *  Full Name: Sebastian J. Caballero
 * 	GitHub Repo Link: https://github.com/uprm-ciic4010-s20/lab-9-searchingandsorting-sebastianjc2
 */
public class Library {
	
	private Book[] bookshelf;
	
	public Library(Book[] bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	public Book[] getBookshelf() {
		return bookshelf;
	}
	
	/**
	 * Linear Algorithm to find the index of a given target.
	 * 
	 * @param bookshelf - Array where search takes place
	 * @param target - Book to be search for
	 * @return Index of the target book (-1 if not found)
	 */
	public static int iterativeLinearSearch(Book[] bookshelf, Book target) {
		for(int i = 0; i<bookshelf.length; i++) {
			if(bookshelf[i].equals(target)) return i;  // Book was found
		}
		return -1;  // Book was not found
	}
	
	/**
	 * Linear Algorithm to find the index of a given target. <br>
	 * Iterates through the whole array having a complexity of O(n) in the worst case scenario.
	 * 
	 * @param bookshelf - Target array
	 * @param target - Target object
	 * @return - Index of the target book (-1 if not found)
	 */
	public static int recursiveLinearSearch(Book[] bookshelf, Book target) {
		return linearHelper(bookshelf, 0, target);  // Start at the beginning of the array, index 0.
	}

	/**
	 * Linear search helper
	 * 
	 * @param bookshelf - Array where search takes place
	 * @param index - Index of current object we are comparing the target with 
	 * @param target - Book to be search for
	 * @return Index of what was found (-1 if not found)
	 */
	private static int linearHelper(Book[] bookshelf, int index, Book target) {
		if(index >= bookshelf.length) return -1;  // The book was never found, exit recursion.
		if(target.equals(bookshelf[index])) return index;  // Book was found
		return linearHelper(bookshelf, index+1, target);  // Increase index to "iterate" the array.
	}
	
	/**
	 * Exercise A:																							  <br>
	 * 																										  <br>
	 * Binary Algorithm to find the index of a given target. Requires array to be sorted. 					  <br>
	 * Divides the array in half and only checks for the half containing the value while discarding the rest. <br>
	 * The value is either the middle of the sub-array or in one of the two halves. 						  <br>
	 * 
	 * By dividing the array in half in each iteration, the complexity is at most O(log(n)) 				  <br>
	 * which beats the linear search at O(n).
	 * 
	 * @param bookshelf - Target List
	 * @param target - Target Element
	 * @return - Index of Target Element (-1 if not found)
	 */
	public static int binarySearch(Book[] bookshelf, Book target) {
		return binarySearchHelper(bookshelf, target, 0, bookshelf.length-1);  // Temp return
	}
	
	/**
	 * Helper method for Binary Search
	 * 
	 * @param bookshelf
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	private static int binarySearchHelper(Book[] bookshelf, Book target, int left, int right) {
		int half = (left + right)/2;
		if(bookshelf.length==0) return -1;
		if(left>right) {
			return -1;
		}
		
		if(bookshelf[half].compareTo(target)==0) {
			return half;
		}
		else if (bookshelf[half].compareTo(target)>0) {
			return binarySearchHelper(bookshelf, target, left, half-1);
		}
		else if(bookshelf[half].compareTo(target)<0) {
			return binarySearchHelper(bookshelf, target, half+1, right);
		}
		return -1;
	}
	
	/**
	 * Exercise B: <br>
	 * 
	 * Implement a iterative Bubble Sort for an array of books.
	 * 
	 * @param bookshelf - Array to be sorted. 
	 * @return A sorted copy of the bookshelf array.
	 */
	public static Book[] bubbleSort(Book[] bookshelf) {
		Book[] unsortedBookshelf = Library.copyOf(bookshelf);
		int l = unsortedBookshelf.length;
		for (int i = 0; i < unsortedBookshelf.length-1; i++) {
			for (int j = 0; j < unsortedBookshelf.length- i - 1; j++) {
				if(unsortedBookshelf[j].compareTo(unsortedBookshelf[j+1])>0) {
					swap(unsortedBookshelf, j, j+1);
				}
			}
			
		}
		return unsortedBookshelf;
	}
	
	/**
	 * Exercise C: <br>
	 * 
	 * Implement a recursive Insertion Sort for an array of books using a helper method. <br>
	 * 
	 * @param bookshelf - Array to be sorted
	 * @return A sorted copy of the bookshelf array.
	 */
	public static Book[] insertionSort(Book[] bookshelf) {
		Book[] unsortedBookshelf = Library.copyOf(bookshelf);
		return insertionSortHelper(unsortedBookshelf, unsortedBookshelf.length);
	}
	
	public static Book[] insertionSortHelper(Book[] bookshelf, int n) {
		if(n<=1) {
			return bookshelf;
		}
		insertionSortHelper(bookshelf, n-1);
		
		Book lastElement = bookshelf[n-1];
		int next = n-2;
		
		while(next>=0 && bookshelf[next].compareTo(lastElement)>0) {
			swap(bookshelf, next+1, next);
			next--;
		}
		bookshelf[next+1] = lastElement;
		return bookshelf;
	}
	/**
	 * Recursive Selection Sort for an array
	 * 
	 * @param bookshelf - Array to be sorted
	 * @return A sorted copy of the bookshelf array.
	 */
	public static Book[] selectionSort(Book[] bookshelf) {
		Book[] unsortedBookshelf = Library.copyOf(bookshelf);
		return selectionSortHelper(unsortedBookshelf, 0);
	}
	
	private static Book[] selectionSortHelper(Book[] bookshelf, int tailIndex) {
		/*
		 *  Find the minimum element in the unsorted sub-array[tailIndex..length-1]
		 *  and swap it with arr[tailIndex]
		 */
		int min = tailIndex;
		for (int i = tailIndex + 1; i < bookshelf.length; i++){
			if (bookshelf[i].compareTo(bookshelf[min]) < 0) {  // If arr[i] element is less, then it is the new minimum
				min = i;  // Update index of min element
			}
		}

		// Swap the minimum element in sub-array[tailIndex..length-1] with arr[tailIndex]
		swap(bookshelf, min, tailIndex);
		if (tailIndex + 1 < bookshelf.length - 1) return selectionSortHelper(bookshelf, tailIndex + 1);
		else return bookshelf;
	}
	
	/**
	 * Swaps the objects at x and y in the bookshelf.
	 * 
	 * @param bookshelf - Target array
	 * @param x - first object's index in array
	 * @param y - second object's index in array
	 */
	private static void swap(Book[] bookshelf, int a, int b) {
		Book temp = bookshelf[a];
		bookshelf[a] = bookshelf[b];
		bookshelf[b] = temp;
	}
	
	/**
	 * A method to return a copy of the given array
	 * @param bookshelf - Original Array
	 * @return - Copy of bookshelf
	 */
	public static Book[] copyOf(Book[] bookshelf) {
		Book[] copy = new Book[bookshelf.length];
		System.arraycopy(bookshelf, 0, copy, 0, bookshelf.length);
		return copy;
	}
	
	//////////////////Inner Book Class///////////////////
	
	public static class Book implements Comparable<Book>{
		private String name;
		private String author;
		private int yearPublished;
		private int numberOfPages;
		private int id;
		
		
		public Book(int id, String name, String author, int yearPublished, int numberOfPages) {
			this.id = id;
			this.name = name;
			this.author = author;
			this.yearPublished = yearPublished;
			this.numberOfPages = numberOfPages;
		}
		
		public String getName() {
			return name;
		}
		public String getAuthor() {
			return author;
		}
		public int getYearPublished() {
			return yearPublished;
		}
		public int getNumberOfPages() {
			return numberOfPages;
		}
		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + ", author=" + author + ", yearPublished=" + yearPublished + ", numberOfPages="
					+ numberOfPages + ", id=" + id + "]";
		}

		/**
		 * Compares the target book with b to determine order and returns:<br><br>
		 * target:  if target > b				   	   					  <br>
		 * equal: if they're equal					   					  <br>
		 * book: if target < b                         					  <br>
		 * 
		 * @param book object to be compared with target
		 * @return Integer representing the order of the books being compared
		 */
		@Override
		public int compareTo(Book book) {
			return this.getId() - book.getId();
		}
		
		/**
		 * Compares the target book with the parameter obj to determine if they are the same object. 
		 * 
		 * @param obj object to be compared with target
		 * @return boolean representing if the objects are equal
		 */
		public boolean equals(Object obj) {
			if(!(obj instanceof Book))
				return false;
			Book book = (Book) obj;
			return  this.getId() == book.getId() &&
					this.getName().equals(book.getName()) &&
					this.getAuthor().equals(book.getAuthor()) && 
					this.getYearPublished() == book.getYearPublished() &&
					this.getNumberOfPages() == book.getNumberOfPages();
		}	
	}
}
