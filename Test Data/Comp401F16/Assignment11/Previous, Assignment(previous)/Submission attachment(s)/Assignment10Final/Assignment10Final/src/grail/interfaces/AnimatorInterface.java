package grail.interfaces;

import util.annotations.Tags;

@Tags({"Animator"})
public interface AnimatorInterface {
	@Tags({"animateAvatar"})
	public void animateAvatar(AvatarInterface avatar);
	
	void clapGuard(BridgeSceneInterface scene);
}
