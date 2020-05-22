import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static final String ANSI_RESET  = "\u001B[0m";
	public static final String ANSI_BG_YELLOW = "\u001B[43m";	

	public static void main(String[] args) {
		String text = ">Toma, pues, una línea que esté cortada en dos segmentos desiguales y vuelve a \n"
				+ "cortar cada uno de los segmentos, el del género visible y el del inteligible, siguiendo \n"
				+ "la misma proporción. Entonces tendrás, clasificados según la mayor claridad u oscuridad \n"
				+ "de cada uno: en el mundo visible, un primer segmento, el de las imágenes. Llamo imágenes \n"
				+ "ante todo a las sombras, y en segundo lugar, a las figuras que se forman \n"
				+ "en el agua y en todo lo que es compacto, pulido y brillante, y a otras cosas semejantes, \n"
				+ "si es que me entiendes.\n"
				+ ">Sí que te entiendo.\n"
				+ ">En el segundo pon aquello de lo cual esto es imagen: los animales que nos rodean, todas \n"
				+ "las plantas y el género entero de las cosas fabricadas.";
		/*
		 * Tells whether or not this string matches the given regular expression. 
		 * True if, and only if, this string matches the given regular expression,
		 * which means if the text contains the phrase "el mundo visible".
		*/
		System.out.println(text.matches("(?s).*[el mundo visible].*"));
		/*
		 * Replace all words that start with Upper case, with FOUND string
		*/
		System.out.println(text.replaceAll("([A-Z][a-zÀ-ÿ]*)", "FOUND"));
		
		/*
		 * Or highlight every word start with Upper case
		 * ANSI interpreter is required (ANSI Escape in Console in Eclipse)
		 */
		String textHighlight = replace(text, Pattern.compile("([A-Z][a-zÀ-ÿ]*)"), m -> (ANSI_BG_YELLOW + m.group() + ANSI_RESET));
		System.out.println(textHighlight);
	}
	

    public static String replace(String input, Pattern regex, Function<Matcher, String> callback) {
        StringBuffer resultString = new StringBuffer();
        Matcher regexMatcher = regex.matcher(input);
        while (regexMatcher.find()) {
            regexMatcher.appendReplacement(resultString, callback.apply(regexMatcher));
        }
        regexMatcher.appendTail(resultString);

        return resultString.toString();
    }

}
