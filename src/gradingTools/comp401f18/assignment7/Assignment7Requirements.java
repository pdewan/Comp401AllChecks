package gradingTools.comp401f18.assignment7;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f17.assignment7.testcases.Assignment7Suite;
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
import trace.gradingTools.comp401.Comp401TraceUtility;

public class Assignment7Requirements extends AJUnitProjectRequirements {
	public Assignment7Requirements() {
		addDueDate("10/11/2018 00:59:00", 1.05); 	// wed before + 1hr
     	addDueDate("11/03/2018 00:59:00", 1); 		// fri due + 1hr
     	addDueDate("11/07/2018 00:59:00", 0.9);		// mon after due + 1hr
     	addDueDate("11/10/2018 00:59:00", 0.75); 	// fri after due + 1hr
     	addDueDate("11/10/2018 00:59:01", 0); 	// fri after due + 1hr
//		addDueDate("12/07/2017 03:00:00", 1);

		GraderTraceUtility.setTracing();
		Comp401TraceUtility.setTracing();
		// Functionality
		GradingMode.setGraderRun(true);

		addJUnitTestSuite(Assignment7Suite.class);

		addFeature("Public methods are in implemented interfaces", 10, new ClassHasAtLeastOneInterfaceTestCase());

		addRestriction("Variables should have interface, not class, type", 10,
				new CheckStyleVariableHasClassTypeTestCase());

		addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
		addFeature("Graphics supertypes defined", 16,
//     			new CheckStyleClassDefinedTestCase("Locatable"),	// test currently doesn't work, maybe not necessary
				new CheckStylePropertyDefinedTestCase("Locatable", "X", "int"),
				new CheckStylePropertyDefinedTestCase("Locatable", "Y", "int"),
				new CheckStyleEditablePropertyDefinedTestCase("Locatable", "X", "int"),
				new CheckStyleEditablePropertyDefinedTestCase("Locatable", "Y", "int"),

////     			new CheckStyleClassDefinedTestCase("BoundedShape"),
//     			new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 2),
//     			new CheckstylePatternBasedSuperTypeDefinedTestCase("BoundedShape", 2),

//     			new CheckstyleSuperTypeDefinedTestCase("BoundedShape", "Locatable"),
				new CheckStylePropertyDefinedTestCase("BoundedShape", "Width", "int"),
				new CheckStylePropertyDefinedTestCase("BoundedShape", "Height", "int"),
				new CheckStyleEditablePropertyDefinedTestCase("BoundedShape", "Width", "int"),
				new CheckStyleEditablePropertyDefinedTestCase("BoundedShape", "Height", "int")

//     			new CheckstyleSuperTypeDefinedTestCase("@LINE_PATTERN", "Locatable"),
//     			new CheckstyleSuperTypeDefinedTestCase("@STRING_PATTERN", "Locatable"),
//     			new CheckstyleSuperTypeDefinedTestCase("@IMAGE_PATTERN", "BoundedShape")
		);
		addFeature("Locatable subtypes defined", 12, // 6 or 3 cases depending on if we count interfaces
////     			
				new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 1.0 / 6.0)
//     			
//     			new CheckstyleSuperTypeDefinedTestCase("BoundedShape", "Locatable"),
//     			
//     			new CheckstyleSuperTypeDefinedTestCase("@LINE_PATTERN", "Locatable"),
//     			new CheckstyleSuperTypeDefinedTestCase("@STRING_PATTERN", "Locatable"),
		);
		addFeature("BoundedShape subtypes defined", 4, // 1 or 2 cases
//// 			
// 			new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 1.0/6.0)
				new CheckstylePatternBasedSuperTypeDefinedTestCase("BoundedShape", 1.0 / 2.0)
// 			new CheckstyleSuperTypeDefinedTestCase("@IMAGE_PATTERN", "BoundedShape")
		);
//     	addFeature("Graphics inheritance hierarchy", 24,
////     			new CheckStyleClassDefinedTestCase("Locatable"),	// test currently doesn't work, maybe not necessary
//     			new CheckStylePropertyDefinedTestCase("Locatable", "X", "int"),
//     			new CheckStylePropertyDefinedTestCase("Locatable", "Y", "int"),
//     			new CheckStyleEditablePropertyDefinedTestCase("Locatable", "X", "int"),
//     			new CheckStyleEditablePropertyDefinedTestCase("Locatable", "Y", "int"),
//     			
////     			new CheckStyleClassDefinedTestCase("BoundedShape"),
//     			new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 2),
//     			new CheckstylePatternBasedSuperTypeDefinedTestCase("BoundedShape", 2),
//
////     			new CheckstyleSuperTypeDefinedTestCase("BoundedShape", "Locatable"),
//     			new CheckStylePropertyDefinedTestCase("BoundedShape", "Width", "int"),
//     			new CheckStylePropertyDefinedTestCase("BoundedShape", "Height", "int"),
//     			new CheckStyleEditablePropertyDefinedTestCase("BoundedShape", "Width", "int"),
//     			new CheckStyleEditablePropertyDefinedTestCase("BoundedShape", "Height", "int")
//     			
////     			new CheckstyleSuperTypeDefinedTestCase("@LINE_PATTERN", "Locatable"),
////     			new CheckstyleSuperTypeDefinedTestCase("@STRING_PATTERN", "Locatable"),
////     			new CheckstyleSuperTypeDefinedTestCase("@IMAGE_PATTERN", "BoundedShape")
//     			);

