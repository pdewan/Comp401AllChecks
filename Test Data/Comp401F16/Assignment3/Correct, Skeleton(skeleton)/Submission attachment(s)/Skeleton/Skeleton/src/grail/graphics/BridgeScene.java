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

}
