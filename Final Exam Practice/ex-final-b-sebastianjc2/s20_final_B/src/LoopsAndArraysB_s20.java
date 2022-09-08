import java.util.Comparator;

//Remember to add your name and repo name below
//Name: Last-Names, First-Name
//GitHub Classroom Repository:

public class LoopsAndArraysB_s20 {
	public static class Gadget implements Comparable<Gadget>{

		// Enumerated BRAND for Gadget with purely hypothetical brand names.
		public enum Brand {ACME, BASICO, CHEAPO, DEALDEAL, EASYBUY, FUNTOY}; 

		// Enumerated TYPE for Gadget ranking from lowest to highest in terms of computing power.
		// The ordinal ranking of computing power is purely hypothetical.
		public enum Type {TABLET, MOBILE, CHROMEBOOK, NOTEBOOK, LAPTOP, DESKTOP, WORKSTATION};

		private Brand brand;
		private Type type;
		private int rewardPoints; // each point is equivalent to 10 cents (US dollars)
		private double rewardPrice; // purchase price if using reward points
		private double fullPrice; // full price without reward points

		public Brand getBrand() {return brand;}
		public Type getType() {return type;}
		public int getRewardPoints() {return rewardPoints;}
		public double getRewardPrice() {return rewardPrice;}
		public double getFullPrice() {return fullPrice;}

		public void setBrand(Brand brand) {this.brand = brand;}
		public void setType(Type type) {this.type = type;}
		public void setRewardPoints(int rewardPoints) {this.rewardPoints = rewardPoints;}
		public void setRewardPrice(double rewardPrice) {this.rewardPrice = rewardPrice;}
		public void setFullPrice(double fullPrice) {this.fullPrice = fullPrice;}

		public Gadget(Brand brand, Type type, int rewardPoints, double rewardPrice, double fullPrice) {
			super();
			this.brand = brand;
			this.type = type;
			this.rewardPoints = rewardPoints;
			this.rewardPrice = rewardPrice;
			this.fullPrice = fullPrice;
		}

		@Override
		public String toString() {
			return "Gadget [brand=" + brand + ", type=" + type + ", rewardPoints=" + rewardPoints + ", rewardPrice="
					+ rewardPrice + ", fullPrice=" + fullPrice + "]";
		}


		//Equals method for comparing if another object is the same as this instance
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Gadget))
				return false;
			Gadget other = (Gadget) obj;
			return this.getBrand() == other.getBrand() &&
					this.getType() == other.getType() &&
					this.getRewardPoints() == other.getRewardPoints() &&
					this.getRewardPrice() == other.getRewardPrice() &&
					this.getFullPrice() == other.getFullPrice();
		}


		/* 
		 * A compareTo method based on a particular Gadget value function.  Returns 0 if values are equal,
		 * positive if target Gadget is of better value, and negative if the value of the parameter Gadget
		 * is better.
		 */
		@Override
		public int compareTo(Gadget other) {
			return (int) 
					(Math.abs((this.getFullPrice() - this.getRewardPrice() + this.getRewardPoints()*0.10)) -
							Math.abs((other.getFullPrice() - other.getRewardPrice() + other.getRewardPoints()*0.10))); 
		}


		/**
		 * Exercise #1
		 * Determines if there is a Gadget with a better value in the given Gadget inventory.
		 * 
		 * Hint: Use the compareTo method provided above to compare the values between Gadget's.
		 * 
		 * The method should end as soon as the answer is known.
		 * 
		 * @param inventory
		 * @return
		 */
		public boolean betterValueExists(Gadget[] inventory) {
			// TODO EX #1 -- betterValueExists
			// ADD YOUR CODE HERE
			for (int i = 0; i < inventory.length; i++) {
				if(inventory[i].compareTo(this)>0) {
					return true;
				}
			}

			return false; // dummy return
		}


		/**
		 * Exercise #3
		 * Returns the min, max and average full-price of the Gadget's in a given Gadget store.
		 * The method returns an array with three values, namely, min, max and average full-price.
		 * @param store 
		 * @return
		 */
		public static double[] gadgetStats(Gadget[] store) {
			double[] stats = new double[3];
			if(store.length==0) return null;

			double minPrice = store[0].getFullPrice();
			double maxPrice = store[0].getFullPrice();
			double sum = 0;
			int count = 0;

			// TODO EX #3 -- gadgetStats
			// ADD YOUR CODE HERE
			for (int i = 0; i < store.length; i++) {
				if(store[i] != null && store[i].getFullPrice() <= minPrice) {
					minPrice = store[i].getFullPrice();
				}
				if(store[i] != null && store[i].getFullPrice()>=maxPrice) {
					maxPrice = store[i].getFullPrice();
				}
				if(store[i] != null) {
					sum = store[i].getFullPrice()+sum;
					count++;
				}
			}
			stats[0] = minPrice;
			stats[1] = maxPrice;
			stats[2] = sum / count;
			return stats; //dummy return
		}


		/**
		 * Exercise #4
		 * A method that returns a new array of gadgets with the INTERSECTION of 2 lots of gadgets
		 * You may assume the lots have unique elements.
		 * The new array should be compacted, removing any nulls except possibly at the end.
		 * 
		 * Restriction: You can't use classes from the Java Collections framework such as ArrayList, Set, etc..
		 * 
		 * @param lot1
		 * @param lot2
		 * @return
		 */
		public static Gadget[] intersectionOfLots(Gadget[] lot1, Gadget[] lot2) {
			// TODO EX #4 -- intersection
			int count=0;
			Gadget[] emptyLot = new Gadget[0];
			if(lot1 == null || lot2 == null || lot1.length==0 || lot2.length==0 ) return emptyLot;
			for (int i = 0; i < lot1.length; i++) {
				for (int j = 0; j < lot2.length; j++) {
					if(lot1[i] == lot2[j] && lot1[i] != null && lot2[j] != null) {
						count++;
					}
					
				}
			}
			// ADD YOUR CODE HERE
			int secCount=0;
			Gadget[] intersection = new Gadget[count];
			for (int i = 0; i < lot1.length; i++) {
				for (int j = 0; j < lot2.length; j++) {
					if(lot1[i] == lot2[j] && lot1[i] != null && lot2[j] != null) {
						intersection[secCount]=lot1[i];
						secCount++;
					}
					
				}
			}
			return intersection; // Dummy return

		}

	}

	public static class CompareHelper implements Comparator<Gadget>{
		/**
		 * EXERCISE #2
		 * A compare method that indicates which gadget is cheaper based on reward points and/or
		 * based on reward-price. May be used to sort gadgets accordingly. 
		 * 
		 * Returns a positive integer if the first parameter gadget has higher reward points.
		 * Returns a negative integer if the second parameter gadget has higher reward points.
		 * 
		 * If both parameter gadgets have the same reward points then the method returns
		 * a positive integer if the first parameter gadget has higher reward price, or returns
		 * a negative integer if the second parameter gadget has higher reward price, otherwise return 0.
		 * @param lot1
		 * @param lot2
		 * @return
		 */
		public int compare(Gadget g1, Gadget g2) {
			// TODO EX #2 -- compare
			// ADD CODE HERE
			if(g1.rewardPoints>g2.rewardPoints) {
				return 1;
			}
			else if(g1.rewardPoints<g2.rewardPoints) {
				return -1;
			}
			else {
				if(g1.rewardPrice>g2.rewardPrice) {
					return 1;
				}
				else if(g1.rewardPrice<g2.rewardPrice) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}

}
