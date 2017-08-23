package main;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.BridgeSceneControllerInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import grail.mvc.view.CommandInterpreterView;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})
public class Assignment9 {

		private static JProgressBar progressBar;
		private static final int BAR_ROWS = 1;
		private static final int BAR_COLUMNS = 1;
		private static final int BAR_WIDTH = 500;
		private static final int BAR_HEIGHT = 100;
		
		private static final int PROGRESS_BAR_MAX = 100;
		private static final int BAR_INCREMENT = 25;
		
		private static final int LONG_DELAY = 2000;

		private static final int OEFRAME_WIDTH = 1000;
		private static final int OEFRAME_HEIGHT = 500;
		
		private static final int SCENE_VIEW_WIDTH = 1000;
		private static final int SCENE_VIEW_HEIGHT = 500;
		
		private static final int INTERPRETER_VIEW_WIDTH = 300;
		private static final int INTERPRETER_VIEW_HEIGHT = 150;
		
		private static final int INTERPRETER_OE_WIDTH = 300;
		private static final int INTERPRETER_OE_HEIGHT = 500;
		
		private static final int MOVE_DISTANCE = 100;
		
		public static void main(String[] args) throws InterruptedException {
			
			// Model
			BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();

			// View
			DelegatingBridgeSceneViewInterface sceneView = SingletonsCreator.delegatingBridgeSceneViewFactoryMethod();
			PaintingViewMaster sceneViewComponent = SingletonsCreator.observableBridgeScenePainterFactoryMethod();
			
			JFrame sceneFrame = new JFrame("Bridge Scene");
			sceneFrame.add((Component)sceneViewComponent);
			sceneFrame.setSize(SCENE_VIEW_WIDTH, SCENE_VIEW_HEIGHT);
			sceneFrame.setVisible(true);
			
			
			// Controller
			BridgeSceneControllerInterface controller = SingletonsCreator.bridgeSceneControllerFactoryMethod();
			
			
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
			
			
			// OE displays
			OEFrame sceneOEFrame = ObjectEditor.edit(scene);
			sceneOEFrame.hideMainPanel();
			sceneOEFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
			
			OEFrame interpreterOEFrame = ObjectEditor.edit(commandInterpreter);
			interpreterOEFrame.setSize(INTERPRETER_OE_WIDTH, INTERPRETER_OE_HEIGHT);
			
			//Create progress bar
			progressBar = new JProgressBar(0, PROGRESS_BAR_MAX);
			JFrame barFrame = new JFrame();
			barFrame.setSize(BAR_WIDTH,BAR_HEIGHT);
			barFrame.setLayout(new GridLayout(BAR_ROWS, BAR_COLUMNS));
			barFrame.add(progressBar);
			barFrame.setVisible(true);
			
			// Make guard speak
			getProgressBar().setValue(getProgressBar().getValue() + BAR_INCREMENT);
			ThreadSupport.sleep(LONG_DELAY);
			getProgressBar().setValue(getProgressBar().getValue() + BAR_INCREMENT);
			scene.getArthur().move(MOVE_DISTANCE, MOVE_DISTANCE);
			ThreadSupport.sleep(LONG_DELAY);
			getProgressBar().setValue(getProgressBar().getValue() + BAR_INCREMENT);
			scene.getArthur().getStringShape().setText("Hi!");
			ThreadSupport.sleep(LONG_DELAY);
			getProgressBar().setValue(getProgressBar().getValue() + BAR_INCREMENT);
			scene.getArthur().move(MOVE_DISTANCE, MOVE_DISTANCE);
			ThreadSupport.sleep(LONG_DELAY);
			
		}//end main
		
		public static JProgressBar getProgressBar(){
			return progressBar;
		}
}//end class
