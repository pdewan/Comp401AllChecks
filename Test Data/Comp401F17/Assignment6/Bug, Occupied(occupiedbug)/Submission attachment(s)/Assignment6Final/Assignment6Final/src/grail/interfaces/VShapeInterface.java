package grail.interfaces;

import util.annotations.Tags;

@Tags({"Angle", "move"})
public interface VShapeInterface {
	
	public void setX(int newX);
	public int getX();
	
	public void setY(int newY);
	public int getY();
	
	public RotatingLineInterface getLeftLine();
	public RotatingLineInterface getRightLine();
	
	public double getLinesLength();
	public void setLinesLength(double newLength);
	
	@Tags({"move"})
	public void move(int changeInX, int changeInY);
}
