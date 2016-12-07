package grail.scanner.commands;

import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"FailCommand"})
public class FailCommand implements CommandThread{

	private BridgeSceneInterface scene;
	
	public FailCommand(BridgeSceneInterface scene){
		this.scene = scene;
	}
	
	@Override
	public void run() {
		scene.failed();
	}

}
