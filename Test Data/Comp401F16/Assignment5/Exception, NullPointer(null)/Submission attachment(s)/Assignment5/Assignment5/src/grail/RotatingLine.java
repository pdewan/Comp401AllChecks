package grail;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"RotatingLine"})
public class RotatingLine implements Line {
	int xVal, yVal;
	double radius, angle;
	APolarPoint lowerRightCorner;

	
	public RotatingLine(double aRadius, double anAngle){
		radius = aRadius;
		angle = anAngle;
		lowerRightCorner = new APolarPoint(radius, angle);
	}
	
	public int getX(){
		return xVal;
	}

	public int getY(){
		return yVal;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public double getAngle(){
		return angle;
	}

	public void setUpperLeftCorner(int newX, int newY){
		xVal = newX;
		yVal = newY;
	}
	public int getWidth(){
		return lowerRightCorner.getX();
	}
	public int getHeight(){
		return lowerRightCorner.getY();
	}
	@Tags({"rotate"})
	public void rotate(int units){
		double newerAngle = angle + (units*(Math.PI/32));
		angle = newerAngle;
		lowerRightCorner = new APolarPoint(radius, angle);
		System.out.println(angle);
	}

}
