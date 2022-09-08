import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;



public class VillageTest {

	private String[][] players1 = {

			{"Villager","Alberto","72","100","BlackSmithShop"},

			{"Police","Elvin","60","100","ClerkPlace"},

			{"Chief","Harry","61","100","5"},

			{"Mayor","Bienve","70","100","10"}

	};

	private String[][] players2 = {

			{"Villager","Tato","60","100","PizzaPlace"},

			{"Villager","David","61","100","PizzaPlace"},

			{"Villager","Jaime","62","100","PizzaPlace"},

			{"Villager","Alberto","63","100","PizzaPlace"},

			{"Police","Felipe","64","100","Clerk"},

			{"Police","Javier","65","100","Clerk"},

			{"Police","Jose","66","100","Clerk"},

			{"Chief","Juan","67","100","5"},

			{"Mayor","Pedro","68","100","10"}

	};

	private String[][] players3 = new String[0][0];

	private String[][] players4 = {

			{"Villager","Tato","60","100","PizzaPlace"},

			{"Police","Felipe","64","100","Clerk"},

			{"Mayor","Pedro","68","100","10"},

			{"Chief","Juan","67","100","5"},

			{"Chief","Juan","67","100","5"},

			{"Mayor","Pedro","68","100","10"},

			{"Police","Felipe","64","100","Clerk"},

			{"Villager","Tato","60","100","PizzaPlace"}

	};



	@Test

