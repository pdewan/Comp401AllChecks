package gradingTools.comp401f18.assignment8;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f17.assignment8.testcases.Assignment8Suite;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleClassDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleEditablePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleMagicNumberTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStylePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleVariableHasClassTypeTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleConstructorDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstylePatternBasedSuperTypeDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleSuperTypeDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;

public class Assignment8Requirements extends AJUnitProjectRequirements {
	public Assignment8Requirements() {
		addDueDate("10/25/2018 00:59:00", 1.05); 	// wed before + 1hr
     	addDueDate("11/14/2018 00:59:00", 1); 		// tue due + 1hr
     	addDueDate("11/17/2018 00:59:00", 0.9);		// fri after due + 1hr
     	addDueDate("11/21/2018 00:59:00", 0.75); 	// tue after due + 1hr
     	addDueDate("11/21/2018 00:59:01", 0); 	// tue after due + 1hr
//		addDueDate("12/07/2017 03:00:00", 1);

		// Functionality
		GradingMode.setGraderRun(true);

		addJUnitTestSuite(Assignment8Suite.class);

		addFeature("Public methods are in implemented interfaces", 10, new ClassHasAtLeastOneInterfaceTestCase());

		addRestriction("Variables should have interface, not class, type", 10,
				new CheckStyleVariableHasClassTypeTestCase());

		addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());

		// SingletonCreator
		addFeature("Observables send events, observer registers and listens", 9,

				// Should we be looking for instantiations of PropertyChangeEvent instead?
				new CheckstyleClassInstantiatedTestCase("Locatable", "PropertyChangeEvent"),
				new CheckstyleClassInstantiatedTestCase("BoundedShape", "PropertyChangeEvent"),
				new CheckstyleMethodCalledTestCase("ConsoleSceneView",
						"(.*)!addPropertyChangeListener:PropertyChangeListener->void")
		// Can't check to calls to propertyChange because many students will put it in
		// "listenerSupport"
		);

		addFeature("ConsoleSceneView created and used with SingletonCreator", 9,
				new CheckstyleMethodCalledTestCase("ConsoleSceneView",
						"@SingletonsCreator!@bridgeSceneFactoryMethod:->@BridgeScene"),
				new CheckstyleMethodDefinedTestCase("SingletonsCreator",
						"@consoleSceneViewFactoryMethod:->@ConsoleSceneView"),
				new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "ConsoleSceneView"));

		// Command interpreter
		addFeature("Proper interfaces implemented", 9,
				new CheckstyleInterfaceDefinedTestCase("ConsoleSceneView", "PropertyChangeListener"),
				new CheckstyleInterfaceDefinedTestCase("Locatable", " PropertyListenerRegisterer"),
				new CheckstyleInterfaceDefinedTestCase("BoundedShape", " PropertyListenerRegisterer"));

		addFeature("Main calls proper methods", 10, new CheckstyleMethodCalledTestCase("main.Assignment8",
				"@SingletonsCreator!consoleSceneViewFactoryMethod:->@ConsoleSceneView"),
//     			new CheckstyleMethodCalledTestCase("main.Assignment8", "@SingletonsCreator!bridgeSceneFactoryMethod:->@BridgeScene"), 
				new CheckstyleMethodCalledTestCase("main.Assignment8", "(.*)!sleep:long->void"),
//     			new CheckstyleMethodCalledTestCase("main.Assignment8", "(.*)!@move:int;int->*"),
				new CheckstyleMethodCalledTestCase("main.Assignment8", "(.*)!setText:String->void"));

		addFeature("Rotate method called", 3, true,
				new CheckstyleMethodCalledTestCase("main.Assignment8", "@RotatingLine!@rotate:int->*"));

		addManualFeature("Console shows proper events being fired", 15, false);
		addManualFeature("Animation shows correct behavior", 5, false);

		addManualRestriction(INTERACTIVE_RUN, 5,
				new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));

		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

	}// end method
}
