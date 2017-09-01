package grail.graphics;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})
public class Oval extends BoundedShape{
	
	public Oval (int xPos, int yPos, int width, int height){
		super(xPos, yPos, width, height);
	}
	
}
