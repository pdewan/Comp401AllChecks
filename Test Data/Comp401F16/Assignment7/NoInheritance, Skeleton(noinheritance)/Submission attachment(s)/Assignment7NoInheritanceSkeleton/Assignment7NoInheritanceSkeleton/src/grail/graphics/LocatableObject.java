package grail.graphics;

import grail.interfaces.Locatable;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y"})
@EditablePropertyNames({"X", "Y"})
@Tags({"Locatable"})
public class LocatableObject implements Locatable{

}
