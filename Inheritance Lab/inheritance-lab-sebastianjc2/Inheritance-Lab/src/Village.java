/**
 * REQUIRED INFO
 * 
 *  Full Name: Sebastian J. Caballero Diaz
 * 	GitHub Repo Link: https://github.com/uprm-ciic4010-s20/inheritance-lab-sebastianjc2
 */

public class Village {

	private String villageName;
	private Player[] players;

	public Village(String villageName, int numOfPlayers ,String[][] players) {
		super();
		this.villageName = villageName;
		this.players = new Player[numOfPlayers];
		for(int i = 0; i < numOfPlayers; i++) {
			switch(players[i][0]) {
			case "Villager":
				this.players[i] = 
				new Villager(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),players[i][4]);
				break;
			case "Police":
				this.players[i] = 
				new Police(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),players[i][4]);
				break;
			case "Chief":
				this.players[i] = 
				new Chief(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),Integer.parseInt(players[i][4]));
				break;
			case "Mayor":
				this.players[i] = 
				new Mayor(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),Integer.parseInt(players[i][4]));
				break;
			}
		}
	}
	public String getVillageName() {
		return this.villageName;
	}
	public int numOfPlayers() {
		return players.length;
	}

	public String[] getChiefPolice() {
		String[] ret = new String[4];
		ret[0] = players[0].getName();
		ret[1] = String.valueOf(players[0].getInches());
		ret[2] = String.valueOf(players[0].getWeight());
		ret[3] = String.valueOf(((Chief) players[0]).getYearsInService());
		return ret;
	}

	public int getChiefSalary() {
		int ret = 0;
		ret = ((Chief)players[0]).getSalary();
		return ret;
	}

	public boolean[] event(String event) {
		boolean [] ret = new boolean[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].enterEvent(event);
		}
		return ret;
	}

	public boolean[] alarm() {
		boolean [] ret = new boolean[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].canDisableAlarm();
		}
		return ret;
	}

	public String[] greetAll() {

		String[] ret = new String[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].greet();
		}
		return ret;
	}

	public boolean[] comparePlayers() {

		boolean[] ret = new boolean[players.length+2];
		for(int i = 0; i < players.length; i++) {
			ret[i] = players[i].equals(players[(players.length-1)-i]);
		}
		ret[players.length] = players[0].equals(null);
		ret[players.length+1] = players[0].equals(players[0]);
		return ret;
	}


	public static String[] getAllNames(Player[] a) {
		if(a == null) return new String[0];
		String[] res, arr = new String[a.length];
		int i = 0;
		for (i = 0; i < a.length && a[i] != null; arr[i] = a[i].getName(),i++);
		res = new String[a.length == 0 ? 0 : i];
		System.arraycopy(arr, 0, res, 0, i);
		return res;
	}

	/*
	 * EXERCISE F:
	 * 
	 * Implement the method to count the difference types of players by using instanceof.
	 * Return a new String array with 3 numbers as a String
	 * First one would be the number of Villagers
	 * Second would be number of Police
	 * Third would be number of Mayors
	 * (Hint: Use the method String.valueOf(...) to change from a int to a String)
	 */
	public String[] countTypesOfPlayers() {
		int numVillagers = 0;
		int numPolice = 0;
		int numMayors = 0;
		for (int i = 0; i < players.length; i++) {
			if(players[i] instanceof Villager) {
				numVillagers++;
			}
			if(players[i] instanceof Police) {
				numPolice++;
			}
			if(players[i] instanceof Mayor) {
				numMayors++;
			}
		}
		return new String[]{String.valueOf(numVillagers), String.valueOf(numPolice), String.valueOf(numMayors)};//Dummy Return

	}

	/**
	 * BONUS:
	 * 
	 * Return an array of Player objects that contains first the Chiefs, then the Mayors, then the Polices 
	 * and then the Villagers that their inches is at least 65.
	 * 
	 * HINT: Must use instanceof, type 	-> (0) Chief, (1) Mayors ...
	 */

	public Player[] tallPlayers() {
		Player[] temp = new Player[numOfPlayers()];
		int realSize =0;

		for (int i = 0, type=0; i < numOfPlayers() && type < 4; i++) {

			if(players[i] instanceof Chief && players[i].getInches() >= 65) {
				
			}
			
			if(i == numOfPlayers() - 1) { // Reached the end
				i = -1; 
				type++;
			}
		}

		return null; //Dummy return
	}



	/*-----------------------------------------------------------------------------------------------------------------------------
	  														This is the abstract class Player
	 ------------------------------------------------------------------------------------------------------------------------------*/
	abstract class Player {
		private String name;
		private int inches;
		private int weight;

		protected Player(String name, int inches, int weight) {
			super();
			this.name = name;
			this.inches = inches;
			this.weight = weight;
		}
		public String getName() {
			return name;
		}
		public int getInches() {
			return inches;
		}
		public int getWeight() {
			return weight;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setInches(int inches) {
			this.inches = inches;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public boolean canDisableAlarm() {
			return false;
		}

		public abstract String greet();
		public abstract boolean enterEvent(String event);
	}
	/*-----------------------------------------------------------------------------------------------------------------------------
	 														This is the Villager Class
	 	This is the first class of the four classes. In this class you must to complete part of the given code, read instructions.													

	 -------------------------------------------------------------------------------------------------------------------------------*/
	class Villager extends Player {

		private String job;

		public Villager(String name, int inches, int weight, String job) {
			super(name, inches, weight);
			this.job = job;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}

		/*
		 * EXERCISE C PART 1
		 * 
		 * Override object's method (enterEvent) considering
		 * the parameter's type String
		 * Villager can only enter the Party event
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.equals("Party")) {
				return true;
			}
			return false; //Dummy Return

		}
		/*
		 * EXERCISE D
		 * 
		 * Modify each class to greet as follows: (greet() method).
		 * Villager: "Hello, I am [name] and I work at [work place]."
		 */
		@Override
		public String greet() {
			return "Hello, I am " + getName() + " and I work at " + getJob() + "."; //Dummy Return
		}
		/* 
		 * EXERCISE E
		 * 
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Villager) {
				Villager v = (Villager) obj;
				return (v.getJob().equals(this.getJob()) && v.getInches() == (this.getInches()) && v.getWeight() == this.getWeight() && v.getName().equals(this.getName()));
			}
			return false; //Dummy Return

		}
	}
	/*-----------------------------------------------------------------------------------------------------------------------------
													   This is the Police Class
        This is the second class of the four classes. In this class you must to complete part of the given code, read instructions.													

    -------------------------------------------------------------------------------------------------------------------------------*/
	class Police extends Player {

		private final int SALARY = 50000;


		public int getSalary() {
			return SALARY;
		}

		private String rank;

		public Police(String name, int inches, int weight, String rank) {
			super(name, inches, weight);
			this.rank = rank;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		/*
		 * EXERCISE C PART 1
		 * 
		 * Override object's method enterEvent considering
		 * the parameter's type String
		 * Police can only enter the Party and PDMeeting events
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.equals("Party") || event.equals("PDMeeting")) {
				return true;
			}

			return false; //Dummy Return

		}
		/*
		 * EXERCISE D
		 * 
		 * Modify each class to greet as follows: (greet() method).
		 * Police: "I am Police [name] at your service."
		 */
		@Override
		public String greet() {
			
			return "I am Police " + this.getName() + " at your service."; //Dummy Return

		}
		/* 
		 * EXERCISE E
		 * 
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Police) {
				Police v = (Police) obj;
				return (v.getRank().equals(this.getRank()) && v.getInches() == (this.getInches()) && v.getWeight() == this.getWeight() && v.getName().equals(this.getName()));
			}
			return false; //Dummy Return

		}
	}
	/*-----------------------------------------------------------------------------------------------------------------------------
	   													This is the Chief Class
		This is the third class of the four classes. In this class you must to complete part of the given code, read instructions.													
     -------------------------------------------------------------------------------------------------------------------------------*/
	class Chief extends Police {

		private int yearsInService;
		/*
		 * EXERCISE A
		 * 
		 * Implement the Chief Class by calling the super constructor
		 * and passing the correspondent parameters.
		 * HINT: you can find Police class to use it as a guide. And remember a Chief is a rank
		 */
		public Chief(String name, int inches, int weight, int yearsInService) {			
			super(name, inches, weight, "Chief");//Dummy super
			this.yearsInService = yearsInService;

		}
		public int getYearsInService() {
			return yearsInService;
		}
		public void setYearInService(int yearsInService) {
			this.yearsInService = yearsInService;
		}

		/*
		 * EXERCISE B
		 * 
		 * Override the getSalary method by calling the super
		 * getSalary and adding the bonus times yearInService.
		 * If chief has more than 3 years and less than 5 years of service his salary will be raised 25%
		 * If chief has 5 years or more and less that 10 years of service his salary will be raised 50%
		 * If chief has 10 years or more of service his salary will be raised 75%
		 * Else the salary will not be raised.
		 */
		@Override
		public int getSalary() {
			//Implement here!
			int salary = super.SALARY;
			if(getYearsInService() > 3 && getYearsInService() < 5) {
				salary = (int) (salary + (salary * .25));
			}
			else if(getYearsInService() >= 5 && getYearsInService() < 10) {
				salary = (int) (salary + (salary * .50));
			}
			else if(getYearsInService() >= 10) {
				salary = (int) (salary + (salary * .75));
			}
			else {
				return salary;
			}

			return salary;//Dummy Return
		}


		/*
		 * EXERCISE C PART 2
		 * 
		 * Create and Override the canDisableAlarm 
		 * return true when asked to disable Alarm, remember only Chief can disable alarm.
		 * [disableAlarm() method]
		 */
		
		@Override
		public boolean canDisableAlarm() {
			return true;
		}


		/*
		 * EXERCISE D
		 * 
		 * Modify each class to greet as follows: (greet() method).
		 * Chief: "I am Chief [name]."
		 */
		@Override
		public String greet() {
			
			return "I am Chief " + this.getName()+ "."; //Dummy Return

		}


		/* 
		 * EXERCISE E
		 * 
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Chief) {
				Chief v = (Chief) obj;
				return (v.getYearsInService() == (this.getYearsInService()) && v.getInches() == (this.getInches()) && v.getWeight() == this.getWeight() && v.getName().equals(this.getName()));
				
			}
			return false;//Dummy Return

		}
	}
	/*-----------------------------------------------------------------------------------------------------------------------------
		                                              This is the Mayor Class
         This is the fourth class of the four classes. In this class you must to complete part of the given code, read instructions.													
     -------------------------------------------------------------------------------------------------------------------------------*/
	class Mayor extends Player {

		private int term;

		public Mayor(String name, int inches, int weight, int term) {
			super(name, inches, weight);
			this.term = term;
		}
		public int getTerm() {
			return term;
		}
		public void setTerm(int term) {
			this.term = term;
		}

		/*
		 * EXERCISE C PART 1
		 * 
		 * Override object's method enterEvent considering
		 * the parameter's type String
		 * Mayor can enter the Party, PDMeeting and Presidential Reunion events
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.equals("Party") || event.equals("PDMeeting") || event.equals("Presidential Reunion")) {
				return true;
			}

			return false;//Dummy Return
		}

		/*
		 * EXERCISE D
		 * 
		 * Modify each class to greet as follows: (greet() method).
		 * Mayor: "Greetings, I am [name], the Mayor of this city."
		 */
		@Override
		public String greet() {
			
			return "Greetings, I am " + this.getName() + ", the Mayor of this city."; //Dummy Return

		}
		/* 
		 * EXERCISE E
		 * 
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Mayor) {
				Mayor v = (Mayor) obj;
				return (v.getTerm() == (this.getTerm()) && v.getInches() == (this.getInches()) && v.getWeight() == this.getWeight() && v.getName().equals(this.getName()));
				
			}
			return false;//Dummy Return
		}
	}
}