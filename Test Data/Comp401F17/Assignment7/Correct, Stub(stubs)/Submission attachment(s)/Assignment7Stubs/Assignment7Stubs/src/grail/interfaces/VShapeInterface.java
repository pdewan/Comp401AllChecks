package grail.interfaces;

import util.annotations.Tags;

@Tags({"Angle", "move"})
public interface VShapeInterface extends Locatable{

	public RotatingLineInterface getLeftLine();
	public RotatingLineInterface getRightLine();
	
	public double getLinesLength();
	public void setLinesLength(double newLength);
	
	@Tags({"move"})
	public void move(int changeInX, int changeInY);
}
