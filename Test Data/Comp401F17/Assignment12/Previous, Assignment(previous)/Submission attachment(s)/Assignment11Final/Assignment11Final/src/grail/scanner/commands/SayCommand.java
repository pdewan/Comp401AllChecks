package grail.scanner.commands;

import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"SayCommand"})
public class SayCommand implements CommandThread{

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