		// Method calls
		addFeature("CommandInterpreter makes calls to move and say", 6,
				new CheckstyleMethodCalledTestCase("CommandInterpreter", "@BridgeScene!@say:String->*"),
				new CheckstyleMethodCalledTestCase("CommandInterpreter", "(.*)!@move:int;int->*"));

		// SingletonCreator
		addFeature("SingletonCreator created and used", 16,
				new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@avatarTableFactoryMethod:->@Table"),
				new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@bridgeSceneFactoryMethod:->@BridgeScene"),
				new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@scannerFactoryMethod:->@ScannerBean"),
				new CheckstyleMethodDefinedTestCase("SingletonsCreator",
						"@commandInterpreterFactoryMethod:->@CommandInterpreter"),

				new CheckstyleMethodCalledTestCase("CommandInterpreter",
						"@SingletonsCreator!@avatarTableFactoryMethod:->@Table"),
				new CheckstyleMethodCalledTestCase("main.Assignment7",
						"@SingletonsCreator!@bridgeSceneFactoryMethod:->@BridgeScene"),
				new CheckstyleMethodCalledTestCase("main.Assignment7",
						"@SingletonsCreator!@scannerFactoryMethod:->@ScannerBean"),
				new CheckstyleMethodCalledTestCase("main.Assignment7",
						"@SingletonsCreator!@commandInterpreterFactoryMethod:->@CommandInterpreter"));

		addFeature("Table used in SingetonsCreator, CommandInterpreter, and main", 8,
//     				new CheckstyleMethodCalledTestCase("SingletonsCreator", "(.*)!put:String;Object->void"),
				new CheckstyleMethodCalledTestCase("CommandInterpreter", "(.*)!get:String->*"),
				new CheckstyleMethodCalledTestCase("main.Assignment7", "(.*)!put:String;Object->void"),
				new CheckstyleMethodCalledTestCase("main.Assignment7", "(.*)!get:String->*"));

		// Command interpreter
		addFeature("Command interpreter has required property", 6,
//     			new CheckstyleConstructorDefinedTestCase("CommandInterpreter", ":@BridgeScene;@ScannerBean"), // told to remove
				new CheckStylePropertyDefinedTestCase("CommandInterpreter", "Command", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("CommandInterpreter", "Command", "String"));

		addFeature("Command interpreter has errors property", 2, true,
				new CheckStylePropertyDefinedTestCase("CommandInterpreter", "Errors", "*"));

		addManualFeature("Animation shows function of command interpreter and correct output in all frames", 15, false);
		addManualFeature("Table demonstrated in console, works correctly", 8, false);

		addManualRestriction(INTERACTIVE_RUN, 5,
				new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));

		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

	}// end method
}
