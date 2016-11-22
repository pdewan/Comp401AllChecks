package grail.interfaces;

import util.annotations.Tags;

@Tags({"BoundedShape"})
public interface BoundedShapeInterface extends ObservableLocatable{

	public void setWidth(int newWidth);
	public int getWidth();
	
	public void setHeight(int newHeight);
	public int getHeight();
	
	@Tags({"move"})
	public void move(int moveX, int moveY);
}
