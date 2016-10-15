package grail.interfaces;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public interface ImageInterface {
	
	public void setX(int newX);
	public int getX();

	public void setY(int newY);
	public int getY();
	
	public void setWidth(int newWidth);
	public int getWidth();
	
	public void setHeight(int newHeight);
	public int getHeight();
	
	public void setImageFileName(String imageFileName);
	public String getImageFileName();
}
