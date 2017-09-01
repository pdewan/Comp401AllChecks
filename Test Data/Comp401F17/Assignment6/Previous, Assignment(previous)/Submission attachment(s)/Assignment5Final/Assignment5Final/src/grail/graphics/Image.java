package grail.graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import grail.interfaces.ImageInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})
public class Image implements ImageInterface {

	private int x;
	private int y;
	private int width;
	private int height;
	private String imageFileName;
	
	public Image(int xPos, int yPos, int width, int height, String imageFileName){
		x = xPos;
		y = yPos;
		this.width = width;
		this.height = height;
		this.imageFileName = imageFileName;
	}
	
	public Image(int xPos, int yPos, String imageFileName){
		x = xPos;
		y = yPos;
		this.imageFileName = imageFileName;
		
		// Use image height and width
		Icon icon = new ImageIcon(imageFileName);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setY(int newY) {
		y = newY;
	}

	@Override
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setImageFileName(String newFileName) {
		imageFileName = newFileName;
	}

	@Override
	public String getImageFileName() {
		return imageFileName;
	}

}
