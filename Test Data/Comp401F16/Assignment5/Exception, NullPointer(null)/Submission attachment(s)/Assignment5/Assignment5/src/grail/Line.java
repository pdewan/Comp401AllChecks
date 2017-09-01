package grail;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"Line"})

public interface Line{
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public void rotate(int units);
	public void setUpperLeftCorner(int newX, int newY);
}