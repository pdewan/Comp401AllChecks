package gradingTools.comp401f16.assignment3;
import java.util.List;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment3.testcases.Assignment3Suite;
import gradingTools.sharedTestCase.checkstyle.CheckStyleEditablePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStylePropertyDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleVariableHasClassTypeTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleConstructorDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.checkstyle.ClassHasAtLeastOneInterfaceTestCase;

public class Assignment3Requirements extends AJUnitProjectRequirements {
	
	public Assignment3Requirements() {
		addDueDate("09/15/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("09/17/2016 00:59:00", 1); 		// fri due
     	addDueDate("09/20/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("09/24/2016 00:59:00", 0.85); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.8); 	// infinity
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment3Suite.class);
     	
     	// Method calls
     	addFeature("getInput and getValue are called in scannerBean", 10,
     			new CheckstyleMethodCalledTestCase("ScannerBean",
     					"getInput:->String"),
     			new CheckstyleMethodCalledTestCase("ScannerBean",
     					"getValue:->String")
     			);
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	// Classes for tokens instantiated
     	addFeature("Required token classes instantiated", 15,
     			new CheckstyleClassInstantiatedTestCase("ScannerBean","Word"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean","Number"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean","Quote"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean","Start"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean","End")     			
     			);
     	
     	// Constructors defined
     	addFeature("Single parameter constructors defined", 15,
     			new CheckstyleConstructorDefinedTestCase("Word", ":String"),
     			new CheckstyleConstructorDefinedTestCase("Number", ":String"),
     			new CheckstyleConstructorDefinedTestCase("Quote", ":String"),
     			new CheckstyleConstructorDefinedTestCase("Start", ":String"),
     			new CheckstyleConstructorDefinedTestCase("End", ":String")
     			);
     	
     	// Properties defined
     	addFeature("Properties defined for token classes", 21,
				new CheckStyleEditablePropertyDefinedTestCase("Word", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Number", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Quote", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("Start", "Input", "String"),
				new CheckStyleEditablePropertyDefinedTestCase("End", "Input", "String"),
				
     			// Editable properties
				new CheckStylePropertyDefinedTestCase("Word", "Value", "String"),
				new CheckStylePropertyDefinedTestCase("Number", "Value", "int")
     			);
     	
     	// Proper constructors exist
     	addFeature("Necessary interfaces created and used", 21,
     			new CheckstyleInterfaceDefinedTestCase("Word", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("Number", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("Quote", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("Start", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("End", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("Word", "Word"),
     			new CheckstyleInterfaceDefinedTestCase("Number", "Number")
     			);
     	
     	// Extra credit classes
     	addFeature("Extra credit classes instantiated, with proper interfaces", 8, true,
     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "Plus"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "Minus"),
     			new CheckstyleInterfaceDefinedTestCase("Plus", "Token"),
     			new CheckstyleInterfaceDefinedTestCase("Minus", "Token")
     			);
     	addFeature("Extra credit constructors and properties defined", 8, true,
     			new CheckstyleConstructorDefinedTestCase("Plus", ":String"),
     			new CheckstyleConstructorDefinedTestCase("Minus", ":String"),
     			new CheckStyleEditablePropertyDefinedTestCase("Plus", "Input", "String"),
     			new CheckStyleEditablePropertyDefinedTestCase("Minus", "Input", "String")
     			);
     	
     	addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
     			
	}//end method
}//end class