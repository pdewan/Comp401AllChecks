package gradingTools.comp301ss21.assignment2;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/04/2021 01:00:00", 1.05);
		addDueDate("06/05/2021 01:00:00", 1.0);
		addDueDate("06/08/2021 01:00:00", 0.9);
		addDueDate("06/10/2021 01:00:00", 0.8);
		
		addJUnitTestSuite(SS21Assignment2Suite.class);

	}
}
