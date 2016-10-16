package grail.graphics;

import grail.interfaces.BoundedShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})
@Tags({"BoundedShape"})
public class BoundedShape  implements BoundedShapeInterface {

}
