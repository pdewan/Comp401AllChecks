package gradingTools.comp401f16.assignment11;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment10.testcases.Assignment10Suite;
import gradingTools.comp401f16.assignment11.testcases.Assignment11Suite;
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

public class Assignment11Requirements  extends AJUnitProjectRequirements{
	public Assignment11Requirements(){
		addDueDate("11/17/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("11/19/2016 00:59:00", 1); 		// fri due
     	addDueDate("11/29/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("12/03/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment11Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());

     	// TODO: is there a way to check that classes are abstract, or that methods are synchronized?
     	
     	// iterator methods exist and are used
     	addFeature("Iterator methods exist and are used", 7, 
     			new CheckstyleMethodDefinedTestCase("Parser", "next:->*"),
     			new CheckstyleMethodDefinedTestCase("Parser", "peek:->*"),
     			new CheckstyleMethodDefinedTestCase("Parser", "hasNext:->boolean"),
     			new CheckstyleMethodDefinedTestCase("Parser", "reset:->*"),
     			new CheckstyleMethodCalledTestCase("Parser", "next:->*"),
     			new CheckstyleMethodCalledTestCase("Parser", "peek:->*"),
     			new CheckstyleMethodCalledTestCase("Parser", "reset:->*")
     			);
     	
     	// command classes exist
     	addFeature("Basic command classes defined and used", 3,
     			new CheckstyleConstructorDefinedTestCase("ApproachCommand", ":@BridgeScene;@Avatar"),
     			new CheckstyleConstructorDefinedTestCase("PassCommand",":@BridgeScene"),
     			new CheckstyleConstructorDefinedTestCase("FailCommand",":@BridgeScene"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "ApproachCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "PassCommand"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "FailCommand"),
     			new CheckstyleInterfaceDefinedTestCase("ApproachCommand", "Runnable"),
     			new CheckstyleInterfaceDefinedTestCase("PassCommand", "Runnable"),
     			new CheckstyleInterfaceDefinedTestCase("FailCommand", "Runnable"),
     			new CheckstyleMethodCalledTestCase("ApproachCommand", "(.*)!@approach:@Avatar->*"),
     			new CheckstyleMethodCalledTestCase("PassCommand", "(.*)!@passed:->*"),
     			new CheckstyleMethodCalledTestCase("FailCommand", "(.*)!@failed:->*")
     			);
     	
     	
     	addFeature("Composite command classes defined and used", 3,
     			new CheckstyleConstructorDefinedTestCase("CommandList", ":int;@Runnable"),
     			new CheckstyleConstructorDefinedTestCase("RepeatCommand",":@BridgeScene"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "CommandList"),
     			new CheckstyleClassInstantiatedTestCase("Parser", "RepeatCommand"),
     			new CheckstyleInterfaceDefinedTestCase("CommandList", "Runnable"),
     			new CheckstyleInterfaceDefinedTestCase("RepeatCommand", "Runnable"),
     			new CheckstyleMethodCalledTestCase("CommandList", "Runnable!run:->void"),
     			new CheckstyleMethodCalledTestCase("RepeatCommand", "Runnable!run:->void"),
     			new CheckstyleMethodDefinedTestCase("CommandList", "@add:Runnable->*")
     			);
     	
     	
     	// parsing methods exist
     	addFeature("Parsing methods are created and used", 3, 
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseSayCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseMoveCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseApproachCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parsePassCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseFailCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseRepeatCommand:*->Runnable"),
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseCommandList:*->Runnable"),

     			new CheckstyleMethodCalledTestCase("Parser", "@parseSayCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseMoveCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseApproachCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parsePassCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseFailCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseRepeatCommand:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseCommandList:*->Runnable"),
     			new CheckstyleMethodCalledTestCase("Parser", "@CommandList!@add:Runnable->*")
     			);
     	
     	// Parser properties
     	addFeature("Parser has correct properties", 3, 
     			new CheckStyleEditablePropertyDefinedTestCase("Parser", "CommandText", "String"),
     			new CheckStylePropertyDefinedTestCase("Parser", "CommandText", "String"),
     			new CheckStylePropertyDefinedTestCase("Parser", "CommandObject", "Runnable")
     			);
     	
     	// parseNumber extra credit
     	addFeature("parseNumber exists and is used", 3, true,
     			new CheckstyleMethodDefinedTestCase("Parser", "@parseNumber:*->*//EC"),
     			new CheckstyleMethodCalledTestCase("Parser", "@parseNumber:*->*//EC")
     			);
     	
     	// Error property extra credit
     	addFeature("Parser has error property", 2, true,
     			new CheckStylePropertyDefinedTestCase("Parser", "Errors", "*")
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
