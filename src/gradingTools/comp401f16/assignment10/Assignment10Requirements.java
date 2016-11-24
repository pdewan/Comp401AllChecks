package gradingTools.comp401f16.assignment10;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment10.testcases.Assignment10Suite;
import gradingTools.comp401f16.assignment7.testcases.Assignment7Suite;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleClassDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleEditablePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleMagicNumberTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleMinCalledMethodsTestCase;
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

public class Assignment10Requirements  extends AJUnitProjectRequirements{
	public Assignment10Requirements(){
		addDueDate("11/10/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("11/12/2016 00:59:00", 1); 		// fri due
     	addDueDate("11/15/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("11/19/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	
     	addJUnitTestSuite(Assignment10Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
     	
     	// Preconditions
     	addFeature("Preconditions defined", 8, 
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@prePassed:->boolean"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@preFailed:->boolean"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@preSay:->boolean"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@preApproach:->boolean")
     			);
     	
     	
     	addFeature("Event notifications fired and received", 6,
     			new CheckstyleInterfaceDefinedTestCase("BridgeScene", "PropertyListenerRegisterer"),
     			new CheckstyleClassInstantiatedTestCase("BridgeScene" ,"PropertyChangeEvent"),
     			new CheckstyleMethodCalledTestCase("ConsoleSceneView", "(.*)!addPropertyChangeListener:PropertyChangeListener->void")
     			);
     	
     	// command objects
     	addFeature("Command objects created for parsing", 8,
     			new CheckstyleInterfaceDefinedTestCase("SayCommand", "Runnable"),
     			new CheckstyleConstructorDefinedTestCase("SayCommand", ":@BridgeScene; String"),
     			new CheckstyleInterfaceDefinedTestCase("MoveCommand", "Runnable"),
     			new CheckstyleConstructorDefinedTestCase("MoveCommand", ":@Avatar; int; int") //TODO: constructor checks don't work
     			);
     			
     	// parsing methods, run() calls
     	addFeature("Parsing methods made, setter calls run()", 10,
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@parseMove:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@parseSay:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@parseMove:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@parseSay:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "Runnable!run:->void")
     			);
     	
     	// animator, animation commands
     	addFeature("Animator and animation commands created and used", 6,
     			new CheckstyleMethodCalledTestCase("Animator", "(.*)!sleep:long->void"),
     			new CheckstyleMethodCalledTestCase("AnimatingCommand", "@Animator!@animateAvatar:@Avatar->void"),
     			new CheckstyleConstructorDefinedTestCase("AnimatingCommand",":@Animator; @Avatar")
     			);
     	
     	// asynch methods, thread instantiations
     	addFeature("Asynchronous methods create new threads", 10,
     			new CheckstyleClassInstantiatedTestCase("CommandInterpreter", "AnimatingCommand"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "Thread:start:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@asynchronousArthur:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@asynchronousGalahad:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@asynchronousLancelot:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@asynchronousRobin:->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment10", "@CommandInterpreter!@asynchronousArthur:->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment10", "@CommandInterpreter!@asynchronousGalahad:->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment10", "@CommandInterpreter!@asynchronousLancelot:->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment10", "@CommandInterpreter!@asynchronousRobin:->void")
     			);
     	
     	// EC: asynch guard
     	addFeature("Asynchronous guard", 2, true,
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@asynchronousGuard:->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment10", "@CommandInterpreter!@asynchronousGuard->void")
     			);
     	
     	// EC: setEnabled calls, button properties
     	addFeature("CommandInterpreter new buttons respond to preconditions", 6 ,true,
     			new CheckstyleMethodCalledTestCase("CommandInterpreterController", "@BridgeScene!addPropertyChangeListener:PropertyChangeListener->void"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreterController", "JButton!setEnabled:boolean->void"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Say", "JButton"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Approach", "JButton"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Pass", "JButton"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Fail", "JButton")
     			);
     	
     	// Manual: All preconditions shown, precondition events fired
   	addManualFeature("Console shows all precondition events being fired", 10, false); 
     	
     	// Manual: asynch methods
   	addManualFeature("Animation shows animations acting asynchronously", 10, false); 
      
     	// Manual, EC: buttons deactivated properly, work
   	addManualFeature("CommandInterpreter buttons activate and deactivate properly", 9, true); 
   	
     	// Manual, EC: clap animation
   	addManualFeature("Animation shows clapping guard", 3, true); 
      
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
