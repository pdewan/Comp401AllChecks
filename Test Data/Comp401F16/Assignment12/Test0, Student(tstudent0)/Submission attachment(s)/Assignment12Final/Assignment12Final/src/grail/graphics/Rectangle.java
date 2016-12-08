package grail.graphics;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})
public class Rectangle extends BoundedShape {

	
	public Rectangle (int xPos, int yPos, int width, int height){
		super(xPos, yPos, width, height);
	}
	

}
