package gradingTools.comp401f16.assignment2;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f15.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment2.testcases.Assignment2Suite;
import gradingTools.shared.testcases.CheckstyleClassInstantiatedTestCase;
import gradingTools.shared.testcases.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.ClassDefinedTestCase;
import gradingTools.sharedTestCase.IllegalImportOrCallTestCase;


public class Assignment2Requirements extends AJUnitProjectRequirements {

    public Assignment2Requirements() {
     	addDueDate("09/08/2016 00:59:00", 1.05); // wed before
     	addDueDate("09/10/2016 00:59:00", 1); // fri due
     	addDueDate("09/13/2016 00:59:00", 0.95);// mon after due
     	addDueDate("09/17/2016 00:59:00", 0.85); // fri after due
     	addDueDate("12/05/2016 00:59:00", 0.8); // infinity
     	
     	
      // Functionality
    	addJUnitTestSuite(Assignment2Suite.class);
    	GradingMode.setGraderRun(true);
    	
    	// Method calls
    	addFeature("ScanString and IndexOf now called in ScannerBean (max 10pts)", 15,
	   		new CheckstyleMethodCalledTestCase(
	   				"ScannerBean", 
	   				"scanString:String->void"),
	   		new CheckstyleMethodCalledTestCase(
	    	   		"ScannerBean",    	    	   		
	    	   		"indexOf:String;char;int->int"),
	    	 new CheckstyleMethodCalledTestCase(
	    	    	"ScanningIterator",    	    	   		
	    	    	 "indexOf:String;char;int->int")); 
    	// Classes Instantiated
    	addFeature("Scanner Bean Instantiated in Main", 5,
    	   		new CheckstyleClassInstantiatedTestCase(
    	   				"main.Assignment2", 
    	   				"ScannerBean")); 
    	
        addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
        addManualFeature("Breakpoint step into/over/return screenhots", 20);

        addFeature("Scanner Bean Tagged ", 5, new ClassDefinedTestCase("@ScannerBean"));
        addRestriction("Illegal import or call", 25, new IllegalImportOrCallTestCase());

    }
}
