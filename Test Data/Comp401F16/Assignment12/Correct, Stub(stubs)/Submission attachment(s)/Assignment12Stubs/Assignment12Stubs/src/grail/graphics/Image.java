package grail.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
public class Image extends Rectangle implements ImageInterface {

	@Override
	public void setWidth(int newWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(int newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(int moveX, int moveY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX(int newX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int newY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageFileName(String imageFileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getImageFileName() {
		// TODO Auto-generated method stub
		return null;
	}

}
