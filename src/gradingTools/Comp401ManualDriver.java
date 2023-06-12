package gradingTools;

import grader.basics.execution.GradingMode;

public class Comp401ManualDriver {
	public static void main (String[] args) {
//		GradingMode.setManualGradingOnly(true);
		Driver.main(args);
		for(String s : args) {
			if (s.matches("-.*?[hH][eE][aA][dD][lL][eE][sS]{2}.*")) { // any variety of -.*headless.* with any capitalization
				System.exit(0);
			}
		}
	}
}
