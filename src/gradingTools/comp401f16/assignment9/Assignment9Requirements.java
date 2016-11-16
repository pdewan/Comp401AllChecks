package gradingTools.comp401f16.assignment9;

import java.awt.event.ActionEvent;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.junit.AJUnitProjectRequirements;
import gradingTools.comp401f16.assignment1.testcases.ImageEnclosedTestCase;
import gradingTools.comp401f16.assignment7.testcases.Assignment7Suite;
import gradingTools.comp401f16.assignment9.testcases.Assignment9Suite;
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

public class Assignment9Requirements  extends AJUnitProjectRequirements{
	public Assignment9Requirements(){
	
	BasicProjectExecution.setUseMethodAndConstructorTimeOut(false);
	BasicProjectExecution.setUseProcessTimeOut(false);
		
		addDueDate("11/03/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("11/05/2016 00:59:00", 1); 		// fri due
     	addDueDate("11/08/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("11/12/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/05/2016 00:59:00", 0.85); 	// infinity
     	
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment9Suite.class);
     	
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
     	
     	// A student should get either this one, or the extra credit one, but not both
     	addFeature("Normal credit view", 15,
     			new CheckstyleMethodDefinedTestCase("InheritingBridgeScenePainter", "paint:Graphics(.*)->void"),
     			new CheckstyleMethodDefinedTestCase("InheritingBridgeScenePainter", "propertyChange:PropertyChangeEvent->void"),
     			new CheckstyleSuperTypeDefinedTestCase("InheritingBridgeScenePainter", "Console"),
     			new CheckstyleConstructorDefinedTestCase("InheritingBridgeScenePainter", ":"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
     					"@inheritingBridgeScenePainterFactoryMethod:->@InheritingBridgeScenePainter")
     			);
     	
     	addFeature("Extra credit view", 35, true,
     			new CheckstyleMethodDefinedTestCase("PaintListener", "paint:Graphics2D->void(.*)"),
     			new CheckstyleMethodDefinedTestCase("PaintListener", "propertyChange:PropertyChangeEvent->void"),
     			new CheckstyleMethodCalledTestCase("PaintListener", "@ObservableBridgeScenePainter!repaint:->void"),
     			
     			new CheckstyleMethodDefinedTestCase("ObservableBridgeScenePainter", "@addPaintListener:@PaintListener->void"),
     			new CheckstyleMethodCalledTestCase("ObservableBridgeScenePainter", "@PaintListener!paint:Graphics2D->void(.*)"),
     			new CheckstyleSuperTypeDefinedTestCase("ObservableBridgeScenePainter", "Console"),
     			
     			new CheckstyleMethodCalledTestCase("DelegatingBridgeSceneView",
     					"@SingletonsCreator!@observableBridgeScenePainterFactoryMethod:->@ObservableBridgeScenePainter"),
     			new CheckstyleMethodCalledTestCase("DelegatingBridgeSceneView","(.*)!addPaintListener:@PaintListener->void"),
     			
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
     					"@delegatingBridgeSceneViewFactoryMethod:->@DelegatingBridgeSceneView//EC"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
     					"@observableBridgeScenePainterFactoryMethod:->@ObservableBridgeScenePainter//EC")
     			);
     			
     	addFeature("BridgeSceneController", 12, 
     			new CheckstyleInterfaceDefinedTestCase("BridgeSceneController", "MouseListener"),
     			new CheckstyleInterfaceDefinedTestCase("BridgeSceneController", "KeyListener"),
     			new CheckstyleMethodCalledTestCase("BridgeSceneController", "(.*)!addKeyListener:KeyListener->void"),
     			new CheckstyleMethodCalledTestCase("BridgeSceneController", "(.*)!addMouseListener:MouseListener->void")     					
     			);
     			
     	addFeature("CommandInterpreter controller", 8, true,
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "TextField", "JTextField"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreterController", "@CommandInterpreter!setCommand:String->*"),
     			new CheckstyleClassInstantiatedTestCase("CommandInterpreterController", "JTextField"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@commandInterpreterControllerFactoryMethod:->@CommandInterpreterController")
     			);
     	addManualFeature("CommandInterpreter controller updates command correctly", 7,true);
     	
     	addFeature("CommandInterpreter view", 6, true,
     			
     			new CheckstyleMethodDefinedTestCase("ObservableCommandInterpreter", "addPropertyChangeListener:PropertyChangeListener->void"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreterView", "propertyChange:PropertyChangeEvent->void"),
     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@commandInterpreterViewFactoryMethod:->@CommandInterpreterView")
     			);
     	addManualFeature("CommandInterpreter view updates correctly as command changes", 6,true);
     	
     	addFeature("Menu item and button", 6, true,
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "MenuItem", "JTextField"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Button", "JButton"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreterController", "actionPerformed:ActionEvent->void")
     			);
   	addManualFeature("Menu item and button result in some action in display", 6, true);
     	
     	// This should only give 2 points since students will only have one but not the other
     	addFeature("Progress bar or slider", 4, true,
     			new CheckStylePropertyDefinedTestCase("ProgressBarCreator", "ProgressBar", "JProgressBar"),
     			new CheckStylePropertyDefinedTestCase("ProgressBarCreator", "Slider", "JSlider")
     			);
     	addManualFeature("Progress bar or slider works", 5, true);
     	
     	
     	addFeature("Command interpreter has errors property", 2,
     			new CheckStylePropertyDefinedTestCase("CommandInterpreter", "Errors", "*"));
     	
     	addManualFeature("Animation shows function of command interpreter and correct output in all frames", 15, false); 
     	addManualFeature("Table demonstrated in console, works correctly", 8, false);
     	
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
