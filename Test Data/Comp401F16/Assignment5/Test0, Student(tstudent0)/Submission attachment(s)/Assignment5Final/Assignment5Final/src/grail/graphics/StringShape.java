package grail.graphics;

import grail.interfaces.StringShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})
public class StringShape implements StringShapeInterface {

	private int x;
	private int y;
	private String text;
	
	public StringShape(int xPos, int yPos, String text){
		x = xPos;
		y = yPos;
		this.text = text;
	}
	
	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setY(int newY) {
		y = newY;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setText(String newString) {
		text = newString;
	}

	@Override
	public String getText() {
		return text;
	}

}
