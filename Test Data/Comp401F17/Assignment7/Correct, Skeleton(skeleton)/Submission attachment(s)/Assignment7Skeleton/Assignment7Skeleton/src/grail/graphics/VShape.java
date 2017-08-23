package grail.graphics;

import grail.interfaces.RotatingLineInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"X", "Y","LeftLine", "RightLine", "LinesLength"})
@EditablePropertyNames({"X", "Y", "LinesLength"})
public class VShape extends LocatableObject implements VShapeInterface {

}
