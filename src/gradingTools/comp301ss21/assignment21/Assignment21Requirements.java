package gradingTools.comp301ss21.assignment21;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp301ss21.assignment1_1.SS21Assignment1_1Suite;
import gradingTools.comp301ss21.assignment2_1.SS21Assignment2_1Suite;

public class Assignment21Requirements extends AJUnitProjectRequirements {
	public Assignment21Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/24/2021 01:00:00", 1.00);
		
		
		addJUnitTestSuite(SS21Assignment2_1Suite.class);

	}
}
