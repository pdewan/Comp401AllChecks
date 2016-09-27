package gradingTools.comp401f16.assignment3;
import java.util.List;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment3.testcases.Assignment3Suite;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleVariableHasClassTypeTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleConstructorDefinedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstylePropertyDefinedTestCase;
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
     	
     	addFeature("Every class has at least one interface", 10, 
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
     	addFeature("Properties defined for token classes", 15, 
     			new CheckstylePropertyDefinedTestCase("@Word= Input:String AND Value:String"),
     			new CheckstylePropertyDefinedTestCase("@Number= Input:String AND Value:int"),
     			new CheckstylePropertyDefinedTestCase("@Quote= Input:String"),
     			new CheckstylePropertyDefinedTestCase("@Start= Input:String"),
     			new CheckstylePropertyDefinedTestCase("@End= Input:String")
     			// How do I check for setters?
     			);
     	
     	// Extra credit classes
     	addFeature("Extra credit classes instantiated", 4, true,
     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "Plus"),
     			new CheckstyleClassInstantiatedTestCase("ScannerBean", "Minus")
     			);
     	addFeature("Extra credit constructors defined", 4, true,
     			new CheckstyleConstructorDefinedTestCase("Plus", ":String"),
     			new CheckstyleConstructorDefinedTestCase("Minus", ":String")
     			);
     	
     	addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
     			
	}//end method
}//end class
