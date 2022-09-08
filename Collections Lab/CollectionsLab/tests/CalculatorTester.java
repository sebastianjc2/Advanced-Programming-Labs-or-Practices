import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTester {

	@Test
	public void testCalculate() {

		String[] equations = {"2 3 / 3 2 / *","13.5 6.5 + 2 *","",null,"2 4 + -","* 3 4","2.7 12"},

				expected = {"1.0","40.0","0.0","0.0","INVALID","INVALID","INVALID"};

		for (int i = 0; i < equations.length; i++)
			assertEquals("Incorrect Result: ->",expected[i], Calculator.calculate(equations[i]));

	}

	@Test
	public void testNewOperator() {
		
		String[] equations = {
				"4.5 1.2 / ^ 1 1 +",null,"2 2 ^ 0.5 ^","3.5 2 * / 9 1 ^","^",
				"2 2 ^ 0.5 ^".substring(0, 5).concat("                                                             "),
				"1 ^ 2","2 -1 ^",
				Double.MAX_VALUE + "".concat(" ".concat(Double.MIN_VALUE + "".concat(" ").concat("-").concat(" 1 ^")))
		},
				expected = {"INVALID", "0.0", "2.0", "INVALID", "INVALID","4.0", "INVALID","0.5", "1.7976931348623157E308"};

		for (int i = 0; i < equations.length; i++) 
			assertEquals("Incorrect Result: ->",expected[i], Calculator.calculate(equations[i]));

	}

}
