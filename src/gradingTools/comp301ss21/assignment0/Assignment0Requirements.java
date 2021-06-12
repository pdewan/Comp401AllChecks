package gradingTools.comp301ss21.assignment0;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment0Requirements extends AJUnitProjectRequirements {
	public Assignment0Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("05/21/2021 01:00:00", 1.05);
		addDueDate("05/25/2021 01:00:00", 1.0);
		addDueDate("05/26/2021 01:00:00", 0.9);
		addDueDate("02/28/2021 01:00:00", 0.8);
		
		addJUnitTestSuite(SS21Assignment0Suite.class);

	}
}
