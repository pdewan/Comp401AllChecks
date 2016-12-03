package grail.animations;

import grail.interfaces.AnimatorInterface;
import grail.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements Runnable{

	private AnimatorInterface animator;
	AvatarInterface avatar;
	
	public AnimatingCommand(AnimatorInterface animator, AvatarInterface avatar){
		this.animator = animator;
		this.avatar = avatar;
	}

	@Override
	public void run() {
		animator.animateAvatar(avatar);
	}

}
