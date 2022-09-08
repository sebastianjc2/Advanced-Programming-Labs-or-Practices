import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecursiveDirectoryTest {

	File root = File.mkdir("/");
	
	RecursiveDirectory.PartialSolution p1;
	RecursiveDirectory.PartialSolution p2;
	RecursiveDirectory.PartialSolution p3;
	
	String Expected1;
	String Expected2;
	String Expected3;
	
	@Before
	public void setUp() {		
		File home = root.addChild(File.mkdir("/home"));
		File usr = root.addChild(File.mkdir("/usr"));
		File lib = root.addChild(File.mkdir("/lib"));
		File etc = root.addChild(File.mkdir("/etc"));
		
		home.addChild(new File("/home/filex", "rinconBeach"));
		home.addChild(new File("/home/filey", "noelia"));
		home.addChild(new File("/home/filez", "eleternoresplandor"));
		
		usr.addChild(new File("/usr/configx", "XTerm*background:#222D31"));
		usr.addChild(new File("/usr/configy", "alias egrep='egrep --colour=auto'"));
		usr.addChild(new File("/usr/configz", "XDG_DOWNLOAD_DIR=\"$HOME/Downloads\""));
		
		lib.addChild(new File("/lib/libx", "MODULES=java.base java.compiler java.datatransfer java.xml java.prefs java.desktop"));
		lib.addChild(new File("/lib/liby", "Based on prior profile module by Sjoerd Mullender...  which was hacked somewhat by: Guido van Rossum"));
		lib.addChild(new File("/lib/libx", "REQUIREMENTS: dict client software an address of a dict server, for variable ${DICT_SERVER}"));
		
		etc.addChild(new File("/etc/configx", "<!--\n" + 
				"  Associate a color name with its red, green, blue, and alpha intensities.\n" + 
				"\n" + 
				"  A number of methods and options require a color parameter. It is often\n" + 
				"  convenient to refer to a color by name (e.g. white) rather than by hex\n" + 
				"  value (e.g. #fff). This file maps a color name to its equivalent red,\n" + 
				"  green, blue, and alpha intensities (e.g. for white, red = 255, green =\n" + 
				"  255, blue = 255, and alpha = 0).\n" + 
				"-->"));
		etc.addChild(new File("/etc/configy", "# REPOSITORIES " + 
				"#   - can be defined here or included from another file " + 
				"#   - pacman will search repositories in the order defined here " + 
				"#   - local/custom mirrors can be added here or in separate files " + 
				"#   - repositories listed first will take precedence when packages " + 
				"#     have identical names, regardless of version number " + 
				"#   - URLs will have $repo replaced by the name of the current repo " + 
				"#   - URLs will have $arch replaced by the name of the architecture"));
		etc.addChild(new File("/etc/configz", "America/Puerto_Rico"));
		
		Expected1 = "/home/filey : noelia";
		Expected2 = "/lib/libx : MODULES=java.base java.compiler java.datatransfer java.xml java.prefs java.desktop";
		Expected3 = "/etc/configy : # REPOSITORIES #   - can be defined here or included from another file #   - pacman will search repositories in the order defined here #   - local/custom mirrors can be added here or in separate files #   - repositories listed first will take precedence when packages #     have identical names, regardless of version number #   - URLs will have $repo replaced by the name of the current repo #   - URLs will have $arch replaced by the name of the architecture";
		
		p1 = new RecursiveDirectory.PartialSolution(root, "(.*)noe(.*)", "");
		p2 = new RecursiveDirectory.PartialSolution(root, "(.*)compiler(.*)", "");
		p3 = new RecursiveDirectory.PartialSolution(root, "(.*)REPOSITORIES(.*)", "");
		
		RecursiveDirectory.PartialSolution.solve(p1);
		RecursiveDirectory.PartialSolution.solve(p2);
		RecursiveDirectory.PartialSolution.solve(p3);
	}
	
	@Test
	public void testSolution() {
		assertEquals(Expected1, p1.matches.replaceAll("\n", ""));
		assertEquals(Expected2, p2.matches.replaceAll("\n", ""));
		assertEquals(Expected3, p3.matches.replaceAll("\n", ""));
	}
}
