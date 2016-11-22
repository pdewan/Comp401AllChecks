package grail.graphics;

import grail.interfaces.GorgeWithBridgeInterface;
import grail.interfaces.BoundedShapeInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftSide", "RightSide", "Bridge", "LeftX", "RightX", "UpperY", "BridgeWidth", "GorgeLength"})
@EditablePropertyNames({"LeftX", "RightX", "UpperY", "BridgeWidth", "GorgeLength"})
public class GorgeWithBridge implements GorgeWithBridgeInterface {
	
}
