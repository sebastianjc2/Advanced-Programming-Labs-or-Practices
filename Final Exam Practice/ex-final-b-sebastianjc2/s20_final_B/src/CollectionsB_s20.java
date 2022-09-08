import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Remember to add your name and repo name below
//Name: Last-Names, First-Name
//GitHub Classroom Repository:

public class CollectionsB_s20 {

	public enum Gender {MALE, FEMALE, OTHER}
	public enum Team {UPRM, UPRB, UPRA, UPRP, UPRC}

	public static class Player {
		private int number;    // player's uniform jersey number
		private String firstName;
		private String lastName;
		private Gender gender;
		private int level;    // represents level of expertise ... like a batting average
		private Team team;

		public Player(int number, String firstName, String lastName, Gender gender, int level, Team major) {
			this.number = number;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.level = level;
			this.team = major;
		}

		public int getNumber() { return number; }
		public String getFirstName() { return firstName; }
		public String getLastName() { return lastName; }		
		public Gender getGender() { return gender; }
		public double getLevel() { return level; }
		public Team getTeam() { return team; }

		public boolean equals(Object o) {
			if (o instanceof Player) {
				Player p = (Player) o;
				return (p.getNumber() == this.getNumber());
			}
			return false;
		}

		@Override 
		public int hashCode() { return this.number; }
	}

	/** 
	 * EXERCISE #1
	 * A method that returns a new Set containing all the players that are members all of the three
	 * parameter teams.  This will be equivalent to the intersection of all the three sets.
	 * 
	 * YOU MAY NOT USE ANY LOOPS (e.g. for, while, do-while)
	 * 
	 */
	public static Set<Player> getIntersection(Set<Player> teamA,Set<Player> teamB, Set<Player> teamC) {
		// TODO EX #1
		// ADD YOUR CODE HERE
		Set<Player> firstIntersection = new HashSet<Player>(teamA);
		Set<Player> secondIntersection = new HashSet<Player>(teamB);
		Set<Player> thirdIntersection = new HashSet<Player>(teamC);
		firstIntersection.retainAll(secondIntersection);
		firstIntersection.retainAll(thirdIntersection);
		return firstIntersection; // dummy return
	}

	/**
	 * EXERCISE #2
	 * A method that returns true if and only if the first team (teamA) has at least
	 * one player no playing in any of the other two teams.  Returns false otherwise.
	 * 
	 * YOU MAY NOT USE ANY LOOPS (e.g. for, while, do-while)
	 * 
	 */
	public static boolean hasUniquePlayers(Set<Player> teamA,Set<Player> teamB, Set<Player> teamC) {
		if(teamA.size()==0 && teamB.size()==0 && teamC.size()==0) {return false;}
		else if(teamA.size()==0 && teamB.size()==0 && teamC.size()>0) {return true;}
		else if(teamA.size()==0 && teamB.size()>0 && teamC.size()>0) {return true;}
		else if(teamA.size()>0 && teamB.size()==0 && teamC.size()>0) {return true;}
		
		
		if(teamA == teamB || teamA==teamC || teamB==teamC) {return true;}
		if (teamA.retainAll(teamB)==false && teamA.retainAll(teamC)==false ) {
			return true;
		}
		return false; // dummy return
	}
	
		
	/**
	 * EXERCISE #3
	 * A method that returns a new set with the union of all the sets in a list.
	 * Returns an empty set if the list is empty.
	 */
	public static Set<Player> getUnion(ArrayList<Set<Player>> teams) {
		Set<Player> unionSet = new HashSet<Player>();
		
		if(teams.size()==0) return unionSet;
		for (int i = 0; i < teams.size(); i++) {
			if(teams.get(i)== null) continue;
			unionSet = new HashSet<>(teams.get(i));
			for (int j = 0; j < teams.size(); j++) {
				if(teams.get(j)==null) continue;
				unionSet.addAll(teams.get(j));
			}
		}
		// TODO EX #3
		// ADD YOUR CODE HERE
		return unionSet; // dummy return
	}
}
