package grail.interfaces;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.TEXT_PATTERN)
public interface StringShapeInterface {
	
	public void setX(int newX);
	public int getX();

	public void setY(int newY);
	public int getY();

	public void setText(String newString);
	public String getText();
	
}
