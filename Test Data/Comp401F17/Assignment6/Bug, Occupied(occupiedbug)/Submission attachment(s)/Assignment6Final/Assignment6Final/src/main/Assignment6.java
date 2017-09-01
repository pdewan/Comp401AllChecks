package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.ScannerBean;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.ScannerBeanInterface;
import util.misc.ThreadSupport;

public class Assignment6 {
	
	private static final int QUICK_DELAY = 20;
	private static final int SLOW_DELAY = 1000;
	
	private static final int NUM_FRAMES_PER_SCROLL = 15;
	private static final int SCROLL_AMOUNT = 10;
	
	private static final int OEFRAME_WIDTH = 1500;
	private static final int OEFRAME_HEIGHT = 1000;
	
	private static final String[] TEST_STRINGS = {
			"{ } - + 0029",
			"\" quoted string! \" someWORD er$$or e#ror",
			"aPproacH FAil mOve PaSS",
			"repEaT Say cAll defINE PROCeed",
			"redo ROTATELEFTARM RotateRightArm slEep THread",
			"Undo waiT M#re eR1ors"
	};
	
	public static void main(String[] args) {
		
		BridgeSceneInterface scene = new BridgeScene();
		OEFrame oeFrame = ObjectEditor.edit(scene);
		oeFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
		
		// Show off scrolling
		for (int i = 0; i < NUM_FRAMES_PER_SCROLL; ++i){
			scene.scroll(SCROLL_AMOUNT, 0);
			oeFrame.refresh();
			ThreadSupport.sleep(QUICK_DELAY);
		}
		for (int i = 0; i < NUM_FRAMES_PER_SCROLL; ++i){
			scene.scroll(0, SCROLL_AMOUNT);
			oeFrame.refresh();
			ThreadSupport.sleep(QUICK_DELAY);
		}
		for (int i = 0; i < NUM_FRAMES_PER_SCROLL; ++i){
			scene.scroll(-SCROLL_AMOUNT, 0);
			oeFrame.refresh();
			ThreadSupport.sleep(QUICK_DELAY);
		}
		for (int i = 0; i < NUM_FRAMES_PER_SCROLL; ++i){
			scene.scroll(0, -SCROLL_AMOUNT);
			oeFrame.refresh();
			ThreadSupport.sleep(QUICK_DELAY);
		}
		
		// Animate interactions
		scene.approach(scene.getLancelot());
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("What is your name?");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("Lancelot.");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("Off you go.");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.passed();
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.approach(scene.getGalahad());
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("What is your frame?");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("Beg your pardon?");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.failed();
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);

		scene.approach(scene.getArthur());
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);

		scene.say("What is your game?");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);

		scene.say("I'll give you one chance to guess.");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.say("What?");
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		scene.failed();
		oeFrame.refresh();
		ThreadSupport.sleep(SLOW_DELAY);
		
		// Animate ScannerBean
		ScannerBeanInterface myScanner = new ScannerBean();
		OEFrame oeFrame2 = ObjectEditor.edit(myScanner);
		oeFrame2.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
		for (int i= 0; i < TEST_STRINGS.length; ++i){
			myScanner.setScannedString(TEST_STRINGS[i]);
			oeFrame2.refresh();
			ThreadSupport.sleep(SLOW_DELAY);
		}
	}//end main
}//end class
