package gradingTools.comp301ss21.assignment4;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/22/2021 01:00:00", 1.0);
		addDueDate("06/24/2021 01:00:00", 0.95);
		
		
		addJUnitTestSuite(SS21Assignment4Suite.class);

	}
}
