package grail.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

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

}
