package grail.interfaces;

import util.annotations.Tags;

@Tags({"BridgeScene"})
public interface BridgeSceneInterface {
	public AvatarInterface getArthur();
	public AvatarInterface getLancelot();
	public AvatarInterface getRobin();
	public AvatarInterface getGalahad();
	public AvatarInterface getGuard();
}
