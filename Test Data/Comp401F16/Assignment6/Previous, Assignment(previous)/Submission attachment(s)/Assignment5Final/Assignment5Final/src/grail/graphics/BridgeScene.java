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

	private static final int ARTHUR_LOCATION_X = 100;
	private static final int ARTHUR_LOCATION_Y = 200;
	private static final int LANCELOT_LOCATION_X = 200;
	private static final int LANCELOT_LOCATION_Y = 200;
	private static final int ROBIN_LOCATION_X = 300;
	private static final int ROBIN_LOCATION_Y = 200;
	private static final int GALAHAD_LOCATION_X = 400;
	private static final int GALAHAD_LOCATION_Y = 200;
	private static final int GUARD_LOCATION_X = 700;
	private static final int GUARD_LOCATION_Y = 200;
	
	private static final String ARTHUR_FILE_LOCATION = "images/arthur.jpg";
	private static final String LANCELOT_FILE_LOCATION = "images/lancelot.jpg";
	private static final String ROBIN_FILE_LOCATION = "images/robin.jpg";
	private static final String GALAHAD_FILE_LOCATION = "images/galahad.jpg";
	private static final String GUARD_FILE_LOCATION = "images/guard.jpg";
	
	private AvatarInterface arthur;
	private AvatarInterface lancelot;
	private AvatarInterface robin;
	private 	AvatarInterface galahad;
	private AvatarInterface guard;
	
	public BridgeScene(){
		arthur = new Avatar(ARTHUR_LOCATION_X, ARTHUR_LOCATION_Y, ARTHUR_FILE_LOCATION);
		lancelot = new Avatar(LANCELOT_LOCATION_X, LANCELOT_LOCATION_Y, LANCELOT_FILE_LOCATION);
		robin = new Avatar(ROBIN_LOCATION_X, ROBIN_LOCATION_Y, ROBIN_FILE_LOCATION);
		galahad = new Avatar(GALAHAD_LOCATION_X, GALAHAD_LOCATION_Y, GALAHAD_FILE_LOCATION);
		guard = new Avatar(GUARD_LOCATION_X,GUARD_LOCATION_Y, GUARD_FILE_LOCATION);
	}
	
	@Override
	public AvatarInterface getArthur() {
		return arthur;
	}

	@Override
	public AvatarInterface getLancelot() {
		return lancelot;
	}

	@Override
	public AvatarInterface getRobin() {
		return robin;
	}

	@Override
	public AvatarInterface getGalahad() {
		return galahad;
	}

	@Override
	public AvatarInterface getGuard() {
		return guard;
	}

}
