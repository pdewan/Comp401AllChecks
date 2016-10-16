package grail.graphics;

import grail.interfaces.AvatarInterface;
import grail.interfaces.BoundedShapeInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.GorgeWithBridgeInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
@PropertyNames({"Guard", "Arthur", "Lancelot","Robin", "Galahad",
	"Gorge", "GuardArea", "KnightArea", "Occupied", "KnightTurn"})
public class BridgeScene implements BridgeSceneInterface {

	@Override
	public AvatarInterface getArthur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvatarInterface getLancelot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvatarInterface getRobin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvatarInterface getGalahad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvatarInterface getGuard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GorgeWithBridgeInterface getGorge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundedShapeInterface getKnightArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundedShapeInterface getGuardArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approach(AvatarInterface knight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void say(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getOccupied() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getKnightTurn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void scroll(int scrollAmount, int i) {
		// TODO Auto-generated method stub
		
	}

}
