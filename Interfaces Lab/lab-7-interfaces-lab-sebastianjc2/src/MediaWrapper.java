// Name: Sebastian J. Caballero Diaz
// repo link: https://github.com/uprm-ciic4010-s20/lab-7-interfaces-lab-sebastianjc2


public class MediaWrapper {
	/*
        Make Series and Movie classes implement the Filmable interface and all it's
        methods
	 */
	interface Filmable {
		int getFilmBudget();

		boolean isClassic();

		boolean isSuccessful();
	}

	public static class Movie implements Filmable{
		public String name;
		public Actor[] cast;

		private int productionCosts;
		private int yearsSinceProduced;
		private int rating; // This rating goes from 0 to 5

		public Movie(String name, Actor[] cast, int productionCosts, int yearsSinceProduced, int rating) {
			this.name = name;
			this.cast = cast;
			this.productionCosts = productionCosts;
			this.yearsSinceProduced = yearsSinceProduced;
			this.rating = rating;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Actor[] getCast() {
			return cast;
		}

		public void setCast(Actor[] cast) {
			this.cast = cast;
		}

		public int getProductionCosts() {
			return productionCosts;
		}

		public void setProductionCosts(int productionCosts) {
			this.productionCosts = productionCosts;
		}

		public int getYearsSinceProduced() {
			return yearsSinceProduced;
		}

		public void setYearsSinceProduced(int yearsSinceProduced) {
			this.yearsSinceProduced = yearsSinceProduced;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		/*
		 * This method should return the sum of the production cost + the cost
		 * of Contract of each of the actors
		 */
		public int getFilmBudget() {
			int sum = 0;
			for(int i=0;i<cast.length;i++) {
				sum += cast[i].costOfContract;
			}
			return getProductionCosts() + sum; // dummy return
		}

		/*
		 * This method should return true if the Movie's year
		 * of production was more than 10 years ago
		 */
		public boolean isClassic(){
			return (yearsSinceProduced>10); 
		}

		/*
		 * This method should true true if at least ONE of the members of the cast has 
		 * a fameScore of 4 or 5 AND the rating is bigger than 4.
		 */
		public boolean isSuccessful(){
			for(int i=0; i<cast.length; i++) {
				if(cast[i].fameScore > 3 && getRating() >4) {
					return true;
				}
			}
			return false; // dummy return
		}

	}

	public static class Series implements Filmable{
		private String name;
		private Actor[] cast;

		private int productionCosts;
		private int numberOfSeasons;

		public Series(String name, Actor[] cast, int productionCosts, int numberOfSeasons) {
			this.name = name;
			this.cast = cast;
			this.productionCosts = productionCosts;
			this.numberOfSeasons = numberOfSeasons;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Actor[] getCast() {
			return cast;
		}

		public void setCast(Actor[] cast) {
			this.cast = cast;
		}

		public int getNumberOfSeasons() {
			return numberOfSeasons;
		}

		public void setNumberOfSeasons(int numberOfSeasons) {
			this.numberOfSeasons = numberOfSeasons;
		}

		public int getProductionCosts() {
			return productionCosts;
		}

		public void setProductionCosts(int productionCosts) {
			this.productionCosts = productionCosts;
		}

		/*
            This method should return:
             the production costs of the series + (the cost of Contract of each actor in the cast x the number of seasons)
		 */
		public int getFilmBudget(){
			int sum =  0;
			for(int i = 0; i<cast.length; i++) {
				sum+= cast[i].costOfContract;
			}
			return getProductionCosts() + (sum * getNumberOfSeasons());
		}

		/*
            This method should return true if the Series
            has more than 5 seasons and false otherwise
		 */
		public boolean isClassic(){
			return (getNumberOfSeasons() > 5); // dummy return
		}

		/*
            This method should return true if at least ONE of the members of the cast
            has a fameScore of 4 or 5 AND the Series has more than 2 seasons
		 */
		public boolean isSuccessful(){
			for(int i = 0; i < cast.length; i++) {
				if(cast[i].getFameScore() > 3 && getNumberOfSeasons() > 2) {
					return true;
				}
			}
			return false;
		}

	}

	public static class Actor {
		private String name;
		private int costOfContract;
		private int fameScore; // This Score goes on a scare from 0 to 5

		public Actor(String name, int costOfContract, int fameScore) {
			this.name = name;
			this.costOfContract = costOfContract;
			this.fameScore = fameScore;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCostOfContract() {
			return costOfContract;
		}

		public void setCostOfContract(int costOfContract) {
			this.costOfContract = costOfContract;
		}

		public int getFameScore() {
			return fameScore;
		}

		public void setFameScore(int fameScore) {
			this.fameScore = fameScore;
		}
	}
}