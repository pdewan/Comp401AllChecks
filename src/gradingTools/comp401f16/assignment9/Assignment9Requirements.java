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
	
	
		
		addDueDate("11/03/2016 00:59:00", 1.05); 	// wed before
     	addDueDate("11/05/2016 00:59:00", 1); 		// fri due
     	addDueDate("11/08/2016 00:59:00", 0.95);	// mon after due
     	addDueDate("11/12/2016 00:59:00", 0.90); 	// fri after due
     	addDueDate("12/12/2016 00:59:00", 0.85); 	// infinity
     	
     	
     	// Functionality
     	GradingMode.setGraderRun(true);
     	addJUnitTestSuite(Assignment9Suite.class);
     	
     	
     	addFeature("Public methods are in implemented interfaces", 10, 
     			new ClassHasAtLeastOneInterfaceTestCase());
     	
     	addRestriction("Variables should have interface, not class, type", 10, 
     			new CheckStyleVariableHasClassTypeTestCase());
     	
     	addRestriction("No magic numbers", 10, new CheckStyleMagicNumberTestCase());
     	
     	// A student should get either this one, or the extra credit one, but not both
     	addFeature("Normal credit view (0.0 if extra credit instead)", 15,
     			new CheckstyleMethodDefinedTestCase("InheritingBridgeScenePainter", "paint:Graphics(.*)->void"),
     			new CheckstyleInterfaceDefinedTestCase("InheritingBridgeScenePainter", "PropertyChangeListener"),
     			new CheckstyleMethodCalledTestCase("InheritingBridgeScenePainter", "repaint:->void"),
     			new CheckstyleSuperTypeDefinedTestCase("InheritingBridgeScenePainter", "Console"),
     			
     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "InheritingBridgeScenePainter")
//     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
//     					"@inheritingBridgeScenePainterFactoryMethod:->@InheritingBridgeScenePainter")
     			);
     	
     	addFeature("Extra credit view", 25, true,
     			new CheckstyleMethodDefinedTestCase("PaintListener", "paint:Graphics(.*)->void(.*)"),
     			new CheckstyleInterfaceDefinedTestCase("PaintListener", "PropertyChangeListener"),
     			new CheckstyleMethodCalledTestCase("PaintListener", "(.*)!repaint:->void"),
     			
     			new CheckstyleMethodDefinedTestCase("ObservableBridgeScenePainter", "@addPaintListener:@PaintListener->void"),
     			new CheckstyleMethodCalledTestCase("ObservableBridgeScenePainter", "@PaintListener!paint:Graphics(.*)->void(.*)"),
     			new CheckstyleSuperTypeDefinedTestCase("ObservableBridgeScenePainter", "Console"),
     			
     			new CheckstyleMethodCalledTestCase("DelegatingBridgeSceneView",
     					"@SingletonsCreator!@observableBridgeScenePainterFactoryMethod:->@ObservableBridgeScenePainter"),
     			new CheckstyleMethodCalledTestCase("DelegatingBridgeSceneView","(.*)!addPaintListener:@PaintListener->void"),
     			

     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "DelegatingBridgeSceneView"),
     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "ObservableBridgeScenePainter")
//     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
//     					"@delegatingBridgeSceneViewFactoryMethod:->@DelegatingBridgeSceneView//EC"),
//     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", 
//     					"@observableBridgeScenePainterFactoryMethod:->@ObservableBridgeScenePainter//EC")
     			);
     			
     	addFeature("BridgeSceneController", 12, 
     			new CheckstyleInterfaceDefinedTestCase("BridgeSceneController", "MouseListener"),
     			new CheckstyleInterfaceDefinedTestCase("BridgeSceneController", "KeyListener"),
     			new CheckstyleMethodCalledTestCase("BridgeSceneController", "(.*)!addKeyListener:KeyListener->void"),
     			new CheckstyleMethodCalledTestCase("BridgeSceneController", "(.*)!addMouseListener:MouseListener->void")     					
     			);
     	addManualFeature("Clicking and pressing buttons in display works correctly", 8);		
     	
     	addFeature("CommandInterpreter controller", 3, true,
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "TextField", "JTextField"),
     			new CheckstyleMethodCalledTestCase("CommandInterpreterController", "@CommandInterpreter!setCommand:String->void"),
     			
     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "CommandInterpreterController")
//     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@commandInterpreterControllerFactoryMethod:->@CommandInterpreterController")
     			);
     	addManualFeature("CommandInterpreter controller issues commands correctly", 7,true);
     	
     	addFeature("CommandInterpreter view", 3, true,
     			
     			new CheckstyleInterfaceDefinedTestCase("ObservableCommandInterpreter", "PropertyListenerRegisterer"),
     			new CheckstyleMethodDefinedTestCase("CommandInterpreterView", "PropertyChangeListener"),
     			
     			new CheckstyleClassInstantiatedTestCase("SingletonsCreator", "CommandInterpreterView")
//     			new CheckstyleMethodDefinedTestCase("SingletonsCreator", "@commandInterpreterViewFactoryMethod:->@CommandInterpreterView")
     			);
     	addManualFeature("CommandInterpreter view shows error property correctly", 5,true);
     	
     	addFeature("Menu item and button", 3, true,
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "MenuItem", "JMenuItem"),
     			new CheckStylePropertyDefinedTestCase("CommandInterpreterController", "Button", "JButton"),
     			new CheckstyleInterfaceDefinedTestCase("CommandInterpreterController", "ActionListener")
     			);
   	addManualFeature("Menu item and button result in some action in display", 7, true);
     	
     	// This should only give 2 points since students will only have one but not the other
     	addFeature("Progress bar or slider (max 2.0)", 4, true,
     			new CheckStylePropertyDefinedTestCase("ProgressBarCreator", "ProgressBar", "JProgressBar"),
     			new CheckStylePropertyDefinedTestCase("ProgressBarCreator", "Slider", "JSlider")
     			);
     	addManualFeature("Progress bar or slider works", 4, true);
     	
     	addManualFeature("Animation shows function of command interpreter and correct output in all frames", 15, false); 
     	
     	addManualRestriction(INTERACTIVE_RUN, 5, 
     			new NoWarningOrErrorTestCase("No OE Warnings", ".*(efresh|not in range).*", null, 0.3));
     	
     	addRestriction("Illegal import or call", 25, new CheckStyleIllegalImportOrCallTestCase());
      
	}//end method
}
