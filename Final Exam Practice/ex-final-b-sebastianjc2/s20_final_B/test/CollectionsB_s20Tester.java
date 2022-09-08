import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CollectionsB_s20Tester {

	public CollectionsB_s20.Player p0;
	public CollectionsB_s20.Player p1;
	public CollectionsB_s20.Player p2;
	public CollectionsB_s20.Player p3;
	public CollectionsB_s20.Player p4;
	public CollectionsB_s20.Player p5;
	public CollectionsB_s20.Player p6;
	public CollectionsB_s20.Player p7;
	public CollectionsB_s20.Player p8;
	public CollectionsB_s20.Player p9;

	public Set< CollectionsB_s20.Player> empty;
	public Set< CollectionsB_s20.Player> allPlayers;
	public Set< CollectionsB_s20.Player> playersUPRMorUPRB;
	public Set< CollectionsB_s20.Player> allStarsUPRMorUPRB;	
	public Set< CollectionsB_s20.Player> playersUPRPorUPRA;
	public Set< CollectionsB_s20.Player> eastTeamPlayers;
	public Set< CollectionsB_s20.Player> westTeamPlayers;
	public Set< CollectionsB_s20.Player> eastTeamsAllStars;

	
	ArrayList<Set<CollectionsB_s20.Player>> UPRMorUPRBTeams;
	ArrayList<Set<CollectionsB_s20.Player>> allTeams;
	ArrayList<Set<CollectionsB_s20.Player>> allTeamsPlusEmptyFirst;
	ArrayList<Set<CollectionsB_s20.Player>> allTeamsPlusEmptyLast;
	ArrayList<Set<CollectionsB_s20.Player>> regionalTeams;
	ArrayList<Set<CollectionsB_s20.Player>> overlappingTeams1;
	ArrayList<Set<CollectionsB_s20.Player>> overlappingTeams2;

	@Before
	public void setUp() {

		p0 = new CollectionsB_s20.Player(00, "Juan", "Perez",CollectionsB_s20.Gender.MALE, 321, CollectionsB_s20.Team.UPRM);
		p1 = new CollectionsB_s20.Player(10, "Juana", "Perez",CollectionsB_s20.Gender.FEMALE, 352, CollectionsB_s20.Team.UPRB);
		p2 = new CollectionsB_s20.Player(20, "Pedro", "Rivera",CollectionsB_s20.Gender.MALE, 283, CollectionsB_s20.Team.UPRP);
		p3 = new CollectionsB_s20.Player(30, "Petra", "Rivera",CollectionsB_s20.Gender.FEMALE, 394, CollectionsB_s20.Team.UPRM);
		p4 = new CollectionsB_s20.Player(40, "Jose", "Rosas",CollectionsB_s20.Gender.MALE, 365, CollectionsB_s20.Team.UPRA);
		p5 = new CollectionsB_s20.Player(50, "Josefa", "Rosas",CollectionsB_s20.Gender.FEMALE, 336, CollectionsB_s20.Team.UPRB);
		p6 = new CollectionsB_s20.Player(60, "Carmelo", "Rivera",CollectionsB_s20.Gender.MALE, 287, CollectionsB_s20.Team.UPRM);
		p7 = new CollectionsB_s20.Player(70, "Carmela", "Rivera",CollectionsB_s20.Gender.FEMALE, 398, CollectionsB_s20.Team.UPRB);
		p8 = new CollectionsB_s20.Player(80, "Millo", "Diaz",CollectionsB_s20.Gender.MALE, 398, CollectionsB_s20.Team.UPRP);
		p9 = new CollectionsB_s20.Player(90, "Milla", "Diaz",CollectionsB_s20.Gender.FEMALE, 390, CollectionsB_s20.Team.UPRA);

		empty = new HashSet< CollectionsB_s20.Player>();
		
		allPlayers = new HashSet< CollectionsB_s20.Player>();
		allPlayers.add(p0); allPlayers.add(p1); allPlayers.add(p2); allPlayers.add(p3); allPlayers.add(p4);
		allPlayers.add(p5); allPlayers.add(p6); allPlayers.add(p7); allPlayers.add(p8); allPlayers.add(p9);

		playersUPRMorUPRB = new HashSet< CollectionsB_s20.Player>();
		playersUPRMorUPRB.add(p0); playersUPRMorUPRB.add(p1); playersUPRMorUPRB.add(p3);
		playersUPRMorUPRB.add(p5); playersUPRMorUPRB.add(p6); playersUPRMorUPRB.add(p7);
		
		allStarsUPRMorUPRB = new HashSet< CollectionsB_s20.Player>();
		allStarsUPRMorUPRB.add(p3); allStarsUPRMorUPRB.add(p7);

		playersUPRPorUPRA = new HashSet< CollectionsB_s20.Player>();
		playersUPRPorUPRA.add(p2); playersUPRPorUPRA.add(p4);
		playersUPRPorUPRA.add(p8); playersUPRPorUPRA.add(p9);
		
		eastTeamPlayers = new HashSet< CollectionsB_s20.Player>();
		eastTeamPlayers.add(p1); eastTeamPlayers.add(p2); eastTeamPlayers.add(p4);
		eastTeamPlayers.add(p5); eastTeamPlayers.add(p7); eastTeamPlayers.add(p8);
		
		eastTeamsAllStars = new HashSet< CollectionsB_s20.Player>(); // east stars who are playing UPRM vs UPRB
        eastTeamsAllStars.add(p7);
		
		westTeamPlayers = new HashSet< CollectionsB_s20.Player>();
		westTeamPlayers.add(p0); westTeamPlayers.add(p3); westTeamPlayers.add(p6); westTeamPlayers.add(p9);
		
		UPRMorUPRBTeams = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(playersUPRMorUPRB, playersUPRMorUPRB, playersUPRMorUPRB, playersUPRMorUPRB));
		allTeams = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(allPlayers, playersUPRMorUPRB, playersUPRPorUPRA));
		allTeamsPlusEmptyFirst = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(empty, allPlayers, playersUPRMorUPRB, playersUPRPorUPRA));
		allTeamsPlusEmptyLast = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(allPlayers, playersUPRMorUPRB, playersUPRPorUPRA, empty));
		regionalTeams = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(eastTeamPlayers, westTeamPlayers));
		overlappingTeams1 = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(eastTeamPlayers, allPlayers));
		overlappingTeams2 = new ArrayList<Set<CollectionsB_s20.Player>> (Arrays.asList(eastTeamPlayers, empty, empty, eastTeamPlayers, empty));

	}
	
	@Test
	public void testGetIntersectionBasic() {
		assertEquals("Intersection of three empty sets is not empty", empty, CollectionsB_s20.getIntersection(empty, empty, empty));
		assertEquals("Intersection of a non-empty set with two empty sets is not emty", empty, CollectionsB_s20.getIntersection(allPlayers, empty, empty));
		assertEquals("Intersection of a non-empty set with two empty sets is not empty", empty, CollectionsB_s20.getIntersection(empty, allPlayers, empty));
		assertEquals("Intersection of a non-empty set with two empty sets is not empty", empty, CollectionsB_s20.getIntersection(empty, empty, allPlayers));
		assertEquals("Intersection of a non-empty set with itself is not equal to the non-empty set", playersUPRMorUPRB, CollectionsB_s20.getIntersection(playersUPRMorUPRB, playersUPRMorUPRB, playersUPRMorUPRB));
	}
	
	@Test
	public void testGetIntersectionAdvanced() {
		assertEquals("Incorrect intersection of three sets", empty, CollectionsB_s20.getIntersection(playersUPRMorUPRB, playersUPRPorUPRA, playersUPRPorUPRA));
		assertEquals("Incorrect intersection of three sets", playersUPRPorUPRA, CollectionsB_s20.getIntersection(playersUPRPorUPRA, playersUPRPorUPRA, allPlayers));
		assertEquals("Incorrect intersection of three sets", playersUPRMorUPRB, CollectionsB_s20.getIntersection(allPlayers, allPlayers, playersUPRMorUPRB));
		assertFalse("Method getUnion not returning a new set", playersUPRMorUPRB == CollectionsB_s20.getIntersection(playersUPRMorUPRB, playersUPRPorUPRA, playersUPRMorUPRB));
		assertFalse("Method getUnion not returning a new set", playersUPRPorUPRA == CollectionsB_s20.getIntersection(playersUPRMorUPRB, playersUPRPorUPRA, playersUPRMorUPRB));
	}
	
	@Test
	public void testhasUniquePlayersBasic() {
		assertFalse("Empty sets cannot have unique elements", CollectionsB_s20.hasUniquePlayers(empty, empty, empty));
		assertTrue("Non-empty sets always have elements no in other empty sets", CollectionsB_s20.hasUniquePlayers(allPlayers, empty, empty));
		assertFalse("Empty sets cannot have unique elements", CollectionsB_s20.hasUniquePlayers(empty, allPlayers, empty));
		assertFalse("Empty sets cannot have unique elements", CollectionsB_s20.hasUniquePlayers(empty, empty, allPlayers));
		assertFalse("A non-empty set may not have elements not in itself", CollectionsB_s20.hasUniquePlayers(playersUPRMorUPRB, playersUPRMorUPRB, playersUPRMorUPRB));
	}
	
	@Test
	public void testhasUniquePlayersAdvanced() {
		assertTrue("Non-overlappig set have unique elements", CollectionsB_s20.hasUniquePlayers(playersUPRMorUPRB, playersUPRPorUPRA, playersUPRPorUPRA));
		assertFalse("Non-overlappig set have unique elements", CollectionsB_s20.hasUniquePlayers(playersUPRMorUPRB, playersUPRMorUPRB, playersUPRPorUPRA));
		assertFalse("Equal sets may not have unique elements", CollectionsB_s20.hasUniquePlayers(playersUPRMorUPRB, playersUPRPorUPRA, playersUPRMorUPRB));
		assertTrue("Sets must have elements not in their proper subsets", CollectionsB_s20.hasUniquePlayers(allPlayers, playersUPRPorUPRA, playersUPRPorUPRA));
		assertFalse("Sets may not have elements not in their super sets", CollectionsB_s20.hasUniquePlayers(playersUPRMorUPRB, playersUPRMorUPRB, allPlayers));
	}
	
	
	@Test
	public void testGetUnionBasic() {
		assertEquals("Union of list of sets including empty set must be empty", allPlayers, CollectionsB_s20.getUnion(allTeamsPlusEmptyFirst));
		assertEquals("Union of list of sets including empty set must be empty", allPlayers, CollectionsB_s20.getUnion(allTeamsPlusEmptyLast));
		assertEquals("Union of list of non-overlapping sets must be empty", allPlayers, CollectionsB_s20.getUnion(allTeams));
		assertEquals("Union of list of non-overlapping sets must be empty", allPlayers, CollectionsB_s20.getUnion(regionalTeams));
		assertFalse("getUnion must alwaays return a new set", allPlayers == CollectionsB_s20.getUnion(allTeamsPlusEmptyFirst));
		assertFalse("getUnion must alwaays return a new set", allPlayers == CollectionsB_s20.getUnion(allTeamsPlusEmptyLast));
		assertFalse("getUnion must alwaays return a new set", allPlayers == CollectionsB_s20.getUnion(allTeams));
		assertFalse("getUnion must alwaays return a new set", allPlayers == CollectionsB_s20.getUnion(regionalTeams));
	}	

	@Test
	public void testGetUnionAdvanced() {
		assertEquals("Union of list of multiples copies of same set must return same set", playersUPRMorUPRB, CollectionsB_s20.getUnion(UPRMorUPRBTeams));
		assertFalse("getUnion must alwaays return a new set", playersUPRMorUPRB == CollectionsB_s20.getUnion(UPRMorUPRBTeams));
		assertEquals("Union of list of multiples copies of same set must return same set", allPlayers, CollectionsB_s20.getUnion(overlappingTeams1));
		assertFalse("getUnion must alwaays return a new set", allPlayers == CollectionsB_s20.getUnion(overlappingTeams1));
		assertEquals("Union of list of multiples copies of same set must return same set", eastTeamPlayers, CollectionsB_s20.getUnion(overlappingTeams2));
		assertFalse("getUnion must alwaays return a new set", eastTeamPlayers == CollectionsB_s20.getUnion(overlappingTeams2));
	}	

}

