// Name: Caballero Diaz, Sebastian J.
// GitHub Classroom Repository: https://github.com/uprm-ciic4010-s20/collections-lab-sebastianjc2

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CollectionsWrapper {

	public static class Car {
		
		private String brand;
		private String model;
		private int year;
		private double price;

		public Car(String brand, String model, int year, double price) {
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.price = price;
		}

		public String getBrand() {return brand;}
		public String getModel() {return model;}
		public int getYear() {return year;}
		public double getPrice() {return price;}
		public void setBrand(String brand) {this.brand = brand;}
		public void setModel(String model) {this.model = model;}
		public void setYear(int year) {this.year = year;}
		public void setPrice(double price) {this.price = price;}
		@Override
		public boolean equals(Object o) {
			if(o instanceof Car) {
				Car c = (Car) o;
				return 	brand.equals(c.getBrand()) 
						&& model.equals(c.getModel()) 
						&& year == c.getYear() 
						&& price == c.getPrice();
			}
			return false;
		}
	}
	/**
	 * EXERCISE A
	 * 
	 * Implement the method "buyCar". 
	 * It receives a queue containing all the cars in the dealer and the budget of the client.
	 * Return a queue containing the cars that the client can buy with the given budget.
	 * 
	 * Note:	
	 * The queue can be null or contain null slots meaning that the client does not like one car or any car.
	 * If so return an empty queue.
	 * 
	 * YOUR ARE NOT ALLOW TO USE "FOR EACH" TO ITERATE THE QUEUE!	 
	 * 
	 * TODO
	 */

	public static Queue<Car> buyCar(Queue<Car> cars, int budget) {
		Queue<Car> carsInBudget = new LinkedList<Car>();
		if(cars == null) {
			return carsInBudget;
		}
		int count = 0;
		while(count<cars.size()) {
			if(cars.peek()==null) {
				Car elem = cars.poll();
				cars.add(elem);
				return carsInBudget;
				
			}
			if(cars.peek().getPrice()>budget) {
				Car elem = cars.poll();
				cars.add(elem);
			}
			else if (cars.peek().getPrice()<=budget){
				Car elem = cars.poll();
				carsInBudget.add(elem);
				cars.add(elem);
			}
			count++;
		}
		return carsInBudget; // Dummy return
	}


	/**
	 * EXERCISE B
	 * 
	 * Implement the method "countName"
	 * 
	 * It receives a list of string arrays and must return the number of instances the given string appear in the arrays inside the list.
	 * Do not count any null values or null parameters.
	 * 
	 * TODO
	 * 
	 * HINT: What would you do for a double-array?
	 */
	
	public static int countName(ArrayList<String[]> list, String name) {
		int count = 0;
		if(list == null || name == null) return count;
		for (int i = 0; i < list.size(); i++) {
			String[] array = list.get(i);
			if(array == null) continue;
			for (int j = 0; j < array.length; j++) {
				if(array[j] != null && array[j].equals(name)) {
					count++;
				}
			}
		}
		return count; // Dummy return
		
	}

	
	
	
}
