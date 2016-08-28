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
import gradingTools.sharedTestCase.IllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.NoWarningOrErrorTestCase;

/**
 * Created with IntelliJ IDEA.
 * User: josh
 * Date: 11/6/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Assignment1Requirements extends AJUnitProjectRequirements {

    public Assignment1Requirements() {
    	addDueDate("08/26/2016 23:55:00", 1.05);
    	addDueDate("08/28/2016 23:55:00", 1);
    	addDueDate("09/02/2016 23:55:00", 0.9);
    	addDueDate("09/04/2016 23:55:00", 0.75);
    	
        // Functionality
    	addJUnitTestSuite(Assignment1Suite.class);
//        addFeature("Process & print tokens", 40,
//                new SingleTokenTestCase(),
//                new MultipleTokensTestCase()
//              //  new RemovePrecedingZerosTestCase()
//                );
//        addFeature("Sum and product", 10,
//                new SumTestCase(),
//                new ProductTestCase());
//        addFeature("Terminates with period", 10, new TerminateWithPeriodTestCase());

        // Style
//        addFeature("Two declared methods", 3, new MinDeclaredMethodsInSameOrDifferentClassTestCase(2));
//        addFeature("One called method", 7, new MinDeclaredMethodsInSameOrDifferentClassTestCase(1));
//        addFeature("Variable spaces", 5, true, new VariableSpacesTestCase());
//        addFeature("Handle invalid chars", 5, true, new InvalidCharacterTestCase());
        addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
        addManualFeature("Use an extra class with iterator like interface", 10, true);


//        addManualFeature("Screenshots", 10, new QuestionTestCase("Screenshots included showing test data output?", "Screenshots testcase"));

        // TODO: Extra Credit
//        addManualFeature("Handle invalid chars", 5, true);
//        addManualFeature("No-array parser class", 10, true);
//        addManualFeature("Variable spaces", 5, true);
        addRestriction("Illegal import or call", 25, new IllegalImportOrCallTestCase());
//        addRestriction("Single main.Assigment", 10, new ClassDefinedTestCase("main.Assignment(.*)"));
        addRestriction("Single main.Assigment", 10, new MainClassDefinedTestCase("main.Assignment(.*)"));
        
        addFeature(INTERACTIVE_RUN, 20, true, new NoWarningOrErrorTestCase());


       
        

//        addManualFeature("Nice code", 10, true);

        // Restrictions
//        addRestriction("No .split allowed", -10, new NoSplitTestCase());

    }
}
