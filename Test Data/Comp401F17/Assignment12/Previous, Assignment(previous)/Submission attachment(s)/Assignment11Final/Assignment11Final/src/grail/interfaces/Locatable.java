package grail.interfaces;

import util.annotations.Tags;

@Tags({"Locatable"})
public interface Locatable {
	
	public void setX(int newX);
	public int getX();

	public void setY(int newY);
	public int getY();
	
}
