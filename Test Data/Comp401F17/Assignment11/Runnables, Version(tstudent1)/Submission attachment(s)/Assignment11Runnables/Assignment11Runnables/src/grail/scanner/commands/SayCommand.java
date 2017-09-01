package grail.scanner.commands;

import grail.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"SayCommand"})
public class SayCommand implements Runnable{

	private BridgeSceneInterface scene;
	private String quote;
	
	public SayCommand(BridgeSceneInterface scene, String quote){
		this.scene = scene;
		this.quote = quote;
	}
	
	@Override
	public void run() {
		scene.say(quote);
	}

}
