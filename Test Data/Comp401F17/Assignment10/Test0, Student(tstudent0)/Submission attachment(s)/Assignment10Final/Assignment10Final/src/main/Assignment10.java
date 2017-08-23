package main;

import java.awt.Component;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import grail.mvc.view.CommandInterpreterView;
import grail.mvc.view.ConsoleSceneView;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})
public class Assignment10 {

		private static JProgressBar progressBar;
		private static final int BAR_ROWS = 1;
		private static final int BAR_COLUMNS = 1;
		private static final int BAR_WIDTH = 500;
		private static final int BAR_HEIGHT = 100;
		
		private static final int PROGRESS_BAR_MAX = 100;
		private static final int BAR_INCREMENT = 25;
		
		private static final int LONG_DELAY = 1500;

		private static final int OEFRAME_WIDTH = 1000;
		private static final int OEFRAME_HEIGHT = 500;
		
		private static final int SCENE_VIEW_WIDTH = 1500;
		private static final int SCENE_VIEW_HEIGHT = 500;
		
		private static final int INTERPRETER_VIEW_WIDTH = 300;
		private static final int INTERPRETER_VIEW_HEIGHT = 300;
		
		private static final int INTERPRETER_OE_WIDTH = 300;
		private static final int INTERPRETER_OE_HEIGHT = 500;
		
		private static final String SAY_COMMAND = "say \"Hello!\"";

		
		public static void main(String[] args) throws InterruptedException {
			// Model
			BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
			
			// Painting view
			DelegatingBridgeSceneViewInterface sceneView = SingletonsCreator.delegatingBridgeSceneViewFactoryMethod();
			PaintingViewMaster sceneViewComponent = SingletonsCreator.observableBridgeScenePainterFactoryMethod();
			
			JFrame sceneFrame = new JFrame("Bridge Scene");
			sceneFrame.add((Component)sceneViewComponent);
			sceneFrame.setSize(SCENE_VIEW_WIDTH, SCENE_VIEW_HEIGHT);
			sceneFrame.setVisible(true);
			
			// Console view
			PropertyChangeListener consoleView = new ConsoleSceneView();
			
			
			// Command Interpreter:
			// Model
			CommandInterpreterInterface commandInterpreter = SingletonsCreator.commandInterpreterFactoryMethod();
			
			// View
			CommandInterpreterViewInterface interpreterView = SingletonsCreator.commandInterpreterViewFactoryMethod();
			JFrame interpreterFrame = (CommandInterpreterView)interpreterView;
			interpreterFrame.setSize(INTERPRETER_VIEW_WIDTH, INTERPRETER_VIEW_HEIGHT);
			interpreterFrame.setVisible(true);
			
			// Controller
			CommandInterpreterControllerInterface interpreterController = SingletonsCreator.commandInterpreterControllerFactoryMethod();
			
			
			// Demo
			ThreadSupport.sleep(LONG_DELAY);
			scene.approach(scene.getLancelot());
			ThreadSupport.sleep(LONG_DELAY);
			commandInterpreter.setCommand(SAY_COMMAND);
			ThreadSupport.sleep(LONG_DELAY);
			commandInterpreter.setCommand(SAY_COMMAND);
			ThreadSupport.sleep(LONG_DELAY);
			scene.passed();
			ThreadSupport.sleep(LONG_DELAY);
			
			// Animations
			commandInterpreter.animateArthur();
			commandInterpreter.animateGalahad();
			commandInterpreter.animateLancelot();
			commandInterpreter.animateRobin();
			commandInterpreter.clapGuard();
			
		}//end main
		
		public static JProgressBar getProgressBar(){
			return progressBar;
		}
}//end class
