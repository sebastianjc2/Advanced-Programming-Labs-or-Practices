// Remember to add your name and repo name below
// Name: Caballero Diaz, Sebastian J
// GitHub Classroom Repository:  https://github.com/uprm-ciic4010-s20/mock-exam-2-sebastianjc2


/**
 * Immutable Smarphone class holds a smartphone represented by 
 * their brand, model and price.
 * @author Luis Rivera
 * @edited M. Alejandra Muñoz
 **/
public class Smartphone {

	private String brand;
	private String model;
	private int price;

	/**
	 * Constructor to create the object of a Smartphone.
	 * @param brand - String with the brand of the smartphone.
	 * @param model - String with the model of the smartphone.
	 * @param price - Integer with the price of the smartphone
	 */
	public Smartphone(String brand, String model, int price) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
	}


	@Override
	/**
	 * Method to override Java included equals to something more pertinent to what's needed of this
	 * class.
	 * 
	 * @param p2 - Smartphone object with a set of specifications
	 * @return Boolean that returns true if the target object and the parameter are the same, false if it's not.
	 */
	public boolean equals(Object p2) {
		if (!(p2 instanceof Smartphone)) {
			throw new RuntimeException("Illegal argument to Smarthphone.equals()");
		}
		Smartphone phone2 = (Smartphone) p2;
		return ((this.getBrand().equals(phone2.getBrand())) &&
				(this.getModel().equals(phone2.getModel())) &&
				(this.getPrice() == phone2.getPrice()));
	}

	@Override
	/**
	 * Method to override Java included toString to something more pertinent to what's needed of this
	 * class.
	 */
	public String toString() {
		return "Smartphone[" + brand + "," + model + "," + price + "]";
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}
	/**
	 * Exercise #1
	 * Method to count the amount of target brands inside the stock given
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @return Amount of phones of the same target brand in the given stock.
	 */
	public int countSameBrand(Smartphone[] stock) {
		// TODO ADD YOUR CODE HERE
		int sum = 0;
		for (int i = 0; i < stock.length; i++) {
			if(stock[i].getBrand().equals(this.getBrand())){
				sum = sum+1;
			}
		}

		return sum; //dummy return
	}

	/**
	 * Exercise #2
	 * Method to check if the target phone is inside the stock given as a parameter.
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @return Boolean that returns true if the phone is in stock and false if it's not.
	 */
	public boolean isAvailable(Smartphone[] stock) {
		for (int i = 0; i < stock.length; i++) {
			if(this.toString().equals(stock[i].toString())) {
				return true;
			}
		}
		return false; //dummy return
	}

	/**
	 * Exercise #3
	 * Method to find the highest priced smartphone inside the stock given as a parameter
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @return A Smarthphone object with the highest price in the stock given as a parameter.
	 */
	public static Smartphone highestPrice(Smartphone[] stock) {
		int price = -1;
		Smartphone highestPriceOne = null;
		for (int i = 0; i < stock.length; i++) {
			if (stock[i].getPrice()>= price) {
				highestPriceOne = stock[i];
				price = stock[i].getPrice();
			}

		}
		return highestPriceOne;
	}


	/**
	 * Exercise #4
	 * Method that returns smartphones with prices equal or lower than the budget that client has provided
	 * as parameter.
	 * 
	 * HINT - The Smartphone array that you return should not have any amount of nulls in it. Not in between
	 * each smartphone or at the end of it.
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @param budget - Integer with the budget the client has available
	 * @return Array filled with the Smartphones that the client has within his budget.
	 */
	public static Smartphone[] phonesInBudget(Smartphone[] stock, int budget) {
		int sum = 0;
		for (int i = 0; i < stock.length; i++) {
			if(stock[i].getPrice()<=  budget) {
				sum = sum+ 1;
			}
		}

		Smartphone[] lowerThanBudget = new Smartphone[sum];
		int count = 0;
		for (int i = 0; i < stock.length; i++) {
			if(stock[i].getPrice() <= budget) {
				lowerThanBudget[count] = stock[i];
				count++;
			}
		}
		return lowerThanBudget; 
	}

	/**
	 * Exercise #5
	 * Method that returns a smarphone that is equal to the model that the customer has provided in the
	 * parameters. Must stop looking as soon as the first Smartphone is found inside the stock given as
	 * paramater.
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @param model - String of the model the customer is looking for.
	 * @return
	 */
	public static Smartphone findModel(Smartphone[] stock, String model) {
		for (int i = 0; i < stock.length; i++) {
			
			if(stock[i].getModel().equals(model)) {
				return stock[i];
			}

		}		
		return null; // dummy return
	}


	/**
	 * Exercise #6
	 * Method to check if two phones of the same model are in stock.
	 * 
	 * HINT #1 - The method must stop as soon as a pair is found. 
	 * HINT #2 - Do not compare phones in the same position. For example 
	 * stock[0].getModel().equals(stock[0].getModel) will give you true but this is not correct.
	 * 
	 * @param stock - Smartphone array with the available phones.
	 * @return Boolean that returns true if there are two phones of the same model, false if it doesn't.
	 */
	public static boolean twoWithSameModelExist(Smartphone[] stock) {
		for (int i = 0; i < stock.length; i++) {
			for (int j = i + 1; j < stock.length; j++) {
				if(i == stock.length-1 && j == stock.length-1) {
					return false;
				}
				if(stock[j].getModel().equals(null)) {
					return false;
				}
				if(stock[i].getModel().equals(stock[j].getModel())) {
					return true;
				}
			}
		}
		return false; // dummy return
	}

}
