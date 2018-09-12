package gradingTools.comp401f18.assignment12;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f15.assignment12.testcases.GenerictClassCheckStyleTestCase;
import gradingTools.comp401f17.assignment12.testcases.Assignment12Suite;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleEditablePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStylePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleConstructorDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleSuperTypeDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;

public class Assignment12Requirements extends AJUnitProjectRequirements {
	public Assignment12Requirements() {
		addDueDate("11/29/2018 00:59:00", 1.05); 	// wed before + 1hr
     	addDueDate("12/01/2018 00:59:00", 1); 		// fri due + 1hr
//		addDueDate("12/07/2017 03:00:00", 1);

		// Functionality
		GradingMode.setGraderRun(true);
		addJUnitTestSuite(Assignment12Suite.class);

		addFeature("Public methods are in implemented interfaces", 10, new ClassHasAtLeastOneInterfaceTestCase());

		// not used due to parse methods returning non-interfaces
//     	addRestriction("Variables should have interface, not class, type", 10, 
//     			new CheckStyleVariableHasClassTypeTestCase());

		// not used due to code copied from JavaTeaching
//     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());

		// BroadCastingClearanceManager has singletonsCreator method
		addFeature("ABroadcastigClearanceManager used as a singleton", 9,
				new CheckstyleMethodDefinedTestCase("SingletonsCreator",
						"@broadcastingClearanceManagerFactoryMethod:->BroadcastingClearanceManager"),
				new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "ABroadcastingClearanceManager"),
				new CheckstyleMethodCalledTestCase("CommandInterpreter",
						"@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->BroadcastingClearanceManager"),
				new CheckstyleMethodCalledTestCase("CoordinatedAnimator",
						"@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->BroadcastingClearanceManager"),
				new CheckstyleMethodCalledTestCase("CoordinatingAnimator",
						"@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->BroadcastingClearanceManager"),
				new CheckstyleMethodCalledTestCase("ProceedAllCommand",
						"@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->BroadcastingClearanceManager"));

