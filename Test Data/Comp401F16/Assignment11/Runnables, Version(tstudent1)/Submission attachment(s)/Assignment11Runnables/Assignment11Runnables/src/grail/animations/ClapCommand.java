package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;

public class ClapCommand implements Runnable{

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
