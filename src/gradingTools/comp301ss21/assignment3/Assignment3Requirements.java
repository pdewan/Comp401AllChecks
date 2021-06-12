package gradingTools.comp301ss21.assignment3;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment3Requirements extends AJUnitProjectRequirements {
	public Assignment3Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/11/2021 01:00:00", 1.05);
		addDueDate("06/12/2021 01:00:00", 1.0);
		addDueDate("06/16/2021 01:00:00", 0.9);
		addDueDate("06/18/2021 01:00:00", 0.8);
		
		addJUnitTestSuite(SS21Assignment3Suite.class);

	}
}
