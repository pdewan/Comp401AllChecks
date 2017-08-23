package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;


@Tags({"Animator"})
public class SleepBasedAnimator extends Animator {

	private static final int ROTATE_DELAY = 60;
	
	// Empty constructor
	public SleepBasedAnimator() {}

	@Override
	protected void pause() {
		ThreadSupport.sleep(ROTATE_DELAY);
	}
	
}
