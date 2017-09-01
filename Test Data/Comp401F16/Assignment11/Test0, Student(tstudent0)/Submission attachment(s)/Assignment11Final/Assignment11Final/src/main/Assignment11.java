package main;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})
public class Assignment11 {

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
		
		private static final String[] COMMAND_LIST = {"approach arthur", 
				"{ say \"Hello!\" say \"Howdy\" pass }", 
				"{ approach galahad repeat 3 { move galahad 10 10 say \"Hi!\" } }",
				"move robin - 20 - 20"
		};

		
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
			
			// Command Interpreter:
			// Model
			CommandInterpreterInterface commandInterpreter = SingletonsCreator.commandInterpreterFactoryMethod();
			
			// View
			OEFrame interpreterFrame = ObjectEditor.edit(commandInterpreter);
			
			
			// Demo of asynchronous animations
			commandInterpreter.animateArthur();
			commandInterpreter.animateArthur();
			commandInterpreter.animateLancelot();
			
			ThreadSupport.sleep(LONG_DELAY);
			
			for (int i = 0; i < COMMAND_LIST.length; ++i){
				ThreadSupport.sleep(LONG_DELAY);
				commandInterpreter.setCommand(COMMAND_LIST[i]);
			}
			
		}//end main
		
		public static JProgressBar getProgressBar(){
			return progressBar;
		}
}//end class
