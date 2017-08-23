package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import util.misc.ThreadSupport;

public class Assignment5 {
	
	private static final int DEGREES_ROTATE_PER_FRAME = 3;
	private static final int LEG_ROTATION_SPAN = 10;
	private static final int ARM_ROTATION_SPAN = 90;
	private static final int NUM_FRAMES = 200;
	private static final int TIME_BETWEEN_UPDATES = 20;
	
	private static final double GROWTH_SCALAR_PER_FRAME = 1.01;
	
	private static final int HORIZONTAL_MOVEMENT_PER_FRAME = 5;
	private static final int VERTICAL_MOVEMENT_PER_FRAME = 2;
	
	
	public static void main(String[] args) {
		
		BridgeSceneInterface scene = new BridgeScene();
		OEFrame oeFrame = ObjectEditor.edit(scene);
		
		// Make guard speak
		scene.getGuard().getStringShape().setText("AAAAH!");
		
		
		// This part is a little overboard, but I made the character wave and run
		// This requires keeping track of how much his arms and legs have moved
		int armDegreesRotated = 0;
		int legDegreesRotated = 0;
		
		for (int i = 0; i < NUM_FRAMES; ++i){
			ThreadSupport.sleep(TIME_BETWEEN_UPDATES);
			oeFrame.refresh();
			
			// Each frame, move the guard
			scene.getGuard().move(-HORIZONTAL_MOVEMENT_PER_FRAME, VERTICAL_MOVEMENT_PER_FRAME);
			
			// Each frame, grow the guard
			scene.getGuard().scale(GROWTH_SCALAR_PER_FRAME);
			
			// First ARM_ROTATION_SPAN degrees, move one way, then the other, then switch again
			if ((int)(armDegreesRotated/ARM_ROTATION_SPAN) % 2 == 0){
				scene.getGuard().getArms().getRightLine()
					.rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getArms().getLeftLine()
					.rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
			} else {
				scene.getGuard().getArms().getRightLine()
					.rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getArms().getLeftLine()
					.rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
			}
			armDegreesRotated += DEGREES_ROTATE_PER_FRAME;
			
			// Do same thing for legs
			if ((int)(legDegreesRotated/LEG_ROTATION_SPAN) % 2 == 0){
				scene.getGuard().getLegs().getRightLine()
					.rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getLegs().getLeftLine()
					.rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
			} else {
				scene.getGuard().getLegs().getRightLine()
					.rotateByClockwiseDegrees(-DEGREES_ROTATE_PER_FRAME);
				scene.getGuard().getLegs().getLeftLine()
					.rotateByClockwiseDegrees(DEGREES_ROTATE_PER_FRAME);
			}
			legDegreesRotated += DEGREES_ROTATE_PER_FRAME;
		}
		
	}//end main
}//end class
