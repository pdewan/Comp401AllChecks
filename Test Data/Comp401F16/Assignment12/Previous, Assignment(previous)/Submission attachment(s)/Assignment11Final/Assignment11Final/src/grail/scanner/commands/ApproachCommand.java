package grail.scanner.commands;

import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"ApproachCommand"})
public class ApproachCommand implements CommandThread{

	private BridgeSceneInterface scene;
	private AvatarInterface avatar;
	
	public ApproachCommand(BridgeSceneInterface scene, AvatarInterface avatar){
		this.scene = scene;
		this.avatar = avatar;
	}
	
	@Override
	public void run() {
		scene.approach(avatar);
	}

}
