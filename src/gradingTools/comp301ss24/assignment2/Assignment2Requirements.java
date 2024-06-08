package gradingTools.comp301ss24.assignment2;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;

public class Assignment2Requirements extends AJUnitProjectRequirements {
	public Assignment2Requirements() {
		
		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/04/2024 01:00:00", 1.05);
		addDueDate("06/05/2024 01:00:00", 1.0);
		addDueDate("06/08/2024 01:00:00", 0.9);
		addDueDate("06/10/2024 01:00:00", 0.8);
		addDueDate("06/25/2024 01:00:00", 0.5);
		
		addJUnitTestSuite(SS24Assignment2Suite.class);
     	addManualFeature("Animation shows approach, move, passed, and failed", 20, false);
     	addManualFeature("Boolean properties shown in tree with corect values ", 20, false);

     	/*
     	 * To demonstrate your work, write a main class, named Assignment2, that instantiates the bridge scene, displays it in an ObjectEditor window, and shows each of the scene methods you have implemented working. If you animate the movement of a failed or passed Knight (for fun), the animations will only be visible if you call the scene methods from the main program. In general, the screen will freeze if you call animating code from ObjectEditor. We will see the reason for this later, as well as a solution to this problem. When you display the scene, make sure the two Boolean properties are displayed – either in the tree view or the main panel. You may have to move the dividers between the panels to see the information properly - the TAs will also do this when they view the data. You can use the setSize() method on an OEFrame to adjust its size.
     	 */


	}
}
