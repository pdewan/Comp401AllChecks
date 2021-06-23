package gradingTools.comp301ss21.assignment11;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp301ss21.assignment1_1.SS21Assignment1_1Suite;

public class Assignment11Requirements extends AJUnitProjectRequirements {
	public Assignment11Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/22/2021 01:00:00", 1.0);
		addDueDate("06/24/2021 01:00:00", 0.95);
		
		
		addJUnitTestSuite(SS21Assignment1_1Suite.class);

	}
}
