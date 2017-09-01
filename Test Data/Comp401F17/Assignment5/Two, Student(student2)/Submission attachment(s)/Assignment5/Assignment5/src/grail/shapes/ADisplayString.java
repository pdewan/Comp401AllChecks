package grail.shapes;
import grail.interfaces.*;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;

@Tags({"DisplayString"})
@PropertyNames({"Text", "X", "Y"})
@EditablePropertyNames({"Text", "X", "Y"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)
public class ADisplayString implements DisplayString {
	private String Text;
	private int X;
	private int Y;
	
	public void moveString(int dX, int dY) {
		setX(X + dX);
		setY(Y + dY);
	}
	
	public String getText() {
		return Text;
	}
	public void setText(String newText) {
		Text = newText;
	}
	public int getX () {
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
	
	public ADisplayString (String initText, int initX, int initY) {
		Text = initText;
		X = initX;
		Y = initY;
	}
}
