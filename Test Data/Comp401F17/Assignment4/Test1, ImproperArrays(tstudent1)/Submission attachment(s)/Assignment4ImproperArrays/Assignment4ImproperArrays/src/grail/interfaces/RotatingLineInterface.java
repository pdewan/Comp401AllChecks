package grail.interfaces;

import util.annotations.Tags;

@Tags({"RotatingLine","rotate"})
public interface RotatingLineInterface {
	public int getHeight();
	public int getWidth();
	
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	public void setRadius(double r);
	public double getRadius();
	
	public void setAngle(double theta);
	public double getAngle();
	
	public void rotateByClockwiseDegrees(int degrees);
}
