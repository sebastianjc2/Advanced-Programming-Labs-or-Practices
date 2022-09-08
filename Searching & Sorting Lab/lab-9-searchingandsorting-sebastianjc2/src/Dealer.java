/**
 * REQUIRED INFO
 * 
 *  Full Name: Sebastian J. Caballero Diaz
 * 	GitHub Repo Link: https://github.com/uprm-ciic4010-s20/lab-9-searchingandsorting-sebastianjc2
 */
import java.util.Arrays;
import java.util.Comparator;

public class Dealer {
	
	private Car[] stock;

	/**
	 * Constructor for class Dealer
	 * @param stock - Initial array of cars
	 */
	public Dealer(Car[] stock) {
		this.stock = stock; 
	}
	
	/**
	 * Stock will always be full, no nulls.
	 * 
	 * @return stock - Array of cars in the dealer
	 */
	public Car[] getStock() {
		return stock;
	}
	
	/**
	 * Recursive Quick Sort for an array
	 * 
	 * @param shelve - Array to be sorted
	 * @param comp - comparator object to compare cards
	 */
	public static void quickSort(Comparator<Car> comp, Car[] deck) {
		quickHelper(comp, deck, 0, deck.length-1);
	}
	
	/**
	 * A helper method for the quick sort's recursive algorithm
	 * 
	 * @param stock - Array to be sorted
	 * @param tailIndex - Index of the right part of the array that is yet to be sorted.
	 */
	private static void quickHelper(Comparator<Car> comp, Car[] stock, int left, int right) {
		if(left < right) {
			int parIndex = partition(comp, stock, left, right);
			quickHelper(comp, stock, left, parIndex - 1);
			quickHelper(comp, stock, parIndex + 1, right);
			
		}
	}
	
	/**
	 * Exercise E: 																						 <br>
	 * 
	 * A helper method that distributes the items with a pivot and returns the index of where it stopped <br>
	 * 
	 * @param stock - array to be sorted
	 * @param left - left index of the section of to be sorted
	 * @param right - right index of the section to be sorted
	 * @return the index of the partition
	 */
	private static int partition(Comparator<Car> comp, Car[] stock, int left, int right) {
		Car pivot = stock[right];  
		int i = (left-1);
		for (int k = left; k < right; k++) {
			if(comp.compare(stock[k], pivot)<0) {
				i++;
				swap(stock, i, k);
			}
		}
		swap(stock, i+1, right);
		return i+1; 
	}
	
	/**
	 * Recursive Merge Sort for an array																	
	 * 
	 * @param stock - Array to be sorted
	 * @param comp - comparator object to compare cards
	 */
	public static void mergeSort(Comparator<Car> comp, Car[] stock) {
		int n = stock.length;
		if(n<2) return;
		int mid = n/2;
		Car[] S1 = Arrays.copyOfRange(stock, 0, mid);
		Car[] S2 = Arrays.copyOfRange(stock, mid, n);
		mergeSort(comp, S1);
		mergeSort(comp, S2);
		merge(comp, S1, S2, stock);
	}
	
	/*
	 * Bonus Problem (10pts): Finish the merge algorithm for the Merge Sort.
	 */
	
	/**
	 * A helper method that distributes the items with a pivot and returns the index of where it stopped
	 * 
	 * @param stock - array to be sorted
	 * @param S1 - left section of to be sorted
	 * @param S2 - right section to be sorted
	 * @param comp - comparator object to compare cars
	 * @return the index of the partition
	 */
	private static void merge(Comparator<Car> comp, Car[] S1, Car[] S2, Car[] stock) {
		/*
		 * Remove comments and complete the implementation.
		 */
		int i = 0, j = 0, k=0;
		while (i + j < stock.length) {
			if (comp.compare(S1[i], S2[j])<=0) {
				stock[k] = S1[i];
				k++;
				i++;
			} else {
				stock[k] = S2[j++];
				k++;
				j++;
			}
		}
	}
	
	/**
	 * A method to return a copy of the given array
	 * 
	 * @param stock - Original Array
	 * @return - Copy of stock
	 */
	public static Car[] copyOf(Car[] stock) {
		Car[] copy = new Car[stock.length];
		for(int i = 0; i < stock.length; i++) {
			copy[i] = stock[i];
		}
		return copy;
	}
	
	/**
	 * Helper method to swap the position of two objects in a given array
	 * 
	 * @param deck - array to work in
	 * @param a - index of the first object to swap
	 * @param b - index of the second object to swap
	 */
	private static void swap(Car[] stock, int a, int b) {
		Car temp = stock[a];
		stock[a] = stock[b];
		stock[b] = temp;
	}
	
	//////////////////Inner Car Class///////////////////
	
	public static class Car{
		private String model;
		private int year;
		private String brand;
		private double price;
		
		public Car(String model, int year, String brand, double price) {
			this.model = model;
			this.year = year;
			this.brand = brand;
			this.price = price;
		}
		
		public String getModel() {
			return model;
		}

		public int getYear() {
			return year;
		}

		public String getBrand() {
			return brand;
		}

		public double getPrice() {
			return price;
		}
		
		@Override
		public String toString() {
			return "Car [model=" + model + ", year=" + year + ", brand=" + brand + ", price=" + price + "]";
		}
		
		/**
		 * Compares the target book with the parameter obj to determine if they are the same object. 
		 * 
		 * @param obj object to be compared with target
		 * @return boolean representing if the objects are equal
		 */
		public boolean equals(Object obj) {
			if(!(obj instanceof Car))
				return false;
			Car car = (Car) obj;
			return this.getModel().equals(car.getModel()) && 
				   this.getBrand().equals(car.getBrand()) &&
				   this.getYear() == car.getYear() && 
				   this.getPrice() == car.getPrice();
		}
		
	}
	
	/**
	 * Exercise D:
	 * 
	 * Create a comparator for the class type Car
	 */
	public static class CarComparator implements Comparator<Car> {
		
		public CarComparator() {
			// Empty since we only need to initialize it to use the compare method.
		}
		
		@Override
		public int compare(Car c1, Car c2) {
			/*
			 *  NOTE: We have to compare all the information of the cars lexicographically.
			 *  Example: String1 = "Hey"
			 *  		 String2 = "Bye"
			 *  Lexicographically, String1 is bigger than String2.
			 */
			
			//Add Code
			return c1.toString().compareTo(c2.toString());
		}	
	}
}
