import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class RecursionB_s20_Tester {
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void milesTest() {
		assertEquals("Incorrect miles(12345678)", "12,345,678", RecursionB_s20.miles(12345678));
		assertNotEquals("Incorrect miles(12)", ",12", RecursionB_s20.miles(12));
		assertEquals("Incorrect miles(0654321)", "654,321", RecursionB_s20.miles(654321));
		assertNotEquals("Incorrect miles(0654321)", "654,321,", RecursionB_s20.miles(654321));
		assertEquals("Incorrect miles(0)", "0", RecursionB_s20.miles(0));
		// Verify recursive method
		int hugeNumber = 2147483647;
		assertNotEquals("StackOverflowError was expected", "", RecursionB_s20.miles(hugeNumber));
		
	}
	
	
	
	@Test
	public void countVowelsTest() {
		assertEquals("Incorrect countVowels(\"Apple\", 0)", 2, RecursionB_s20.countVowels("Apple",0));
		assertEquals("Incorrect countVowels(\"Ukulele\", 0)", 4, RecursionB_s20.countVowels("Ukulele", 0));
		assertEquals("Incorrect countVowels(\"I\", 0)", 1, RecursionB_s20.countVowels("I", 0));
		
		assertNotEquals("Incorrect countVowels(\"You\", 0)", 0, RecursionB_s20.countVowels("You", 0));
		assertNotEquals("Incorrect countVowels(\"Recinto Universitario de Mayaguez\", 0)", 16, 
				RecursionB_s20.countVowels("Recinto Universitario de Mayaguez", 0));
		assertNotEquals("Incorrect countVowels(\"me\", 0)", 0, RecursionB_s20.countVowels("me", 0));
		
		StringBuilder longText = new StringBuilder("Computer Science and Engineering");
		for (int i = 0; i < 500; i++) {
			longText.append("Computer Science and Engineering");
		}
		// Verify recursive method
        thrown.expect(StackOverflowError.class);
		assertEquals("StackOverflowError was expected", "", RecursionB_s20.countVowels(longText.toString(), 0));
		
	}
	

	
	@Test
	public void findTest() {
		assertEquals("Incorrect find(\"NKRRU\")", "HELLO", RecursionB_s20.find("NKRRU"));
		assertEquals("Incorrect find(\"IURKMOU\")", "COLEGIO", RecursionB_s20.find("IURKMOU"));
		assertNotEquals("Incorrect find(\"IURKMOU\")", "COLEGIO", RecursionB_s20.find("COLEGIO"));
		
		StringBuilder longText = new StringBuilder("ComputerScienceandEngineering");
		for (int i = 0; i < 500; i++) {
			longText.append("ComputerScienceandEngineering");
		}
		// Verify recursive method
        thrown.expect(StackOverflowError.class);
		assertEquals("StackOverflowError was expected", "", RecursionB_s20.find(longText.toString()));
	}


}
