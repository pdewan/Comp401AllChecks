package grail.interfaces;

import util.annotations.Tags;

public interface BoundedShapeInterface {
	public void setX(int newX);
	public int getX();

	public void setY(int newY);
	public int getY();
	
	public void setWidth(int newWidth);
	public int getWidth();
	
	public void setHeight(int newHeight);
	public int getHeight();
	
	@Tags({"move"})
	public void move(int moveX, int moveY);
}
