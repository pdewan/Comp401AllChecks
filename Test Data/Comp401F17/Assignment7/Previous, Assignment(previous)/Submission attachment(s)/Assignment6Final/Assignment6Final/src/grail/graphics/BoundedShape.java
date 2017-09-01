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
public class BoundedShape implements BoundedShapeInterface {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public BoundedShape (int xPos, int yPos, int width, int height){
		x = xPos;
		y = yPos;
		this.width = width;
		this.height = height;
	}
	
	// empty constructor
	public BoundedShape(){}
	
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
		x += moveX;
		y += moveY;
	}

}