		// Waiting methods defined, startAnimation
		addFeature("Waiting animations created", 16,
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingArthur:->void"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingGalahad:->void"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingLancelot:->void"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingRobin:->void"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@startAnimation:->void"),
				new CheckstyleMethodCalledTestCase("AnimatingCommand", "(.*)!waitForProceed:->void"),
				new CheckstyleConstructorDefinedTestCase("AnimatingCommand", ":@Animator;@Avatar;boolean"),
				new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!@waiting(.*):->void"));

		// Check that generics are used
		addFeature("Generics added to Table", 15, new GenerictClassCheckStyleTestCase("Table")); // TODO: make sure this
																									// is ok

		// Extra credit:

		// Lockstep methods:
		addFeature("Lockstep and coordinating methods created and used", 14, true,
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepArthur:->void//EC"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepGalahad:->void//EC"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepLancelot:->void//EC"),
				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepRobin:->void//EC"),
				new CheckstyleConstructorDefinedTestCase("CoordinatedAnimationCommand",
						":@CoordinatedAnimator;@Avatar"),
				new CheckstyleMethodCalledTestCase("CoordinatedAnimationCommand", ":@CoordinatedAnimator:*->void"),
				new CheckstyleMethodCalledTestCase("CoordinatedAnimator", "(.*)!waitForProceed:->void"),

				new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepGuard:->void//EC"),
//     			new CheckstyleMethodDefinedTestCase("CoordinatingAnimator", "@animateAvatar:@Avatar->void"), //false positive in skeleton
				new CheckstyleMethodCalledTestCase("CoordinatingAnimator", "(.*)!sleep:long->void"),
//     			new CheckstyleMethodCalledTestCase("CoordinatingAnimator", "(.*)!proceedAll:->void"),	//false positive in skeleton
//     			new CheckstyleConstructorDefinedTestCase("CoordinatingAnimatingCommand", ":@CoordinatingAnimator;@Avatar"), //false positive in skeleton
				new CheckstyleMethodCalledTestCase("CoordinatingAnimatingCommand",
						"@CoordinatingAnimator!@animateAvatar:@Avatar->void"),
				new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!@lockstep(.*):->void//EC"));

		addFeature("Methods and classes for extended grammar created", 20, true,
				new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@environmentFactoryMethod:->@Table"),
				new CheckstyleMethodCalledTestCase("DefineCommand",
						"@SingletonsCreator!@environmentFactoryMethod:->@Table"),
				new CheckstyleMethodCalledTestCase("CallCommand",
						"@SingletonsCreator!@environmentFactoryMethod:->@Table"),

				// Constructors
				new CheckstyleConstructorDefinedTestCase("RotateLeftArmCommand", ":@Avatar; int"),
				new CheckstyleConstructorDefinedTestCase("RotateRightArmCommand", ":@Avatar; int"),
				new CheckstyleConstructorDefinedTestCase("SleepCommand", ":long"),
//     			new CheckstyleConstructorDefinedTestCase("DefineCommand", ":String;Runnable"), // problems if Runnable is extended
				new CheckstyleConstructorDefinedTestCase("CallCommand", ":String"),
				new CheckstyleConstructorDefinedTestCase("ThreadCommand", ":String"),
//     			new CheckstyleConstructorDefinedTestCase("ProceedAllCommand", ":"), //no args

				// Method calls inside command objects
//     			new CheckstyleMethodCalledTestCase("RotateLeftArmCommand", "(.*)!@rotate:int->void"),	//errors in "tstudent0",
//     			new CheckstyleMethodCalledTestCase("RotateRightArmCommand","(.*)!@rotate:int->void"),	//did not have a chance to debug
				new CheckstyleMethodCalledTestCase("SleepCommand", "(.*)!sleep:long->void"),
				new CheckstyleMethodCalledTestCase("DefineCommand", "(.*)!put:Object;Object->*"),
				new CheckstyleMethodCalledTestCase("CallCommand", "(.*)!get:Object->Object"),
				new CheckstyleMethodCalledTestCase("CallCommand", "Runnable!run:->void"),
				new CheckstyleMethodCalledTestCase("ThreadCommand", "(.*)!get:Object->Object"),
				new CheckstyleMethodCalledTestCase("ThreadCommand", "Thread!start:->void"),
				new CheckstyleMethodCalledTestCase("ProceedAllCommand", "(.*)!proceedAll:->void"),

				// Instantiations
				new CheckstyleClassInstantiatedTestCase("Parser", "RotateLeftArmCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "RotateRightArmCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "SleepCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "DefineCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "CallCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "ThreadCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "ProceedAllCommand"),

				// Parse methods
				new CheckstyleMethodDefinedTestCase("Parser", "@parseRotateLeftArmCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseRotateRightArmCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseSleepCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseDefineCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseCallCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseThreadCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseProceedAllCommand:*->Runnable"),

				new CheckstyleMethodCalledTestCase("Parser", "@parseRotateLeftArmCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseRotateRightArmCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseSleepCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseDefineCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseCallCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseThreadCommand:*->Runnable"),
				new CheckstyleMethodCalledTestCase("Parser", "@parseProceedAllCommand:*->Runnable"),

				new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!setCommand:String->*"),
				new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!waitForProceed:->void"));

		// Exceptions
		addFeature("Exceptions used", 9, true,
				new CheckstyleSuperTypeDefinedTestCase("ScanningException", "IOException"),
				new CheckstyleSuperTypeDefinedTestCase("ParsingException", "IOException"),
//     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "ScanningException"), //False positive in "previous"
				new CheckstyleClassInstantiatedTestCase("Parser", "ParsingException"),
				new CheckstyleMethodCalledTestCase("Parser", "@ScanningException!getMessage:->String"),
				new CheckstyleMethodCalledTestCase("Parser", "@ParsingException!getMessage:->String"));
		// TODO: any other checks for exceptions?

		// custom text fields
		addFeature("Custom text field color", 5, true,
				new CheckstyleSuperTypeDefinedTestCase("CustomSwingTextFieldFactory", "SwingTextFieldFactory"),
				new CheckstyleClassInstantiatedTestCase("CustomSwingTextFieldFactory", "JTextField"),
				new CheckstyleMethodCalledTestCase("CustomSwingTextFieldFactory", "JTextField!setBackground:*->void"),
				new CheckstyleMethodCalledTestCase("CustomSwingTextFieldFactory", "JTextField!setForeground:*->void"),
//     			new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!setTextFieldFactory:*->void"), //false negative in tstudent0
				new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!initialize:->void"));
		// TODO: is there a way to check that a method is overriden?

		// Undo and redo
		addFeature("Undo and redo commands created", 6, true, // change to 9 if debugged
				new CheckstyleClassInstantiatedTestCase("Parser", "UndoCommand"),
				new CheckstyleClassInstantiatedTestCase("Parser", "RedoCommand"),
//     			new CheckstyleMethodCalledTestCase("UndoCommand", "*!undo->void"),	// false positives in skeleton
//     			new CheckstyleMethodCalledTestCase("RedoCommand", "*!redo:->void"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseUndoCommand:*->Runnable"),
				new CheckstyleMethodDefinedTestCase("Parser", "@parseRedoCommand:*->Runnable"));

		// manual features
		addManualFeature("4 animations wait until press of proceedAll", 10, false);
		addManualFeature("Lockstep animations work", 10, true);
		addManualFeature("Commands showcased (9 possible commands)", 18, true);

		addManualRestriction(INTERACTIVE_RUN, 5,
				new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));

		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

	}// end method
}
