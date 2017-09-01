package grail.shapes;
import grail.interfaces.Point;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Point"})
@EditablePropertyNames({"X", "Y"})
@PropertyNames({"X", "Y"})
@StructurePattern(StructurePatternNames.POINT_PATTERN)
public class APoint implements Point {
	int X;
	int Y;
	
	public int getX() {
		return X;
	}
	public void setX(int newX) {
		X = newX;
	}
	
	public int getY() {
		return Y;
	}
	public void setY(int newY) {
		Y = newY;
	}
	
	public APoint (int initX, int initY) {
		X = initX;
		Y = initY;
	}

}