	public void testChiefConstructor() {

		String[][] pC1 = {{"Chief","Felipe","60","100","20"}};

		Village vC1 = new Village("Chief Only 1",1,pC1);

		String[] res1 = vC1.getChiefPolice();



		assertEquals("The name must be set to the superclass","Felipe",res1[0]);

		assertEquals("The inches must be set to the superclass","60",res1[1]);

		assertEquals("The weight must be set to the superclass","100",res1[2]);

		assertEquals("The years in service must be set in the class","20",res1[3]);



		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);

	}



	@Test

	public void testChiefGetSalary() {

		String[][] pC1 = {{"Chief","Felipe","60","100","0"}};

		String[][] pC2 = {{"Chief","Mario","65","120","1"}};

		String[][] pC3 = {{"Chief","Maria","60","100","2"}};

		String[][] pC4 = {{"Chief","Pepe","65","120","3"}};

		String[][] pC5 = {{"Chief","Felipe","60","100","4"}};

		String[][] pC6 = {{"Chief","Mario","65","120","5"}};



		Village vC1 = new Village("Chief Only 1",1,pC1);

		Village vC2 = new Village("Chief Only 2",1,pC2);

		Village vC3 = new Village("Chief Only 3",1,pC3);

		Village vC4 = new Village("Chief Only 4",1,pC4);

		Village vC5 = new Village("Chief Only 1",1,pC5);

		Village vC6 = new Village("Chief Only 2",1,pC6);



		assertEquals("Salary not calculated correctly",50000,vC1.getChiefSalary());

		assertEquals("Salary not calculated correctly",50000,vC2.getChiefSalary());

		assertEquals("Salary not calculated correctly",50000,vC3.getChiefSalary());

		assertEquals("Salary not calculated correctly",50000,vC4.getChiefSalary());

		assertEquals("Salary not calculated correctly",62500,vC5.getChiefSalary());

		assertEquals("Salary not calculated correctly",75000,vC6.getChiefSalary());



		int[] methods = countMethods();

		assertTrue("You must no create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must no create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must no create more methods in Player",methods[2] == 9);

		assertTrue("You must no create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must no create more methods than 5 in Villager",methods[4] <= 5);

	}



	@Test

	public void testEvent() {

		Village v1 = new Village("Kakariko",4,players1);

		boolean[] expected = {true,true,true, //Party

				false,true,true, //PDMeeting

				false,false,true};//Presidential Reunion

		boolean[] ret1 = v1.event("Party");

		boolean[] ret2 = v1.event("PDMeeting");

		boolean[] ret3 = v1.event("Presidential Reunion");
		
		

		assertEquals("Event not correctly assigned",expected[0],ret1[0]);

		assertEquals("Event not correctly assigned",expected[1],ret1[1]);
		
		assertEquals("Event not correctly assigned",expected[2],ret1[3]);
		
		assertEquals("Event not correctly assigned",expected[3],ret2[0]);
		
		assertEquals("Event not correctly assigned",expected[4],ret2[1]);
		
		assertEquals("Event not correctly assigned",expected[5],ret2[3]);
		
		assertEquals("Event not correctly assigned",expected[6],ret3[0]);
		
		assertEquals("Event not correctly assigned",expected[7],ret3[1]);
		
		assertEquals("Event not correctly assigned",expected[8],ret3[3]);



		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);



	}



	@Test

	public void testDisableAlarm() {

		Village v2 = new Village("Hyrule Plaza",9,players2);

		boolean[] ret = v2.alarm();



		assertFalse("Alarm not correctly assigned",ret[0]);

		assertFalse("Alarm not correctly assigned",ret[1]);

		assertFalse("Alarm not correctly assigned",ret[2]);

		assertFalse("Alarm not correctly assigned",ret[3]);

		assertFalse("Alarm not correctly assigned",ret[4]);

		assertTrue("Alarm not correctly assigned",ret[7]);


		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);

	}



	@Test

	public void testGreetAll() {

		Village v1 = new Village("Kakariko",4,players1);

		Village v2 = new Village("Gerudo's Desert",0,players3);



		String[] ret1 = v1.greetAll();

		String[] ret2 = v2.greetAll();



		assertEquals("Greet incorrect","Hello, I am Alberto and I work at BlackSmithShop.",ret1[0]);

		assertEquals("Greet incorrect","I am Police Elvin at your service.",ret1[1]);

		assertEquals("Greet incorrect","I am Chief Harry.",ret1[2]);

		assertEquals("Greet incorrect","Greetings, I am Bienve, the Mayor of this city.",ret1[3]);

		assertEquals("Must be empty",0,ret2.length);



		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);

	}



	@Test

	public void testComparePlayers() {

		Village v1 = new Village("Kakariko",4,players1);

		Village v4 = new Village("Kakariko",8,players4);



		boolean[] ret1 = v1.comparePlayers();

		boolean[] ret4 = v4.comparePlayers();



		assertFalse("None are equal for v1",ret1[0]);

		assertFalse("None are equal for v1",ret1[1]);

		assertFalse("None are equal for v1",ret1[2]);

		assertFalse("None are equal for v1",ret1[3]);

		assertFalse("Null must returns false",ret1[4]);

		assertTrue("Object is equal to itself",ret1[5]);



		assertTrue("Must return true",ret4[0]);

		assertTrue("Must return true",ret4[1]);

		assertTrue("Must return true",ret4[2]);

		assertTrue("Must return true",ret4[3]);

		assertTrue("Must return true",ret4[4]);

		assertTrue("Must return true",ret4[5]);

		assertTrue("Must return true",ret4[6]);

		assertTrue("Must return true",ret4[7]);

		assertFalse("Null must returns false",ret4[8]);

		assertTrue("Object is equal to itself",ret4[9]);



		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);

	}


	@Test

	public void testCountTypeOfPlayers() {

		Village v1 = new Village("Kakariko",4,players1);

		Village v2 = new Village("Hyrule Plaza",9,players2);



		String[] ret1 = v1.countTypesOfPlayers();

		String[] ret2 = v2.countTypesOfPlayers();



		assertEquals("Not counted properly.","1",ret1[0]);

		assertEquals("Not counted properly.","2",ret1[1]);

		assertEquals("Not counted properly.","1",ret1[2]);

		assertEquals("Not counted properly.","4",ret2[0]);

		assertEquals("Not counted properly.","4",ret2[1]);

		assertEquals("Not counted properly.","1",ret2[2]);



		int[] methods = countMethods();

		assertTrue("You must not create more methods than 6 in Chief",methods[0] <= 6);

		assertTrue("You must not create more methods than 5 in Mayor",methods[1] <= 5);

		assertTrue("You must not create more methods in Player",methods[2] == 9);

		assertTrue("You must not create more methods than 6 in Police",methods[3] <= 6);

		assertTrue("You must not create more methods than 5 in Villager",methods[4] <= 5);

	}

	@Test
	public void testBonus() {
		String[][] players1 = {
				{"Villager","Andres","72","100","BlackSmithShop"},
				{"Police","Jose","60","100","ClerkPlace"},
				{"Chief","Dionel","61","100","5"},
				{"Mayor","Bienve","70","100","10"},
				{"Villager","Rey","60","100","PizzaPlace"},
				{"Villager","Josian","61","100","PizzaPlace"},
				{"Villager","Joshua","62","100","PizzaPlace"},
				{"Villager","Fatima","63","100","PizzaPlace"},
				{"Police","Luz","64","100","Clerk"},
				{"Police","Kevin","65","100","Clerk"},
				{"Police","David","66","100","Clerk"},
				{"Chief","Alejandra","67","100","5"},
				{"Mayor","Fernando","68","100","10"},
				{"Villager","Tato","60","100","PizzaPlace"},
				{"Police","Felipe","64","100","Clerk"},
				{"Mayor","Pedro","68","100","10"},
				{"Chief","Juan","67","100","5"},
				{"Mayor","Tito","68","100","10"},
				{"Police","Rakim","64","100","Clerk"},
				{"Villager","Tato","60","100","PizzaPlace"}
		};

		String[][] players2 = {
				{"Mayor","Bienve","65","100","10"},
				{"Villager","Josian","80","100","PizzaPlace"},
				{"Villager","Joshua","99","100","PizzaPlace"},
				{"Villager","Fatima","71","100","PizzaPlace"},
				{"Police","Luz","69","100","Clerk"},
				{"Villager","Andres","90","100","BlackSmithShop"},
				{"Police","Jose","48","100","ClerkPlace"},
				{"Mayor","Pedro","55","100","10"},
				{"Chief","Juan","64","100","5"},
				{"Chief","Jordan","59","100","5"},//
				{"Villager","Tato","73","100","PizzaPlace"},
				{"Villager","Rey","88","100","PizzaPlace"},
				{"Chief","Dionel","100","100","5"},
				{"Police","Kevin","24","100","Clerk"},
				{"Police","David","18","100","Clerk"},
				{"Chief","Alejandra","34","100","5"},
				{"Mayor","Fernando","29","100","10"},
				{"Villager","Tato","65","100","PizzaPlace"},
				{"Mayor","Michael","45","100","10"},
				{"Police","Rakim","92","100","Clerk"},
				{"Police","Felipe","12","100","Clerk"}
		};

		Village v1 = new Village("Pizza Hut",20, players1);	
		Village v2 = new Village("Cold Stone",21,players2);
		Village v3 = new Village("Bolera",0,null);
		Village v4 = new Village("Victor Pollo",0,new String[0][0]);
		Village v5 = new Village("Don Frappe",10,players2);



		Village.Player[] p1 = v1.tallPlayers();
		Village.Player[] p2 = v2.tallPlayers();
		Village.Player[] p3 = v3.tallPlayers();
		Village.Player[] p4 = v4.tallPlayers();
		Village.Player[] p5 = v5.tallPlayers();

		String[] pF = {},p1A = {"Alejandra", "Juan", "Bienve", "Fernando", "Pedro", "Tito", "Kevin", "David", "Andres"};
		String[] p2A = {"Dionel", "Bienve", "Luz", "Rakim", "Josian", "Joshua", "Fatima", "Andres", "Tato", "Rey", "Tato"};
		String[] p2BA = {"Bienve", "Luz", "Josian", "Joshua", "Fatima", "Andres"};

		assertFalse("There are more players than expected",p2.length == p5.length);
		assertFalse("Returned Null", p4 == null);
		assertArrayEquals("tallPlayers Incorrect",p1A, Village.getAllNames(p1));
		assertArrayEquals("tallPlayers Incorrect",p2A, Village.getAllNames(p2));
		assertArrayEquals("tallPlayers Incorrect", pF, Village.getAllNames(p3));
		assertArrayEquals("tallPlayers Incorrect", pF, Village.getAllNames(p4));
	}


	@SuppressWarnings("rawtypes")

	private int[] countMethods() {

		int[] ret = new int[5];

		try {

			Class c = Class.forName("Village");

			Class cl[] = c.getDeclaredClasses();

			for(int i = 0; i < 5; i++) 

				ret[i] = cl[i].getDeclaredMethods().length;

			for(int i = 0; i < cl.length; i++) {

				if(cl[i].toString().contains("Chief"))ret[0]=cl[i].getDeclaredMethods().length;

				else if(cl[i].toString().contains("Mayor"))ret[1]=cl[i].getDeclaredMethods().length;

				else if(cl[i].toString().contains("Player"))ret[2]=cl[i].getDeclaredMethods().length;

				else if(cl[i].toString().contains("Police"))ret[3]=cl[i].getDeclaredMethods().length;

				else if(cl[i].toString().contains("Villager"))ret[4]=cl[i].getDeclaredMethods().length;

			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}
}