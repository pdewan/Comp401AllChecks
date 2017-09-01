package main;
import java.util.Scanner;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.interfaces.*;
import grail.scanner.*;
import grail.shapes.*;
import util.misc.ThreadSupport;


public class Assignment5 {

	public static void main(String[] args) {
//		processInput();
//		animatingScanner();
//		ThreadSupport.sleep(3000);
//		animatingLine();
		animatingBridge();
	}
	
	public static void animatingBridge() {
		BridgeScene newBridge = new ABridgeScene();
		OEFrame newFrame = ObjectEditor.edit(newBridge);
		newFrame.setSize(1000, 1000);
		newFrame.showTreePanel();
		ThreadSupport.sleep(3000);
		newBridge.getArthur().moveAll(0, 300);
		newFrame.refresh();
		ThreadSupport.sleep(3000);
		newBridge.getArthur().moveAll(-200, 0);
		newFrame.refresh();
		ThreadSupport.sleep(3000);
		newBridge.getArthur().getArms().getLeftLine().rotate(8);
		newFrame.refresh();
		ThreadSupport.sleep(3000);
		newBridge.getArthur().getArms().getLeftLine().rotate(-8);
		newFrame.refresh();
		ThreadSupport.sleep(3000);
		newBridge.getArthur().scaleAvatar(1.5);
		newFrame.refresh();
	}

	public static void animatingScanner() {
		InputScanner scanner = new StringScanner();
		OEFrame scannerFrame = ObjectEditor.edit(scanner);
		scanner.setScannedString("appROACH MoVe { saY CAlL dEFINe fail - 00500 \"hi!\" } ");
		scannerFrame.refresh();
		ThreadSupport.sleep(3000);
		scanner.setScannedString("pAss + PROCeedall redo SLEEP thrEAD undO word RotateLeftArm 5 ROTATERIGHTARM ");
		scannerFrame.refresh();
		ThreadSupport.sleep(3000);
		scanner.setScannedString("\"quoted string\" \"broken string ");
		scannerFrame.refresh();
	}
	
	public static void animatingLine() {
		final int initialX = 100;
		final int initialY = 100;
		final int initialHeight = 50;
		final int initialWidth = 50;
		
		RotatingLine rLine = new ARotatingLine(initialX, initialY, initialHeight, initialWidth);
		OEFrame lineFrame = ObjectEditor.edit(rLine);
		lineFrame.showTreePanel();
		
		ThreadSupport.sleep(3000);
		rLine.rotate(8);
		lineFrame.refresh();
		
		ThreadSupport.sleep(3000);
		rLine.rotate(8);
		lineFrame.refresh();
		
		ThreadSupport.sleep(3000);
		rLine.rotate(8);
		lineFrame.refresh();
	}
	public static void processInput() {
		//method runs an input loop until a terminating line (begins with '.') is entered
		//valid inputs are passed to the string scanner (scanString())
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;							//control variable for input loop
		InputScanner lineScanner = new StringScanner();	//create a string scanner
		while (!exit) {
			String currentLine = scanner.nextLine();	//read a line of input
			if (currentLine.charAt(0) != '.') {			//check if the line is a terminating line
				lineScanner.setScannedString(currentLine);		//if not, scan it
				System.out.println(lineScanner.getErrors());
			} else {
				exit = true;							//otherwise don't scan and exit the input loop
			}
		}
		scanner.close();
	}
}
