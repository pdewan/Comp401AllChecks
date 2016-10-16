package grail.interfaces;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Point"})
@EditablePropertyNames({"X", "Y"})
@PropertyNames({"X", "Y"})
@StructurePattern(StructurePatternNames.POINT_PATTERN)
public interface Point {
	public int getX();
	public int getY();
	public void setX(int newX);
	public void setY(int newY);
}
