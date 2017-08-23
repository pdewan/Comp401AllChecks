package grail;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.StructurePattern;

@Tags({"Angle"})
@PropertyNames({"LeftLine", "RightLine"})
@StructurePattern("Bean Pattern")

public class Angle {
	RotatingLine LeftLine, RightLine;
	int length;
	int x, y;
	public Angle(){
		
	}
	public Angle(int xVal, int yVal, int aLength){
		x = xVal;
		y = yVal;
		LeftLine = new RotatingLine(aLength, 135*Math.PI/180);
		RightLine = new RotatingLine(aLength, 45*Math.PI/180);
		LeftLine.setUpperLeftCorner(x, y);
		RightLine.setUpperLeftCorner(x, y);
	}
	
	public RotatingLine getLeftLine(){
		return LeftLine;
	}
	public RotatingLine getRightLine(){
		return RightLine;
	}
	@Tags({"move"})
	public void move(int newX, int newY){
		x += newX;
		y += newY;
		LeftLine.setUpperLeftCorner(x, y);
		RightLine.setUpperLeftCorner(x, y);
	}
}
