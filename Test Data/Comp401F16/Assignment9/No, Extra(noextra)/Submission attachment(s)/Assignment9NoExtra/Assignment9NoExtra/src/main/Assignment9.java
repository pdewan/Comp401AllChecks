package main;

import java.awt.Component;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.BridgeSceneControllerInterface;
import util.misc.ThreadSupport;

public class Assignment9 {

		private static final int LONG_DELAY = 2000;

		private static final int OEFRAME_WIDTH = 1000;
		private static final int OEFRAME_HEIGHT = 500;
		
		public static void main(String[] args) throws InterruptedException {
			
			BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();

			PropertyChangeListener view = SingletonsCreator.inheritingBridgeScenePainterFactoryMethod();
			OEFrame sceneFrame = ObjectEditor.edit(scene);
			
			CommandInterpreterInterface commandInterpreter = SingletonsCreator.commandInterpreterFactoryMethod();
			OEFrame interpreter = ObjectEditor.edit(commandInterpreter);
			
			BridgeSceneControllerInterface controller = SingletonsCreator.bridgeSceneControllerFactoryMethod();
			
			JFrame frame = new JFrame("Bridge Scene");
			frame.add((Component)view);
			frame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
			frame.setVisible(true);
			
			sceneFrame.hideMainPanel();
			
			sceneFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
			interpreter.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
			
			// Make guard speak
			ThreadSupport.sleep(LONG_DELAY);
			scene.getArthur().move(100, 100);
			ThreadSupport.sleep(LONG_DELAY);
			scene.getArthur().getStringShape().setText("Hi!");
			ThreadSupport.sleep(LONG_DELAY);
			scene.getArthur().move(100, 100);
			ThreadSupport.sleep(LONG_DELAY);
			
		}//end main
}//end class
