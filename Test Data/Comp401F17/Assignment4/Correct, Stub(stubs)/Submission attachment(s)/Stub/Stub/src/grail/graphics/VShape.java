package grail.graphics;

import grail.interfaces.RotatingLineInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"X", "Y","LeftLine", "RightLine", "LinesLength"})
@EditablePropertyNames({"X", "Y", "LinesLength"})
public class VShape implements VShapeInterface {

	@Override
	public void setX(int newX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int newY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RotatingLineInterface getLeftLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RotatingLineInterface getRightLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getLinesLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLinesLength(double newLength) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int changeInX, int changeInY) {
		// TODO Auto-generated method stub
		
	}

}
