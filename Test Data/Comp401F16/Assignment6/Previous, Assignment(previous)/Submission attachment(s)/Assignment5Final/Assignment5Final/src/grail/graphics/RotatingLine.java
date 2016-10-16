package grail.graphics;

import grail.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"Height", "Width", "X", "Y","Angle", "Radius"})
@EditablePropertyNames({"X", "Y","Angle", "Radius"})
public class RotatingLine implements RotatingLineInterface{

	private static final double DEGREE_IN_RADIANS = Math.PI / 180;
	private static final double DEFAULT_RADIUS = 100;
	
	private int x = 0;
	private int y = 0;
	private double radius = DEFAULT_RADIUS;
	private double angle = 0;
	
	public RotatingLine(){
		// Keep default values
	}
	
	public RotatingLine(int xPos, int yPos, double r, double theta){
		x = xPos;
		y = yPos;
		radius = r;
		angle = theta;
	}
	
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
