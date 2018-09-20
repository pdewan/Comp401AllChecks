package gradingTools.comp401f18.assignment4;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f17.assignment4.testcases.Assignment4Suite;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleEditablePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStylePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleVariableHasClassTypeTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleConstructorDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;

public class Assignment4Requirements extends AJUnitProjectRequirements {
	public Assignment4Requirements() {
		addDueDate("09/20/2018 00:59:00", 1.05); 	// wed before + 1hr
     	addDueDate("09/26/2018 00:59:00", 1); 		// tue due + 1hr
     	addDueDate("09/29/2018 00:59:00", 0.9);		// fri after due + 1hr
     	addDueDate("10/03/2018 00:59:00", 0.75); 	// tue after due + 1hr
     	addDueDate("10/03/2018 00:59:01", 0); 	// tue after due + 1hr
//		addDueDate("12/07/2017 03:00:00", 1);

		// Functionality
		GradingMode.setGraderRun(true);
		addJUnitTestSuite(Assignment4Suite.class);

		addFeature("Public methods are in implemented interfaces", 10, new ClassHasAtLeastOneInterfaceTestCase());

		addRestriction("Variables should have interface, not class, type", 10,
				new CheckStyleVariableHasClassTypeTestCase());

		// Classes for command tokens instantiated
		addFeature("Required command token classes instantiated", 12,
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Move"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Say"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Repeat"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Approach"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Pass"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Fail"));

		// Constructors defined for command tokens
		addFeature("Single parameter constructors defined for command tokens", 6,
				new CheckstyleConstructorDefinedTestCase("Move", ":String"),
				new CheckstyleConstructorDefinedTestCase("Say", ":String"),
				new CheckstyleConstructorDefinedTestCase("Repeat", ":String"),
				new CheckstyleConstructorDefinedTestCase("Approach", ":String"),
				new CheckstyleConstructorDefinedTestCase("Pass", ":String"),
				new CheckstyleConstructorDefinedTestCase("Fail", ":String"));

		// Properties defined
		addFeature("Properties defined for command token classes", 18,
				// Setters
				new CheckStyleEditablePropertyDefinedTestCase("Move", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Say", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Repeat", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Approach", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Pass", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Fail", "Input", "String"),

				// Getters
				new CheckStylePropertyDefinedTestCase("Move", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Say", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Repeat", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Approach", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Pass", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Fail", "Input", "String"),

				// Non Editable properties (getters)
				new CheckStylePropertyDefinedTestCase("Move", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Say", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Repeat", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Approach", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Pass", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Fail", "Value", "String")

		);

		// New ScannerBean property
		addFeature("ScannerBean has Tokens property", 15,
				new CheckStylePropertyDefinedTestCase("ScannerBean", "Tokens", ".*\\[.*\\]"));

		// method calls
		addFeature("Sleep called in animation", 4,
				new CheckstyleMethodCalledTestCase("main.Assignment4", "ThreadSupport!sleep:long->void"));

		// Scanner extra credit property
		addFeature("ScannerBean has Errors property", 5, true,
				new CheckStylePropertyDefinedTestCase("ScannerBean", "Errors", "*"));

		// Extra credit command classes
		addFeature("Extra credit command classes instantiated", 5, true,
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "RotateLeftArm"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "RotateRightArm"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Define"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Call"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Thread"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Wait"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "ProceedAll"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Sleep"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Undo"),
				new CheckstyleClassInstantiatedTestCase("ScannerBean", "Redo"));

		addFeature("Extra credit constructors and properties defined", 10, true,
				new CheckstyleConstructorDefinedTestCase("RotateLeftArm", ":String"),
				new CheckstyleConstructorDefinedTestCase("RotateRightArm", ":String"),
				new CheckstyleConstructorDefinedTestCase("Define", ":String"),
				new CheckstyleConstructorDefinedTestCase("Call", ":String"),
				new CheckstyleConstructorDefinedTestCase("Thread", ":String"),
				new CheckstyleConstructorDefinedTestCase("Wait", ":String"),
				new CheckstyleConstructorDefinedTestCase("ProceedAll", ":String"),
				new CheckstyleConstructorDefinedTestCase("Sleep", ":String"),
				new CheckstyleConstructorDefinedTestCase("Undo", ":String"),
				new CheckstyleConstructorDefinedTestCase("Redo", ":String"),

				// Setters
				new CheckStyleEditablePropertyDefinedTestCase("RotateLeftArm", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("RotateRightArm", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Define", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Call", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Thread", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Wait", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("ProceedAll", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Sleep", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Undo", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Redo", "Input", "String"),

				// Getters
				new CheckStylePropertyDefinedTestCase("RotateLeftArm", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("RotateRightArm", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Define", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Call", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Thread", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Wait", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("ProceedAll", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Sleep", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Undo", "Input", "String"),
				new CheckStylePropertyDefinedTestCase("Redo", "Input", "String"),

				// Non Editable properties (getters)
				new CheckStylePropertyDefinedTestCase("RotateLeftArm", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("RotateRightArm", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Define", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Call", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Thread", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Wait", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("ProceedAll", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Sleep", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Undo", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Redo", "Value", "String"));

		// Rotating line
		addFeature("RotatingLine has required properties and methods, and rotate is called in animation", 16, true,
				new CheckstyleMethodDefinedTestCase("RotatingLine", "@rotate:int->*"),

				// checkstyle xml had these as methods, not properties
				new CheckstyleMethodDefinedTestCase("RotatingLine", "setAngle:double->void"),
				new CheckstyleMethodDefinedTestCase("RotatingLine", "setRadius:double->void"),

				new CheckstyleMethodCalledTestCase("main.Assignment4", "@RotatingLine!@rotate:int->*"));

		addManualFeature("ScannerBean properly animated", 15, false);
		addManualFeature("RotatingLine properly animated", 10, true);

		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

		addManualRestriction(INTERACTIVE_RUN, 5, new NoWarningOrErrorTestCase("OE Warnings",
				".*(efresh|not in range).*", ".*Assuming implicit pattern.*", 0.3));

	}// end method
}
