package gradingTools.comp401f16.assignment7;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
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

public class Assignment7Requirements  extends AJUnitProjectRequirements{
	public Assignment7Requirements(){
		addDueDate("10/13/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("10/15/2016 00:59:00", 1); 		// fri due
     	addDueDate("10/18/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("10/22/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	
     	// TODO: uncomment once Assignment7Suite exists
//     	addJUnitTestSuite(Assignment7Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
     	
     	// TODO: Class refactorings
//     	addFeature("Tokens inherit from general class", 10,
//     			new CheckstyleExpectedSupertypesTestcase("BoundedShape", "Locatable");
//     			new CheckstyleExpectedSupertypesTestcase("@LINE_PATTERN", "BoundedShape");
//     			new CheckstyleExpectedSupertypesTestcase("@STRING_PATTERN", "Locatable");
//     			new CheckstyleExpectedSupertypesTestcase("@IMAGE_PATTERN", "BoundedShape");
//     			new CheckstyleExpectedSupertypesTestcase("@LINE_PATTERN", "Locatable");
//     			);
     	
     	// Method calls
     	addFeature("CommandInterpreter properly uses the other classes", 6,
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@BridgeScene!@say:String->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@Avatar!@move:int;int->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@Table!@get:String->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@SingletonsCreator!@avatarTableFactoryMethod:->@Table")
     			);

     	// SingletonCreator
     	addFeature("SingletonCreator created and used in main", 12,
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter",  "@SingletonsCreator!@bridgeSceneFactoryMethod:->@BridgeScene"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@SingletonsCreator!@scannerFactoryMethode->@ScannerBean"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreter", "@SingletonsCreator!@avatarTableFactoryMethod:->@Table"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@bridgeSceneFactoryMethod:->@BridgeScene"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@scannerFactoryMethode->@ScannerBean"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@avatarTableFactoryMethod:->@Table")
     			);
     	
     	// Command interpreter 
     	addFeature("Command interpreter has required property and is instantiated", 9, 
     			new CheckstyleClassInstantiatedTestCase("main.Assignment7", "CommandInterpreter"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreter", "Command", "String"),
     			new CheckStyleEditablePropertyDefinedTestCase("CommandInterpreter", "Command", "String")
     			);

     	addManualFeature("Animation shows function of command interpreter and correct output in all frames", 15, false); 
     	addManualFeature("Table demonstrated in console, works correctly", 10, false);
     	
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
