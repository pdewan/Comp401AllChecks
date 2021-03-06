package gradingTools.comp401f18.assignment5;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f17.assignment5.testcases.Assignment5Suite;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;
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
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;
import trace.gradingTools.comp401.Comp401TraceUtility;

public class Assignment5Requirements extends AJUnitProjectRequirements {
	public Assignment5Requirements() {
		addDueDate("09/27/2018 00:59:00", 1.05); 	// wed before + 1hr
     	addDueDate("10/06/2018 00:59:00", 1); 		// fri due + 1hr
     	addDueDate("10/10/2018 00:59:00", 0.9);		// tue after due + 1hr
     	addDueDate("10/13/2018 00:59:00", 0.75); 	// fri after due + 1hr
     	addDueDate("10/13/2018 00:59:01", 0); 	// fri after due + 1hr
//		addDueDate("12/07/2017 03:00:00", 1);

		// Functionality
		GradingMode.setGraderRun(true);
		GraderTraceUtility.setTracing();
		Comp401TraceUtility.setTracing();
		addJUnitTestSuite(Assignment5Suite.class);

		addFeature("Public methods are in implemented interfaces", 10, new ClassHasAtLeastOneInterfaceTestCase());

		addRestriction("Variables should have interface, not class, type", 10,
				new CheckStyleVariableHasClassTypeTestCase());

		addRestriction("No magic numbers", 5, new CheckStyleMagicNumberTestCase());

		// Method signatures
		addFeature("Move methods defined in Angle and Avatar", 10,
				new CheckstyleMethodDefinedTestCase("Angle", "@move:int;int->void"),
				new CheckstyleMethodDefinedTestCase("Avatar", "@move:int;int->void"));

		// Method calls
		addFeature("Sleep called in animation", 2,
				new CheckstyleMethodCalledTestCase("main.Assignment5", "ThreadSupport!sleep:long->void"));

		// Extra credit methods
		addFeature("Scale method defined in avatar", 10,
				new CheckstyleMethodDefinedTestCase("Avatar", "scale:double->void"));

		// Class instantiation
		addFeature("Proper classes instantiated within each other", 6,
				new CheckstyleClassInstantiatedTestCase("main.Assignment5", "BridgeScene"),
				new CheckstyleClassInstantiatedTestCase("BridgeScene", "Avatar"),
				new CheckstyleClassInstantiatedTestCase("Avatar", "Angle"));

		// Constructors
		addFeature("Required constructors defined for graphical classes", 9,
				new CheckstyleConstructorDefinedTestCase("Angle", ":"),
				new CheckstyleConstructorDefinedTestCase("Avatar", ":@IMAGE_PATTERN"),
				new CheckstyleConstructorDefinedTestCase("BridgeScene", ":"));

		// Properties defined
		addFeature("Graphical classes have proper properties defined", 33,

				// Angle
				new CheckStylePropertyDefinedTestCase("Angle", "LeftLine", "@LINE_PATTERN"),
				new CheckStylePropertyDefinedTestCase("Angle", "RightLine", "@LINE_PATTERN"),

				// Avatar
				new CheckStylePropertyDefinedTestCase("Avatar", "Text", "@STRING_PATTERN"),
				new CheckStylePropertyDefinedTestCase("Avatar", "Head", "@IMAGE_PATTERN"),
				new CheckStylePropertyDefinedTestCase("Avatar", "Arms", "@Angle"),
				new CheckStylePropertyDefinedTestCase("Avatar", "Legs", "@Angle"),

				// BridgeScene
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Arthur", "@Avatar"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Galahad", "@Avatar"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Lancelot", "@Avatar"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Robin", "@Avatar"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Guard", "@Avatar")

		);

		addManualFeature("Elements in animation are properly connected.", 10, false);
		addManualFeature("Animation shows proper use of move function.", 10, false);

		addManualFeature("Animation shows proper scaling", 7, true);
		addManualFeature("Animation shows proper arm rotation", 8, true);

		addManualRestriction(INTERACTIVE_RUN, 5,
				new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));

		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

	}// end method
}
