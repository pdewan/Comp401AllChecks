package grail.interfaces;

import util.annotations.Tags;

@Tags({"BridgeScene"})
public interface BridgeSceneInterface {
	public AvatarInterface getArthur();
	public AvatarInterface getLancelot();
	public AvatarInterface getRobin();
	public AvatarInterface getGalahad();
	public AvatarInterface getGuard();
	
	public GorgeWithBridgeInterface getGorge();
	public BoundedShapeInterface getKnightArea();
	public BoundedShapeInterface getGuardArea();
	
	@Tags({"approach"})
	public void approach(AvatarInterface knight);
	
	@Tags({"say"})
	public void say(String string);
	
	@Tags({"passed"})
	public void passed();
	
	@Tags({"failed"})
	public void failed();
	public boolean getOccupied();
	public boolean getKnightTurn();
	
	@Tags({"scroll"})
	public void scroll(int scrollAmount, int i);
}
