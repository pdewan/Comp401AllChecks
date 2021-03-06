package grail.graphics;

import java.beans.PropertyChangeEvent;

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
public class RotatingLine extends BoundedShape implements RotatingLineInterface{
	
	private static final double DEGREE_IN_RADIANS = Math.PI / 180;
	private static final double DEFAULT_RADIUS = 100;
	
	private double radius = DEFAULT_RADIUS;
	private double angle = 0;
	
	public RotatingLine(){
		setX(0);
		setY(0);
	}
	
	public RotatingLine(int xPos, int yPos, double r, double theta){
		setX(xPos);
		setY(yPos);
		radius = r;
		angle = theta;
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
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		radius = r;
		
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
	}

	@Override
	public double getRadius() {
		return radius;
	}

	/**
	 * Angle is in radians, clockwise from right horizontal
	 */
	@Override
	public void setAngle(double theta) {
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		angle = theta;
		
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
	}
	
	/**
	 * Angle is in radians, clockwise from right horizontal
	 */
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
