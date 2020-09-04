package gradingTools.comp401f18.assignment2;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import grader.trace.GraderTraceUtility;
import gradingTools.comp401f17.assignment2.testcases.Assignment2Suite;
import gradingTools.sharedTestCase.ImageEnclosedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckStyleIllegalImportOrCallTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleClassInstantiatedTestCase;
import gradingTools.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import trace.gradingTools.comp401.Comp401TraceUtility;

public class Assignment2Requirements extends AJUnitProjectRequirements {

	public Assignment2Requirements() {
     	addDueDate("09/06/2018 00:59:00", 1.05);	// wed before + 1hr
     	addDueDate("09/08/2018 00:59:00", 1);		// fri due + 1hr
     	addDueDate("09/12/2018 00:59:00", 0.90);	// tue after due + 1hr
     	addDueDate("09/22/2018 00:59:00", 0.75);	// fri after due + 1hr, shifted due to hurricane
     	addDueDate("09/22/2018 00:59:01", 0);	// fri after due + 1hr, shifted due to hurricane
//		addDueDate("12/07/2017 03:00:00", 1);

		BasicProjectExecution.setReRunInfiniteProcesses(true);
		// Functionality
		GraderTraceUtility.setTracing();
		Comp401TraceUtility.setTracing();
		addJUnitTestSuite(Assignment2Suite.class);
		GradingMode.setGraderRun(true);

		// Method calls
		addFeature("ScanString and IndexOf not called in ScannerBean", 10,
				new CheckstyleMethodCalledTestCase("ScannerBean", "scanString:String->void"),
				new CheckstyleMethodCalledTestCase("ScannerBean", "indexOf:String;char;int->int"));
		// Method calls
		addFeature("IndexOf called in ScanningIterator", 5, true,
				new CheckstyleMethodCalledTestCase("ScanningIterator", "indexOf:String;char;int->int"));

		// Classes Instantiated
		addFeature("Scanner Bean Instantiated in Corectly Named Main", 5,
				new CheckstyleClassInstantiatedTestCase("main.Assignment2", "ScannerBean"));

		addFeature("Screenshots enclosed", 10, new ImageEnclosedTestCase());
		addManualFeature("Breakpoint step into/over/return screenhots", 20);

		// addFeature("Scanner Bean Tagged Correctly ", 5, new
		// ClassDefinedTestCase("@ScannerBean"));
		addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());

	}
}
