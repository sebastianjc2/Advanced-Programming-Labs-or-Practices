// Name: Sebastian J. Caballero Diaz
// repo link: https://github.com/uprm-ciic4010-s20/lab-7-interfaces-lab-sebastianjc2

public class StreetWrapper {
	/*
		Create an interface Nameable with the methods String getName() and int getDistance()
		Make Street implement the Nameable interface and it's methods getDistance() and getName()
	 */
	interface Nameable{
		String getName();
		
		int getDistance();
		
	}


	
	public static class Street implements Nameable{
		private String name;
		private int distance;
		
		public Street(String name, int distance) {
			this.name = name;
			this.distance = distance;
		}

		public String getName() {
			return this.name;
		}

		
		public int getDistance() {
			
			return this.distance;
		}
	}

}
