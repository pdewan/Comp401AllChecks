package gradingTools.comp401f16.assignment12;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f15.assignment12.testcases.GenerictClassCheckStyleTestCase;
import gradingTools.comp401f16.assignment12.testcases.Assignment12Suite;
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

public class Assignment12Requirements  extends AJUnitProjectRequirements{
	public Assignment12Requirements(){
		addDueDate("12/06/2016 00:59:00", 1.05); 	// mon before
     	addDueDate("11/08/2016 00:59:00", 1); 		// wed due
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment12Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	//not used due to parse methods returning non-interfaces
//     	addRestriction("Variables should have interface, not class, type", 10, 
//     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	//not used due to code copied from JavaTeaching
//     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());

     	
     	// BroadCastingClearanceManager has singletonsCreator method
     	addFeature("", 7, 
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@broadcastingClearanceManagerFactoryMethod:->@BroadCastingClearanceManager"),
     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "BroadCastingClearanceManager"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->@BroadCastingClearanceManager"),
     			new CheckstyleMethodCalledTestCase("CoordinatedAnimator", "@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->@BroadCastingClearanceManager"),
     			new CheckstyleMethodCalledTestCase("CoordinatingAnimator", "@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->@BroadCastingClearanceManager"),
     			new CheckstyleMethodCalledTestCase("ProceedAllCommand", "@SingletonsCreator!@broadcastingClearanceManagerFactoryMethod:->@BroadCastingClearanceManager")
     			);
     	
     	// Coordinating methods defined, used, startAnimation
     	addFeature("", 7,
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingArthur:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingGalahad:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingLancelot:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@waitingRobin:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@startAnimation:->void"),
     			new CheckstyleMethodCalledTestCase("AnimatingCommand", "BroadCastingClearanceManager!waitForProceed:->void"),
     			new CheckstyleConstructorDefinedTestCase("AnimatingCommand", ":@Animator;@Avatar;boolean")
     			);
     	
     	// Check that generics are used
     	addFeature("Generics added to Table", 15,
            new GenerictClassCheckStyleTestCase("Table")); //TODO: make sure this is ok
     	
     	   
     	//Extra credit:
     	
     	// Lockstep methods:
     	addFeature("", 1, 
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepArthur:->void//EC"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepGalahad:->void//EC"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepLancelot:->void//EC"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepRobin:->void//EC"),
     			new CheckstyleConstructorDefinedTestCase("CoordinatedAnimationCommand", ":@CoordinatedAnimator;@Avatar"),
     			new CheckstyleMethodCalledTestCase("CoordinatedAnimationCommand", ":@CoordinatedAnimator:*->void"),
     			new CheckstyleMethodCalledTestCase("CoordinatedAnimator", "BroadCastingClearanceManager!waitForProceed:->void"),
     			
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@lockstepGuard//EC->void"),
     			new CheckstyleMethodDefinedTestCase("CoordinatingAnimator", "@animateAvatar:@Avatar->void"),
     			new CheckstyleMethodCalledTestCase("CoordinatingAnimator", "(.*)!sleep:long->void"), 
     			new CheckstyleMethodCalledTestCase("CoordinatingAnimator", "BroadCastingClearanceManager!proceedAll:->void"),
     			new CheckstyleConstructorDefinedTestCase("CoordinatingAnimatingCommand", ":@CoordinatingAnimator;@Avatar"),
     			new CheckstyleMethodCalledTestCase("CoordinatingAnimatingCommand", "@CoordinatingAnimator!@animateAvatar:@Avatar->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!@lockstep(.*):->void//EC")
     			);
     	
     	addFeature("", 7, 
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@environmentFactoryMethod:->@Table"),
     			new CheckstyleMethodCalledTestCase("Parser", "@SingletonsCreator!@environmentFactoryMethod:->@Table"),
		
     			// Constructors
     			new CheckstyleConstructorDefinedTestCase("RotateLeftArmCommand", ":@Avatar; int"),
     			new CheckstyleConstructorDefinedTestCase("RotateRightArmCommand",":@Avatar; int"),
     			new CheckstyleConstructorDefinedTestCase("SleepCommand", ":long"),
     			new CheckstyleConstructorDefinedTestCase("DefineCommandObject", ":String;Runnable"),
     			new CheckstyleConstructorDefinedTestCase("CallCommandObject", "String"),
     			new CheckstyleConstructorDefinedTestCase("ThreadCommandObject", "String"),
//     			new CheckstyleConstructorDefinedTestCase("ProceedAllCommand", ":"), //no args
     			
     			// Method calls inside command objects
     			new CheckstyleMethodCalledTestCase("RotateLeftArmCommand", "(.*)!@rotateLeftArm:int->void"),
     			new CheckstyleMethodCalledTestCase("RotateRightArmCommand","(.*)!@rotateLeftArm:int->void"),
     			new CheckstyleMethodCalledTestCase("SleepCommand", "(.*)!sleep:long->void"),
     			new CheckstyleMethodCalledTestCase("DefineCommandObject", "(.*)!put:Object;Object->*"),
     			new CheckstyleMethodCalledTestCase("CallCommandObject", "(.*)!get:Object->Object"),
     			new CheckstyleMethodCalledTestCase("CallCommandObject", "Runnable!run:->void"),
     			new CheckstyleMethodCalledTestCase("ThreadCommandObject", "(.*)!get:Object->Object"),
     			new CheckstyleMethodCalledTestCase("ThreadCommandObject", "Thread!start:->void"),
     			new CheckstyleMethodCalledTestCase("ProceedAllCommand", "BroadCastingClearanceManager!proceedAll:->void"),
     			
     			// Instantiations
     			new CheckstyleClassInstantiatedTestCase("Parser", "RotateLeftArmCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "RotateRightArmCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "SleepCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "DefineCommandObject"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "CallCommandObject"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "ThreadCommandObject"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "ProceedAllCommand"),
     			
     			// Parse methods
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseRotateLeftArm:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseRotateRightArm:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseSleep:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseDefine:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseCall:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseThread:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseProceedAll:*->Runnable"),

     			new CheckstyleMethodCalledTestCase("Parser", "@parseRotateLeftArm:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseRotateRightArm:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseSleep:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseDefine:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseCall:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseThread:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseProceedAll:*->Runnable")
     			);     	
     	
     	// Exceptions
     	addFeature("", 1, 
     			new CheckstyleSuperTypeDefinedTestCase("ScanningException", "IOException"),
     			new CheckstyleSuperTypeDefinedTestCase("ParsingException", "IOException"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "ScanningException"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "ParsingException")
     			);
     	//TODO: any other checks for exceptions?
     	
     	// custom text fields
     	addFeature("", 1, 
     			new CheckstyleSuperTypeDefinedTestCase("CustomSwingTextFieldFactory", "SwingTextFieldFactory"),
     			new CheckstyleClassInstantiatedTestCase("CustomSwingTextFieldFactory", "JTextField"),
     			new CheckstyleMethodCalledTestCase("CustomSwingTextFieldFactory", "JTextField!setBackground:String->"),
     			new CheckstyleMethodCalledTestCase("CustomSwingTextFieldFactory", "JTextField!setForeground:String->"),
     			new CheckstyleMethodCalledTestCase("Assignment12.main", "TextFieldSelector!setTextFieldFactory:TextFieldFactory->void"),
     			new CheckstyleMethodCalledTestCase("Assignment12.main", "ObjectEditor!initialize:->void")
     			);
     	// TODO: is there a way to check that a method is overriden?
     	
     	// Undo and redo
     	addFeature("", 1,
     			new CheckstyleClassInstantiatedTestCase("Parser", "UndoCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "RedoCommand"),
     			new CheckstyleMethodCalledTestCase("UndoCommand", "*!undo->void"),
     			new CheckstyleMethodCalledTestCase("RedoCommand", "*!redo:->void"),
     			new CheckstyleMethodDefinedTestCase("MoveCommand", "undo:->void"),
     			new CheckstyleMethodDefinedTestCase("Parser", "parseUndo:*->Runnable"),//TODO parseUndo or parseUndoCommand?
     			new CheckstyleMethodDefinedTestCase("Parser", "parseRedo:*->Runnable")
     			);
     	
      // main method calls
     	addFeature("", 1,
     			new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!@waiting(.*):->void"),
     			new CheckstyleMethodCalledTestCase("main.Assignment12", "(.*)!setCommand:String->*")
     			);
     	
     	
     	//If they call the lockstepGuard method, there will be problem
     	
     	
     	// manual features
     	addManualFeature("4 animations wait until press of proceedAll", 10, false);
     	addManualFeature("Lockstep animations work", 10, true);
     	addManualFeature("New commands showcased (3 points each)", 27);
     	
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
