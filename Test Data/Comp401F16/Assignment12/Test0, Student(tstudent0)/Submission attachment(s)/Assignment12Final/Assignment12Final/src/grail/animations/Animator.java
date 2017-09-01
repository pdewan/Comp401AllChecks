package grail.animations;

import grail.SingletonsCreator;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;


@Tags({"Animator", "CoordinatingAnimator"})
public abstract class Animator implements AnimatorInterface {

	private static final int NUM_FRAMES = 15;
	private static final int DEGREES_PER_ROTATE = 6;
	
	private static final int CLAP_DELAY = 300;
	private static final double CLAP_ANGLE = Math.PI / 2;
	
	// Empty constructor
	public Animator() {}

	@Override
	@Tags({"animateAvatar"})
	public synchronized void animateAvatar(AvatarInterface avatar) {
		// Arm up
		for (int i = 0; i < NUM_FRAMES; ++i){
			avatar.getArms().getRightLine().rotateByClockwiseDegrees(-DEGREES_PER_ROTATE);
			pause();
		}
		// Arm down
		for (int i = 0; i < NUM_FRAMES; ++i){
			avatar.getArms().getRightLine().rotateByClockwiseDegrees(DEGREES_PER_ROTATE);
			pause();
		}
	}

	@Override
	public synchronized void clapGuard(BridgeSceneInterface scene) {
		RotatingLineInterface leftArm = scene.getGuard().getArms().getLeftLine();
		RotatingLineInterface rightArm = scene.getGuard().getArms().getRightLine();
		
		double oldLeftAngle = leftArm.getAngle();
		double oldRightAngle = rightArm.getAngle();
		leftArm.setAngle(CLAP_ANGLE);
		rightArm.setAngle(CLAP_ANGLE);
		
		ThreadSupport.sleep(CLAP_DELAY);
		
		leftArm.setAngle(oldLeftAngle);
		rightArm.setAngle(oldRightAngle);
		ThreadSupport.sleep(CLAP_DELAY);
	}
	
	/**
	 * Any lockstep methods move in lockstep with this method.
	 * @param scene
	 */
	@Override
	public synchronized void clapGuardLockstep(BridgeSceneInterface scene) {
		RotatingLineInterface leftArm = scene.getGuard().getArms().getLeftLine();
		RotatingLineInterface rightArm = scene.getGuard().getArms().getRightLine();
		
		double oldLeftAngle = leftArm.getAngle();
		double oldRightAngle = rightArm.getAngle();
		leftArm.setAngle(CLAP_ANGLE);
		rightArm.setAngle(CLAP_ANGLE);
		
		SingletonsCreator.broadcastingClearanceManagerMethod().proceedAll();
		ThreadSupport.sleep(CLAP_DELAY);
		
		leftArm.setAngle(oldLeftAngle);
		rightArm.setAngle(oldRightAngle);
		ThreadSupport.sleep(CLAP_DELAY);
	}
	
	/**
	 * Determines what kind of pauses are used in the animation. These can be sleep calls,
	 * or they can be waits if using lockstep animation.
	 */
	protected abstract void pause();
}
