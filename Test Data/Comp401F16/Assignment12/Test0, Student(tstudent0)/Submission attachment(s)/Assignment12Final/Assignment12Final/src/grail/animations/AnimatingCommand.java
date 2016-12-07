package grail.animations;

import grail.SingletonsCreator;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"AnimatingCommand", "CoordinatedAnimationCommand"})
public class AnimatingCommand implements CommandThread{

	private AnimatorInterface animator;
	private AvatarInterface avatar;
	private boolean wait = false;
	
	public AnimatingCommand(AnimatorInterface animator, AvatarInterface avatar){
		this.animator = animator;
		this.avatar = avatar;
	}
	
	/**
	 * Waiting version of animation command.
	 * 
	 * @param animator instance of animator to use
	 * @param avatar avatar to animate
	 * @param wait whether to wait for a notification from ABroadCastingClearanceManager
	 */
	public AnimatingCommand(AnimatorInterface animator, AvatarInterface avatar, boolean wait){
		this.animator = animator;
		this.avatar = avatar;
		this.wait = wait;
	}

	@Override
	public void run() {
		if (wait){
			SingletonsCreator.broadcastingClearanceManagerMethod().waitForProceed();
		}
		animator.animateAvatar(avatar);
	}

}
