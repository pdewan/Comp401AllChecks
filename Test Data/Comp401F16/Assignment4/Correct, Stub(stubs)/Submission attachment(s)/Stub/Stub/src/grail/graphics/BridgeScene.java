package grail.graphics;

import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
@PropertyNames({"Arthur", "Lancelot","Robin", "Galahad", "Guard"})
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

}
