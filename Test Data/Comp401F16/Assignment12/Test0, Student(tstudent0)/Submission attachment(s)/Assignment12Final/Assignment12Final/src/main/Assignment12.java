package main;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.SingletonsCreator;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import grail.mvc.view.CustomSwingTextFieldFactory;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})
public class Assignment12 {

		private static JProgressBar progressBar;
		private static final int BAR_ROWS = 1;
		private static final int BAR_COLUMNS = 1;
		private static final int BAR_WIDTH = 500;
		private static final int BAR_HEIGHT = 100;
		
		private static final int PROGRESS_BAR_MAX = 100;
		private static final int BAR_INCREMENT = 25;
		
		private static final int SCENE_VIEW_WIDTH = 1500;
		private static final int SCENE_VIEW_HEIGHT = 500;
		
		private static final int LOCKSTEP_CLAPS = 30;
		
		private static final String[] COMMAND_LIST = {
				"move aRThur 50 0",
				"moVE arthur - 30 - 50",
				"UnDO",
				"ReDo",
				"approach arthur", 
				"{ say \"Hello!\" sleep 1000 say \"Howdy\" sleep 1000 pass }",
				"{ approach galahad }",
				"define rotate { rotateLeftArm galahad - 6 rotateRightArm guard 6 }",
				"define together { say \"one\" call rotate sleep 1000 say \"two\" call rotate }",
				"define routine { repeat 10 { call together sleep 1000 } }",
				"call routine"
		};

		
		public static void main(String[] args) throws InterruptedException {
			
			ObjectEditor.initialize();
			bus.uigen.widgets.TextFieldSelector.setTextFieldFactory(new CustomSwingTextFieldFactory());
			
			// Model
			BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
			
			// Painting view
			DelegatingBridgeSceneViewInterface sceneView = SingletonsCreator.delegatingBridgeSceneViewFactoryMethod();
			PaintingViewMaster sceneViewComponent = SingletonsCreator.observableBridgeScenePainterFactoryMethod();
			
			JFrame sceneFrame = new JFrame("Bridge Scene");
			sceneFrame.add((Component)sceneViewComponent);
			sceneFrame.setSize(SCENE_VIEW_WIDTH, SCENE_VIEW_HEIGHT);
			sceneFrame.setVisible(true);
			
			
			//Clearance manager
			BroadcastingClearanceManager clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();
			OEFrame clearanceManagerFrame = ObjectEditor.edit(clearanceManager);
			
			
			// Command Interpreter:
			// Model
			CommandInterpreterInterface commandInterpreter = SingletonsCreator.commandInterpreterFactoryMethod();
			
			// View
			OEFrame interpreterFrame = ObjectEditor.edit(commandInterpreter);
			
			// Demo of waiting methods
			commandInterpreter.waitingArthur();
			commandInterpreter.waitingGalahad();
			commandInterpreter.waitingRobin();
			commandInterpreter.waitingLancelot();
			
			clearanceManager.waitForProceed();
			
			for (int i = 0; i < COMMAND_LIST.length; ++i){
				clearanceManager.waitForProceed();
				commandInterpreter.setCommand(COMMAND_LIST[i]);
			}
			
			// Demo of lockstep methods: has to come after the others
			// because it makes threads proceed
			commandInterpreter.lockstepArthur();
			for (int i = 0; i < LOCKSTEP_CLAPS; ++i){
				commandInterpreter.lockstepGuard();
			}
		}//end main
		
		public static JProgressBar getProgressBar(){
			return progressBar;
		}
}//end class
