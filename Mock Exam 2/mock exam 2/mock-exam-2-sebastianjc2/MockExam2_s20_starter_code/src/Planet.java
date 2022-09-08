// Remember to add your name and repo name below
// Name: LastNames, First Name
// GitHub Classroom Repository: 

/**
 * Immutable Planet class holds a planet represented by 
 * name, distance in light years to earth, the galaxy they are part of,
 * radius (km) and population.
 * Remember to add your name and User ID.
 * Name: LastNames, First Name
 * @author M. Alejandra Muñoz 
 * @author Fatima Puig
 **/
public class Planet {

	private String name;
	private double distance;
	private String galaxy;
	private double radius;
	private int population;

	/**
	 * Constructor to create a Planet object
	 * @param name - String with the name of the planet.
	 * @param distance - Double with the distance in light years from Earth.
	 * @param galaxy - String of where the planet is located.
	 * @param radius - Double with the radius of the planet.
	 * @param population - Integer with the population of the planet.
	 */
	public Planet(String name, double distance, String galaxy, double radius, int population) {
		super();
		this.name = name;
		this.distance = distance;
		this.galaxy = galaxy;
		this.radius = radius;
		this.population = population;
	}

	@Override
	/**
	 * Method to override the initial equals method so that it works in this class.
	 * 
	 * @param e - Object to be check against the target.
	 * @return Boolean that returns true if the target object and the parameter are the same, false if it's not.
	 */
	public boolean equals(Object e) {
		if(e instanceof Planet && ((Planet) e).name.equals(this.name))
			return true;
		return false;
	}

	@Override
	/**
	 * Method to override Java included toString to something more pertinent to what's needed of this
	 * class.
	 */
	public String toString() {
		return "Planet " + this.name;
	}

	public String getName() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	public String getGalaxy() {
		return galaxy;
	}

	public double getRadius() {
		return radius;
	}

	public int getPopulation() {
		return population;
	}

	/**
	 * EXERCISE #1
	 * Method that finds the pair of planets are in the same galaxy inside the
	 * universe and the galaxy given as a parameters.
	 * 
	 * @param universe - Planet array that contains most of the universe.
	 * @param galaxy - String of where the planet is located.
	 * @return Planet array with the planets that are inside the same galaxy.
	 */
	public static Planet[] sameGalaxy(Planet[] universe, String galaxy) {
		int count = 0;
		for (int i = 0; i < universe.length; i++) {
			if(universe[i].getGalaxy().equals(galaxy)) {
				count += 1;
			}
		}
		int counter = 0;
		Planet[] inSameGalaxy = new Planet[count];
		for (int i = 0; i < universe.length; i++) {
			if(universe[i].getGalaxy().equals(galaxy)) {
				inSameGalaxy[counter] = universe[i];
				counter++;
			}
		}
		return inSameGalaxy; 

	}

	/**
	 * EXERCISE #2
	 * Method that returns the planet with the highest population in the galaxy given
	 * as parameter.
	 * 
	 * HINT - Check the toString method inside this class.
	 * 
	 * @param galaxy - Planet array that contains a single galaxy.
	 * @return String of the planet with the highest population.
	 */
	public static String hightestPopulation(Planet[] galaxy) {
		String highestPopulationPlanet = "";
		int highestPop = 0;
		for (int i = 0; i < galaxy.length; i++) {
			if(galaxy[i].getPopulation()>= highestPop) {
				highestPop = galaxy[i].getPopulation();
				highestPopulationPlanet = galaxy[i].toString();
			}
		}
		return highestPopulationPlanet;  // dummy return
	}

	/**
	 * EXERCISE #3
	 * Method to check which planet is closest to Earth (least amount of light years)
	 * 
	 * @param universe - Planet array that contains most of the universe.
	 * @return Planet object with the planet closest to the Earth
	 */
	public static Planet closestToEarth(Planet[] universe) {
		Planet closest = null;
		double distTo = universe[0].distance;
		for (int i = 0; i < universe.length; i++) {
			
			if(universe[i].getDistance() <= distTo) {
				distTo = universe[i].getDistance();
				closest = universe[i];
			}
			
		}
		return closest; // dummy return
	}

	/**
	 * EXERCISE #4
	 * Method that returns planets (in String form) smaller or equal to the radius given in the parameter.
	 * 
	 * HINT - Check the toString method in this class.
	 * 
	 * @param galaxy - Planet array that contains a single galaxy.
	 * @param radius - Double with the radius of a planet.
	 * @return String array filled with the planets that meet the requirements.
	 */
	public static String[] planetsSmallerThan(Planet[] galaxy, double radius) {
		int sum = 0;
		for (int i = 0; i < galaxy.length; i++) {
			if(galaxy[i].radius <= radius) {
				sum += 1;
			}
		}
		
		String[] smallerPlanets = new String[sum];
		int count = 0;
		for (int i = 0; i < galaxy.length; i++) {
			if(galaxy[i].radius <= radius) {
				smallerPlanets[count] = galaxy[i].toString();
				count++;
			}
		}
		return smallerPlanets;

	}

	/**
	 *  EXERCISE #5
	 * Method to check if there are two planets or more inside the galaxy given.
	 * 
	 * MUST BE IMPLEMENTED WITH A FOR LOOP, as there could be nulls inside the array
	 * 
	 * @param galaxy - Planet array that contains a single galaxy.
	 * @return Boolean that returns true if there is two or more planets inside the galaxy.
	 */
	public static boolean moreThanTwoPlanets(Planet[] galaxy) {
		int sum = 0;
		for (int i = 0; i < galaxy.length; i++) {
			if(galaxy[i] != null) {
				sum += 1;
			}
		}
		return sum>=2; // dummy return
	}
}
