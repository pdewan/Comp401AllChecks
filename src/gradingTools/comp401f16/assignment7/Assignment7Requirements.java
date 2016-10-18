package gradingTools.comp401f16.assignment7;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment7.testcases.Assignment7Suite;
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

public class Assignment7Requirements  extends AJUnitProjectRequirements{
	public Assignment7Requirements(){
		addDueDate("10/13/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("10/15/2016 00:59:00", 1); 		// fri due
     	addDueDate("10/18/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("10/22/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	
     	addJUnitTestSuite(Assignment7Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
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
     			new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 1.0/6.0)
//     			
//     			new CheckstyleSuperTypeDefinedTestCase("BoundedShape", "Locatable"),
//     			
//     			new CheckstyleSuperTypeDefinedTestCase("@LINE_PATTERN", "Locatable"),
//     			new CheckstyleSuperTypeDefinedTestCase("@STRING_PATTERN", "Locatable"),
     			);
     	addFeature("BoundedShape subtypes defined", 4, // 1 or 2 cases
//// 			
// 			new CheckstylePatternBasedSuperTypeDefinedTestCase("Locatable", 1.0/6.0)
 			new CheckstylePatternBasedSuperTypeDefinedTestCase("BoundedShape", 1.0/2.0) 		
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
     	addFeature("CommandInterpreter properly uses the other classes", 8,
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@BridgeScene!@say:String->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "(.*)!@move:int;int->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "(.*)!@get:String->*"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@SingletonsCreator!@avatarTableFactoryMethod:->@Table")
     			);

     	// SingletonCreator
     	addFeature("SingletonCreator created and used in main", 16,
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@avatarTableFactoryMethod:->@Table"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@bridgeSceneFactoryMethod:->@BridgeScene"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@scannerFactoryMethod->@ScannerBean"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@commandInterpreterFactoryMethod:->@CommandInterpreter"),
     			
     			new CheckstyleMethodCalledTestCase("CommandInterpreter", "@SingletonsCreator!@avatarTableFactoryMethod:->@Table"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@bridgeSceneFactoryMethod:->@BridgeScene"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@scannerFactoryMethod->@ScannerBean"),
     			new CheckstyleMethodCalledTestCase("main.Assignment7", "@SingletonsCreator!@commandInterpreterFactoryMethod:->@CommandInterpreter")
     			);
     	
     	// Command interpreter 
     	addFeature("Command interpreter has required property and is instantiated", 12, 
     			new CheckstyleClassInstantiatedTestCase("main.Assignment7", "CommandInterpreter"),
     			new CheckstyleConstructorDefinedTestCase("CommandInterpreter", ":@BridgeScene;@ScannerBean"),
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
