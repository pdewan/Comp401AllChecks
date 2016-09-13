package gradingTools.comp401f16.assignment1;

import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f15.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment1.testcases.Assignment1Suite;
import gradingTools.shared.testcases.CheckstyleMethodCalledTestCase;
import gradingTools.shared.testcases.IllegalImportOrCallTestCase;


public class Assignment1Requirements extends AJUnitProjectRequirements {
	public static final String MAIN_SUBSTRING = "main.Assignment";
	public static final String ITERATOR_SUSTRING = "ScanningIterator";
    public Assignment1Requirements() {
    	addDueDate("09/01/2016 00:59:00", 1.05); // wed before
    	addDueDate("09/03/2016 00:59:00", 1); // fri due
    	addDueDate("09/06/2016 00:59:00", 0.95);// mon after due
    	addDueDate("09/10/2016 00:59:00", 0.85); // fri after due
    	addDueDate("12/05/2016 00:59:00", 0.8); // infinity
    	
        // Functionality
    	addJUnitTestSuite(Assignment1Suite.class);
    	GradingMode.setGraderRun(true);
    	
    	// Method calls
    	addFeature("3 Required Methods Called in Main or Iterator (max 15pts)", 18, 
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
    	    	   		),
    	    	 new CheckstyleMethodCalledTestCase(
    	    	    	"ScanningIterator",    	    	   		
    	    	    	 "indexOf:String;char;int->int")); 
    	    	
    	addFeature("indexOfNot Called in Main or Iterator (max 3pts)", 6, true,
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"indexOfNot:String;char;int->int"),
    	    	 
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
    	
        addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
        addRestriction("Illegal import or call", 25, new IllegalImportOrCallTestCase());
        


    }
}
