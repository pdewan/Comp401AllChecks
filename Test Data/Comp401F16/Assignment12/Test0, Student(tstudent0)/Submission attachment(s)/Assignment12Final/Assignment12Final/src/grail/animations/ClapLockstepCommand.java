package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"CoordinatingAnimatingCommand"})
public class ClapLockstepCommand implements CommandThread{

	AnimatorInterface animator;
	BridgeSceneInterface scene;
	
	public ClapLockstepCommand(AnimatorInterface animator, BridgeSceneInterface scene){
		this.animator = animator;
		this.scene = scene;
	}
	
	@Override
	public void run() {
		animator.clapGuardLockstep(scene);
	}

}
