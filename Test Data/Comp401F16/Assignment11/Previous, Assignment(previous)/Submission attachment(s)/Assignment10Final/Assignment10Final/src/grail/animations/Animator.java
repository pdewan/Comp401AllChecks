package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;


@Tags({"Animator"})
public class Animator implements AnimatorInterface {

	private static final int NUM_FRAMES = 45;
	private static final int DEGREES_PER_ROTATE = 2;
	private static final int ROTATE_DELAY = 20;
	
	private static final int CLAP_DELAY = 1000;
	private static final double CLAP_ANGLE = Math.PI / 2;
	
	// Empty constructor
	public Animator() {}

	@Override
	@Tags({"animateAvatar"})
	public void animateAvatar(AvatarInterface avatar) {
		// Arm up
		for (int i = 0; i < NUM_FRAMES; ++i){
			avatar.getArms().getRightLine().rotateByClockwiseDegrees(-DEGREES_PER_ROTATE);
			ThreadSupport.sleep(ROTATE_DELAY);
		}
		// Arm down
		for (int i = 0; i < NUM_FRAMES; ++i){
			avatar.getArms().getRightLine().rotateByClockwiseDegrees(DEGREES_PER_ROTATE);
			ThreadSupport.sleep(ROTATE_DELAY);
		}
	}

	@Override
	public void clapGuard(BridgeSceneInterface scene) {
		RotatingLineInterface leftArm = scene.getGuard().getArms().getLeftLine();
		RotatingLineInterface rightArm = scene.getGuard().getArms().getRightLine();
		
		double oldLeftAngle = leftArm.getAngle();
		double oldRightAngle = rightArm.getAngle();
		leftArm.setAngle(CLAP_ANGLE);
		rightArm.setAngle(CLAP_ANGLE);
		
		ThreadSupport.sleep(CLAP_DELAY);
		
		leftArm.setAngle(oldLeftAngle);
		rightArm.setAngle(oldRightAngle);
	}
	
}
