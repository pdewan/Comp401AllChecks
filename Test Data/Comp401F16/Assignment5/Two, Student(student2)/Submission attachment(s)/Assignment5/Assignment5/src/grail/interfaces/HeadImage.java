package grail.interfaces;
import util.annotations.Tags;

@Tags({"Head"})
public interface HeadImage {
	public String getImageFileName();
	public void setImageFileName(String newFile);
	public int getHeight();
	public void setHeight(int newHeight);
	public int getWidth();
	public void setWidth(int newWidth);
	public int getX();
	public void setX(int newX);
	public int getY();
	public void setY(int newY);	
	public void moveHead(int dX, int dY);
}
