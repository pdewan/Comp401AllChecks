package gradingTools.comp301ss21.assignment1;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment1Requirements extends AJUnitProjectRequirements {
	public Assignment1Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("05/28/2021 01:00:00", 1.05);
		addDueDate("05/29/2021 01:00:00", 1.0);
		addDueDate("06/02/2021 01:00:00", 0.9);
		addDueDate("06/03/2021 01:00:00", 0.8);
		
		addJUnitTestSuite(SS21Assignment1Suite.class);

	}
}
