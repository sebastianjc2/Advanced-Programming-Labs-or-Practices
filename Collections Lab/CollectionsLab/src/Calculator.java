// Name: LastNames, First Name
// GitHub Classroom Repository:

import java.util.Stack;

public class Calculator {

	/**
	 * EXERCISE C & D
	 * 
	 * The "tokens" array contains every number and operator in the expression as a single token.
	 * @See String class to see how the split method works.
	 * 
	 * Specific instructions for exercises C and D are in moodle.
	 * TODO
	 */

	public static String calculate(String expression) {

		Stack<Double> stack = new Stack<>();
		if (expression == null || expression.isEmpty()) return "0.0";
	
		
		String[] tokens = expression.split(" ");
		
		if(tokens.length<3) return "INVALID";

		for (int i = 0; i < tokens.length; i++) {
			
			if(isAnOperator(tokens[i])) {
				stack.add(partialCalculation(stack.pop(), tokens[i], stack.pop()));
			}
			else {
				double num = Double.valueOf(tokens[i]);
				stack.add(num);
			}
			
		}

		if(stack.size()==1) return stack.toString(); // Dummy return
		return "0.0";

	}

	/**
	 * 
	 * Possible operators -> { "+" , "-" , "*" , "/"}
	 * Assume there is no division by zero.
	 * 
	 * TODO
	 * 
	 * HINT: Use Switch or if-else statement
	 */
	private static Double partialCalculation(Double operand1, String operator, Double operand2) {

		if(operator.equals("+")) return operand1+operand2;
		else if(operator.equals("-")) return operand2-operand1;
		else if(operator.equals("*")) return operand1*operand2;
		else if(operator.equals("/")) return operand2/operand1;
			
		return 0.0; // Dummy Return

	}


	/**
	 * Possible operators -> { "+" , "-" , "*" , "/"}
	 * TODO
	 * 
	 * HINT: Given token have to be one of the possible operators.
	 */

	private static boolean isAnOperator(String token) {

		return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")); // Dummy Return
	}

}
