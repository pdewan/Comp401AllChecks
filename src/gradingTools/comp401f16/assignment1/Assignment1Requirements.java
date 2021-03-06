package gradingTools.comp401f16.assignment1;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.Assignment1Suite;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;


public class Assignment1Requirements extends AJUnitProjectRequirements {
	public static final String MAIN_SUBSTRING = "main.Assignment";
	public static final String ITERATOR_SUSTRING = "ScanningIterator";
    public Assignment1Requirements() {
    	addDueDate("09/01/2016 00:59:00", 1.05); // wed before
    	addDueDate("09/03/2016 00:59:00", 1); // fri due
    	addDueDate("09/06/2016 00:59:00", 0.95);// mon after due
    	addDueDate("09/10/2016 00:59:00", 0.85); // fri after due
    	addDueDate("12/12/2016 00:59:00", 0.8); // infinity
    	
        // Functionality
    	addJUnitTestSuite(Assignment1Suite.class);
    	GradingMode.setGraderRun(true);
    	
    	// Method calls
    	addFeature("Required Methods Called in Main or Iterator", 15, 
//    	   		new CheckstyleMethodDefinedTestCase("Parser", 	"@parseNumber:\\*->\\*"),
    	   		new CheckstyleMethodCalledTestCase(
    	   				"main.Assignment", 
    	   				"processInput:->void"),
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"indexOf:String;char;int->int"),
    	    	 new CheckstyleMethodCalledTestCase(
    	    	    	"main.Assignment",  		
    	    	   		"scanString:String->void"    	    	   		
    	    	   		)
    	    	
    	); 
    	// Method calls
    	addFeature("IndexOf  Called in Iterator", 5, true,

    	    	 new CheckstyleMethodCalledTestCase(
    	    	    	"ScanningIterator",    	    	   		
    	    	    	 "indexOf:String;char;int->int"));    	
    	addFeature("indexOfNot Called in Main", 3, true,
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"indexOfNot:String;char;int->int")    	    	 
    			
    	    	 );
    	addFeature("IndexOfNot Called in Iterator", 3, true,
    	   		   	    	 
    			new CheckstyleMethodCalledTestCase(
    	   				"ScanningIterator",    	    	   		
    	    	   		"indexOfNot:String;char;int->int")
    	    	 );
    	addFeature("Iterator Methods Called in Main", 10, true,
    	   		new CheckstyleMethodCalledTestCase(
    	   				"main.Assignment", 
    	   				"!hasNext:->boolean"),
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"!next:->String"));
    	
        addFeature("Screenshots enclosed", 5, new ImageEnclosedTestCase());
        addManualFeature("Screenshots show tests", 10, false);
        addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
        


    }
}
