// Remember to add your name and repo name below
// Name: Caballero Diaz, Sebastian J.
// GitHub Classroom Repository: https://github.com/uprm-ciic4010-s20/ex-final-b-sebastianjc2

public class RecursionB_s20 {

	/* EXERCISE #1
	 * Given an integer number, return a String formatted in thousands, with commas.
	 * For example, if given 1234567, the output should be "1,234,567"
	 * 
	 * IMPORTANT: See tests for more examples of how this method should work.
	 * 
	 * NOTE:YOUR METHOD MUST BE RECURSIVE
	 */
	public static String miles(int n) {
		// TODO EX #1 - miles
		// ADD YOUR CODE HERE
		String num = Integer.toString(n);
		if(num.length()<4) return num;
		
		return miles(n%1000) + "," ; //dummy return
	}


	/* EXERCISE #2
	 * Given an string, return the number of vowels "a e i o u A E I O U" in the string.
	 * 
	 * HINT: Use String methods
	 * IMPORTANT: See tests for examples of how this method should work.
	 * NOTE:YOUR METHOD MUST BE RECURSIVE
	 */
	public static int countVowels(String a, int i) {
		// TODO EX #2 - countVowels
		// ADD YOUR CODE HERE
		String vowels="aeiou";
		if(a==null || a.length()==0) return 0;
		if(vowels.contains(a.substring(0,1).toLowerCase())) {
			return 1+countVowels(a.substring(1), i);
		}
		return 0+countVowels(a.substring(1), i);
	}


	/* EXERCISE #3
	 * Given a "hidden" message, de-code the string to read the message.
	 * Assume hidden messages are in all caps
	 * Use the following <<expression>> to un-code the letters
	 * char uncoded = (char)((msg.charAt(0) + 7) % 26 + 65);
	 * for example: the value of I is 78, and convert to H, value of 72
	 * 
	 * HINT: Casting may be needed.
	 * IMPORTANT: See tests for more examples of how this method should work.
	 * NOTE:YOUR METHOD MUST BE RECURSIVE
	 * 
	 */
	public static String find(String msg) {
		// TODO EX #3 - find
		// ADD YOUR CODE HERE
		String newM= "";
		String letter = msg.substring(0,1);
		if(msg.length()==0)return null;
		char uncoded = (char)((letter.charAt(0) + 7) % 26 + 65);
		newM = newM + uncoded;
		return find(newM.substring(0,1)); //dummy return
	}	

}
