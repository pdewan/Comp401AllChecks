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

	private int x;
	private int y;

	public LocatableObject(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	
	// Empty constructor
	public LocatableObject(){}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setY(int newY) {
		y = newY;
	}

}
