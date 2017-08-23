package grail.scanner.commands;

import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"PassCommand"})
public class PassCommand implements CommandThread{

	private BridgeSceneInterface scene;
	
	public PassCommand(BridgeSceneInterface scene){
		this.scene = scene;
	}
	
	@Override
	public void run() {
		scene.passed();
	}

}
