package main;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.ConsoleSceneView;
import grail.SingletonsCreator;
import grail.collections.MyTable;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.scanner.CommandInterpreter;
import grail.scanner.ScannerBean;
import util.misc.ThreadSupport;

public class Assignment8 {

		private static final int DEGREES_ROTATE_PER_FRAME = 3;
		private static final int MOVE_DISTANCE_PER_FRAME = 2;
		
		private static final double GROWTH_SCALAR_PER_FRAME = 1.01;
		
		private static final int SHORT_DELAY = 40;
		private static final int LONG_DELAY = 2000;

		private static final int NUM_FRAMES = 25;
		
		private static final int OEFRAME_WIDTH = 1000;
		private static final int OEFRAME_HEIGHT = 500;
		
		public static void main(String[] args) throws InterruptedException {
			
			BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
			PropertyChangeListener consoleSceneView = SingletonsCreator.consoleSceneViewFactoryMethod();
			OEFrame sceneFrame = ObjectEditor.edit(scene);
			
			sceneFrame.hideMainPanel();
			sceneFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
			
			// Make guard speak
			ThreadSupport.sleep(LONG_DELAY);
			scene.getGuard().getStringShape().setText("Hi!");
			ThreadSupport.sleep(LONG_DELAY);
			
			for (int i = 0; i < NUM_FRAMES; ++i){
				scene.getGuard().move(-MOVE_DISTANCE_PER_FRAME, -MOVE_DISTANCE_PER_FRAME);
			}
			ThreadSupport.sleep(LONG_DELAY);
			
			for (int i = 0; i < NUM_FRAMES; ++i){
				Thread.sleep(SHORT_DELAY);
				scene.getGuard().getArms().getLeftLine().rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getArms().getRightLine().rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getLegs().getLeftLine().rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getLegs().getRightLine().rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
			}
			ThreadSupport.sleep(LONG_DELAY);
			for (int i = 0; i < NUM_FRAMES; ++i){
				Thread.sleep(SHORT_DELAY);
				scene.getGuard().scale(GROWTH_SCALAR_PER_FRAME);
			}
			ThreadSupport.sleep(LONG_DELAY);
			scene.getGuard().getStringShape().setText("Hello again.");
			
	}//end main
}//end class
