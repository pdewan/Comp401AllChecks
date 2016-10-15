package gradingTools.comp401f16.assignment6;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment6.testcases.Assignment6Suite;
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
import gradingTools.sharedTestCase.checkstyle.CheckstyleSuperTypeDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;

public class Assignment6Requirements  extends AJUnitProjectRequirements{
	public Assignment6Requirements(){
		addDueDate("10/06/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("10/08/2016 00:59:00", 1); 		// fri due
     	addDueDate("10/11/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("10/15/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment6Suite.class);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
     	
     	addFeature("Tokens inherit from general class", 14,
//     			new CheckStyleClassDefinedTestCase("Token"),		//test currently doesn't work, and may not be necessary
     			new CheckStylePropertyDefinedTestCase("Token", "Input", "String"),
     			new CheckStyleEditablePropertyDefinedTestCase("Token", "Input", "String"),
     			
     			new CheckstyleSuperTypeDefinedTestCase("Word", "Token"),
     			new CheckstyleSuperTypeDefinedTestCase("Number", "Token"),
     			new CheckstyleSuperTypeDefinedTestCase("Quote", "Token"),
     			new CheckstyleSuperTypeDefinedTestCase("End", "Token"),
     			new CheckstyleSuperTypeDefinedTestCase("Start", "Token")
     			);
     	
     	addFeature("Commands inherit from word token", 12,
     			new CheckstyleSuperTypeDefinedTestCase("Move", "Word"),
     			new CheckstyleSuperTypeDefinedTestCase("Say", "Word"),
     			new CheckstyleSuperTypeDefinedTestCase("Fail", "Word"),
     			new CheckstyleSuperTypeDefinedTestCase("Pass", "Word"),
     			new CheckstyleSuperTypeDefinedTestCase("Approach", "Word"),
     			new CheckstyleSuperTypeDefinedTestCase("Repeat", "Word")
     			);
     	
     	// Method signatures
     	addFeature("Bridge scene has new methods defined", 12, 
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@approach:@Avatar->*"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@say:String->*"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@passed:->*"),
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@failed:->*")     			
     			);
     	
     	// Method calls
     	addFeature("BridgeScene uses avatar move method and setText", 6,
     			new CheckstyleMethodCalledTestCase("BridgeScene", "@Avatar!@move:int;int->*"),
     			new CheckstyleMethodCalledTestCase("BridgeScene", "@STRING_PATTERN!setText:String->void")
     			);
     	
     	// Extra credit- I'm assuming that it is tested elsewhere, so just a couple points for definition
     	addFeature("Scroll method defined", 2, true,
     			new CheckstyleMethodDefinedTestCase("BridgeScene", "@scroll:int;int->*")
     			);
     	
     	// Class instantiation
     	addFeature("Gorge instantiated", 3,
     			new CheckstyleClassInstantiatedTestCase("BridgeScene", "Gorge")
     			);
     	
     	// Properties defined
     	addFeature("Graphical classes have proper properties defined", 12,
     			
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Gorge", "*"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "KnightArea", "*"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "GuardArea", "*"),
				new CheckStylePropertyDefinedTestCase("BridgeScene", "Occupied", "boolean")
//				,new CheckStylePropertyDefinedTestCase("BridgeScene", "KnightTurn", "boolean") //told to remove
						
     			);	

     	addManualFeature("Scene has a gorge with a bridge.", 10, false); 
     	addManualFeature("Animation shows approach, say, pass, fail correctly.", 20, false);
     	addManualFeature("Animation shows boolean properties, acting correctly.", 8, false);
     	
     	addManualFeature("Scanner animation shows proper functionality.", 10, false);
     		
     	// I'm assuming both of these are tested elsewhere, hence the values are small
     	addManualFeature("Animation shows scroll feature", 3, true);
     	addManualFeature("Scanner animation shows TokenList property (correctly).", 3, true);
     	
     	
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
