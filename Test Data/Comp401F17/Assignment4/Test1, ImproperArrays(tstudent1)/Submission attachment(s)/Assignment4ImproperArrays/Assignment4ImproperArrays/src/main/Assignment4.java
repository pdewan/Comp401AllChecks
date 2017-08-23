package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.ScannerBean;
import grail.interfaces.RotatingLineInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.shapes.RotatingLine;
import util.misc.ThreadSupport;

public class Assignment4 {
	
	private static final int ROTATIONS = 60; //for rotating line
	private static final int TIME_BETWEEN_ROTATIONS = 100;
	
	private static final int TIME_BETWEEN_UPDATES = 3000;
	private static final String[] TEST_STRINGS = {
			"{ } - + 0029",
			"\" quoted string! \" someWORD er$$or e#ror",
			"aPproacH FAil mOve PaSS",
			"repEaT Say cAll defINE PROCeed",
			"redo ROTATELEFTARM RotateRightArm slEep THread",
			"Undo waiT M#re eR1ors"
	};
	
	public static void main(String[] args) {

		ScannerBeanInterface myScanner = new ScannerBean();
		OEFrame oeFrame = ObjectEditor.edit(myScanner);
		
		// Animate the properties
		for (int i= 0; i < TEST_STRINGS.length; ++i){
			myScanner.setScannedString(TEST_STRINGS[i]);
			oeFrame.refresh();
			ThreadSupport.sleep(TIME_BETWEEN_UPDATES);
		}
		
		// Animate rotating line
		RotatingLineInterface myLine = new RotatingLine(100, 100, 100, 0);
		oeFrame = ObjectEditor.edit(myLine);
		for (int i = 0; i < ROTATIONS ; ++i){
			myLine.rotateByClockwiseDegrees(6);
			oeFrame.refresh();
			ThreadSupport.sleep(TIME_BETWEEN_ROTATIONS);
		}
		
	}//end main
}//end class
