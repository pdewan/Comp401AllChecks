package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;

public class ClapCommand implements CommandThread{

	AnimatorInterface animator;
	BridgeSceneInterface scene;
	
	public ClapCommand(AnimatorInterface animator, BridgeSceneInterface scene){
		this.animator = animator;
		this.scene = scene;
	}
	
	@Override
	public void run() {
		animator.clapGuard(scene);
	}

}
