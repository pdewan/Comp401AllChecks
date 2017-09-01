package grail.graphics;

import java.beans.PropertyChangeEvent;

import grail.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"Height", "Width", "X", "Y","Angle", "Radius"})
@EditablePropertyNames({"X", "Y","Angle", "Radius"})
public class RotatingLine extends BoundedShape implements RotatingLineInterface{

}
