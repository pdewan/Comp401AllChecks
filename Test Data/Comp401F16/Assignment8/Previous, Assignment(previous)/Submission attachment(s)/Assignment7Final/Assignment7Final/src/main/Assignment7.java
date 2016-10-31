package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
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

public class Assignment7 {
	
	private static final int SLOW_DELAY = 2000;
	
	private static final int OEFRAME_WIDTH = 1000;
	private static final int OEFRAME_HEIGHT = 500;
	
	private static final String[] TEST_STRINGS = {
			"say \"Well what do we have here\"",
			"say \"This town ain't big enough for both of us\"",
			"move guard 50 50",
			"move arthur - 50 - 50",
			"move galahad + 50 - 50",
			"move RoBIN 50 - 0",
			"move LANCELot + 0 + 50",
			"move notAvatar 20 20",
			"unparseable123 tokens*( here",
			"move arthur \"notNumber\"",
			"say 25"
			};
	
	public static void main(String[] args) {
		
		// Table test
		Table table = new MyTable();
		table.put("monkey", "Hugo");
		table.put("twelve", new Integer(12));
		table.put("null value", null);
		System.out.println(table.get("twelve"));
		System.out.println(table.get("monkey"));
		System.out.println(table.get("null value"));
		System.out.println(table.get("random"));
		System.out.println(table.get(null));
		
		BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
		ScannerBeanInterface scannerBean = SingletonsCreator.scannerFactoryMethod();
		CommandInterpreterInterface interpreter = SingletonsCreator.commandInterpreterFactoryMethod();
		
		OEFrame sceneFrame = ObjectEditor.edit(scene);
		OEFrame scannerFrame = ObjectEditor.edit(scannerBean);
		OEFrame interpreterFrame = ObjectEditor.edit(interpreter);
		
		sceneFrame.hideMainPanel();
		sceneFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
		scannerFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
		interpreterFrame.setSize(OEFRAME_WIDTH, OEFRAME_HEIGHT);
		
		ThreadSupport.sleep(SLOW_DELAY);
		scene.approach(scene.getGalahad());
		sceneFrame.refresh();
		scannerFrame.refresh();
		interpreterFrame.refresh();
		
		for (int i = 0; i < TEST_STRINGS.length; ++i){
			ThreadSupport.sleep(SLOW_DELAY);
			interpreter.setCommand(TEST_STRINGS[i]);
			sceneFrame.refresh();
			scannerFrame.refresh();
			interpreterFrame.refresh();
		}
		
	}//end main
}//end class
