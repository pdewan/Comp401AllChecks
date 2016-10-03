package grail.shapes;

import grail.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"Height", "Width","X", "Y","Angle", "Radius"})
@EditablePropertyNames({"X", "Y","Angle", "Radius"})
public class RotatingLine implements RotatingLineInterface{

	private static double DEGREE_IN_RADIANS = Math.PI / 180;
	private static double DEFAULT_RADIUS = 100;
	
	int upperLeftX = 0;
	int upperLeftY = 0;
	double radius = DEFAULT_RADIUS;
	double angle = 0;
	
	public RotatingLine(){
		// Keep default values
	}
	
	public RotatingLine(int x, int y, double r, double a){
		upperLeftX = x;
		upperLeftY = y;
		radius = r;
		angle = a;
	}
	
	@Override
	public int getX() {
		return upperLeftX;
	}
	
	@Override
	public void setX(int x) {
		upperLeftX = x;
	}

	@Override
	public int getY() {
		return upperLeftY;
	}
	
	@Override
	public void setY(int y) {
		upperLeftY = y;
	}
	
	@Override
	public int getHeight() {
		return (int)(radius*Math.sin(angle));
	}

	@Override
	public int getWidth() {
		return (int)(radius*Math.cos(angle));
	}

	@Override
	public void setRadius(double r) {
		radius = r;
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public void setAngle(double theta) {
		angle = theta;
	}

	@Override
	public double getAngle() {
		return angle;
	}

	@Override
	@Tags({"rotate"})
	public void rotateByClockwiseDegrees(int degrees) {
		setAngle(getAngle() + (degrees * DEGREE_IN_RADIANS));
	}

}
