package gradingTools.comp401f16.assignment1;

import framework.grading.FrameworkProjectRequirements;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.assignment1.testCases.MultipleTokensTestCase;
import gradingTools.assignment1.testCases.ProductTestCase;
import gradingTools.assignment1.testCases.SingleTokenTestCase;
import gradingTools.assignment1.testCases.SumTestCase;
import gradingTools.assignment6.testCases.QuestionTestCase;
import gradingTools.comp401f15.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f15.assignment1.testcases.InvalidCharacterTestCase;
import gradingTools.comp401f15.assignment1.testcases.MainClassDefinedTestCase;
import gradingTools.comp401f15.assignment1.testcases.MinDeclaredMethodsInSameOrDifferentClassTestCase;
import gradingTools.comp401f15.assignment1.testcases.TerminateWithPeriodTestCase;
import gradingTools.comp401f15.assignment1.testcases.VariableSpacesTestCase;
import gradingTools.comp401f16.assignment1.testcases.Assignment1Suite;
import gradingTools.sharedTestCase.CheckstyleMethodCalledTestCase;
import gradingTools.shared.testcases.IllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;


public class Assignment1Requirements extends AJUnitProjectRequirements {
	public static final String MAIN_SUBSTRING = "main.Assignment";
	public static final String ITERATOR_SUSTRING = "ScanningIterator";
    public Assignment1Requirements() {
    	addDueDate("08/31/2016 23:59:00", 1.05); // wed before
    	addDueDate("09/02/2016 23:59:00", 1); // fri due
    	addDueDate("09/05/2016 23:55:00", 0.95);// mon after due
    	addDueDate("09/09/2016 23:55:00", 0.85); // fri after due
    	addDueDate("12/04/2016 23:55:00", 0.8); // infinity

        // Functionality
    	addJUnitTestSuite(Assignment1Suite.class);
    	// Method calls
    	addFeature("3 Required Methods Called in Main or Iterator (max 15pts)", 18, 
//    	   		new CheckstyleMethodDefinedTestCase("Parser", 	"@parseNumber:\\*->\\*"),
    	   		new CheckstyleMethodCalledTestCase(
    	   				"main.Assignment", 
    	   				"processInput:->void"),
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"indexOf:String;char"),
    	    	 new CheckstyleMethodCalledTestCase(
    	    	    	"main.Assignment",  		
    	    	   		"scanString:String->void"    	    	   		
    	    	   		),
    	    	 new CheckstyleMethodCalledTestCase(
    	    	    	"ScanningIterator",    	    	   		
    	    	    	 "indexOf:String;char")); 
    	    	
    	addFeature("indexOfNot Called in Main or Iterator (max 3pts)", 6, true,
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"indexOfNot:String;char"),
    	    	 
    			new CheckstyleMethodCalledTestCase(
    	   				"ScanningIterator",    	    	   		
    	    	   		"indexOfNot:String;char")
    	    	 );
    	    	 
    	addFeature("Iterator Methods Called in Main", 10, true,
    	   		new CheckstyleMethodCalledTestCase(
    	   				"main.Assignment", 
    	   				"\\(\\.\\*\\)!hasNext:->boolean"),
    	   		new CheckstyleMethodCalledTestCase(
    	    	   		"main.Assignment",    	    	   		
    	    	   		"\\(\\.*\\)!next:->String"));
    	
        addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
        addRestriction("Illegal import or call", 25, new IllegalImportOrCallTestCase());
        


    }
}
