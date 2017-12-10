package gradingTools;

public class Comp401Driver {
	public static void main (String[] args) {
		Driver.main(args);
		for(String s : args) {
			if (s.matches("-.*?[hH][eE][aA][dD][lL][eE][sS]{2}.*")) { // any variety of -.*headless.* with any capitalization
				System.exit(0);
			}
		}
	}
}
