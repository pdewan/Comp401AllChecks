package gradingTools.comp301ss21.assignment4;

import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;

public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {

		GraderTraceUtility.setTurnOn(true);
		GraderTraceUtility.setTracing();
		addDueDate("06/22/2021 01:00:00", 1.0);
		addDueDate("06/24/2021 01:00:00", 0.95);

		addJUnitTestSuite(SS21Assignment4Suite.class);
		
		addManualFeature("Scene Controller buttons activate and deactivate properly in animation", 15, false);
     	addManualFeature("Clicking and pressing buttons in display works correctly", 15);
     	
     	addManualFeature("Impossible angle exception demonstrated", 15);
     	
		addManualFeature("Animation shows different animators animating concurrently.", 15, false); 
	   	addManualFeature("Animation shows same avatar animating sequentially", 15, false); 
		addManualFeature("4 animations wait until press of proceedAll", 15, false);
     	addManualFeature("Lockstep animations work", 15, false);

		// Manual, EC: buttons deactivated properly, work

		// Manual, EC: clap animation

//		addManualRestriction(INTERACTIVE_RUN, 5,
//				new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));

		/*
		 * To demonstrate your work, add on to the main class that you implemented in Part 1 by adding code that makes the legs of at least one avatar move to an impossible angle, catches the exception, 
		 * and prints the stack trace in response to the caught exception.
		 * 
		 * Executes code of your choosing to change the preconditions of each of the four asserting methods in the scene object. For example, it executes the approach method to change the (value returned by the) precondition of the say method, and the say method to change the precondition of the pass method. The executed code should allow the TAs to observe the effect of the code on both the scene views and see that the correct precondition events are fired. In addition, your console scene view should print these events.
		 *4.	Demonstrates the new versions of the asynchronous methods. You should make two calls to (a) different asynchronous animation methods (animating different avatars) and (b) the same asynchronous method (animating the same avatar).  Thus, you should make three calls that, for instance, animate Galahad once and Lancelot twice.  The result should be that two animations of different avatars should execute concurrently (e.g. Galahad and Lancelot) and after one of these completes (e.g. Lancelot), it should immediately start again.
5.	Demonstrates the lockstep methods. Do so by starting the lockstep methods for the avatars and then the lockstep method for the guard. Do this step before demonstrating the waiting methods.
6.	Demonstrates the waiting methods. Your program should start all four waiting methods and the TAs will press the button in the clearance manager to start the corresponding animations.

		 */
	}
}
