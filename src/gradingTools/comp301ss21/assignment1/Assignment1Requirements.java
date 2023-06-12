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
		addDueDate("06/25/2021 01:00:00", 0.5);
		
		addJUnitTestSuite(SS21Assignment1Suite.class);
		addManualFeature("Elements in animation are properly connected.", 15, false);
     	addManualFeature("Animation shows proper arm rotation", 15, false);     	
     	addManualFeature("Animation shows proper scaling", 15, false);
     	
     	/*
     	 * To demonstrate your work, write a method demonstrateBridgeScene()in the Assignment1 class that instantiates the bridge scene, displays it in an ObjectEditor window, and animates the movement and arm rotation of at least one avatar in the scene (It is sufficient to rotate just one arm). After each rotation, the method should refresh the ObjectEditor window and sleep so that a human can see the result of each assignment. We have seen this animation approach to demoing in class or praxes, and the following code in JavaTeaching illustrates it:  ABMISpreadsheetAnimatingDemoer.java.
Thus, an animation is done by using the refresh and sleep calls. Your main method in Assignment1 should make a call to demonstrateBridgeScene() to execute this method. For fun and preparation for future assignments (but not extra credit), make the avatars march and speak in your animations. 
This part may or may not be graded, and grading it would require your Sakai submission. So make sure you do not forget to submit to Sakai. Even if it is not graded, it will give you good practice in testing your code and if our checks have errors, as they are likely to, you should be able to show this demo to an instructor.
The console will display messages of the form:
 
Since you do not know property announcements, ignore such messages.

     	 */

	}
}
