package grail.animations;

import grail.SingletonsCreator;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;


@Tags({"CoordinatedAnimator"})
public class WaitBasedAnimator extends Animator {

	private static final int ROTATE_DELAY = 20;
	private BroadcastingClearanceManager clearanceManager;
	
	// Empty constructor
	public WaitBasedAnimator() {
		clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();
	}

	@Override
	protected void pause() {
		clearanceManager.waitForProceed();
	}
	
}
