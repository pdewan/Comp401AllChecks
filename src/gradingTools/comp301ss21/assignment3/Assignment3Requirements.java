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
     	addManualFeature("Manual Frame with Manual View Displayed", 15);
     	addManualFeature("Mouse and Key Buttons Displayed", 15);	
     	addManualFeature("Animation with move, say, move ", 15);	
     	addManualFeature("Table Demo", 15);

		
		addJUnitTestSuite(SS21Assignment3Suite.class);
		/*
		 * 1.	Accesses the scene object (using the associated factory method).
2.	Displays it using your inheriting or observing view object depending on whether you did part 1a and 1b.
2.3.	Instantiates a frame object, adds the view to it. and sets the frame visible, No other class should instantiate a frame, which does not make logical sense and also will cause tests on the server  to fail as it cannot create a frame object.
3.4.	Calls the controller factory method to make the display interactive.
4.5.	Displays the scene using ObjectEditor.
5.6.	Creates an animation that moves an avatar, sets its text, and moves the avatar.
6.7.	Do not leave the Knight area occupied at the end of the animation if you are doing the Observable paint listener extra credit, as our test makes Arthur approach, and relies on the method executing successfully.
7.8.	Demo the table. In your main method (either before or after your animation code), put different (key, value) pairs into the table, print each pair on the console with messages indicating the key and value parts. Then for each key put, get the value and print out the key value pair. Be sure to show insertion and replacement of keys. The TAs will see if your code is consistent with the output. Since your table should support the use of generics, you should instantiate and demo two different tables – one with strings as the value and another with Avatars as the value.

		 */

	}
}
