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
public class BoundedShape extends LocatableObject implements BoundedShapeInterface {

	private int width;
	private int height;
	
	public BoundedShape (int xPos, int yPos, int width, int height){
		super (xPos,yPos);
		this.width = width;
		this.height = height;
	}
	
	// empty constructor
	public BoundedShape(){}
	
	@Override
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	@Tags({"move"})
	public void move(int moveX, int moveY) {
		setX(getX() + moveX);
		setY(getY() + moveY);
	}

}
