package grail.interfaces;

import util.annotations.Tags;

@Tags({"Avatar", "move"})
public interface AvatarInterface extends Locatable{

	public StringShapeInterface getStringShape();
	
	public ImageInterface getHead();
	
	public VShapeInterface getArms();
	
	public VShapeInterface getLegs();
	
	public RotatingLineInterface getTorso();
	
	public void move(int changeInX, int changeInY);
	public void scale(double scalar);
}
