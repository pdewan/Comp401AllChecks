package grail.graphics;

import java.beans.PropertyChangeEvent;

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

	private String imageFileName;
	
	public Image(int xPos, int yPos, int width, int height, String imageFileName){
		super(xPos, yPos, width, height);
		this.imageFileName = imageFileName;
	}
	
	public Image(int xPos, int yPos, String imageFileName){
		super(xPos, yPos, 0, 0);		//temporary height and width
		
		this.imageFileName = imageFileName;
		
		// Use image height and width
		Icon icon = new ImageIcon(imageFileName);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
	}
	
	@Override
	public void setImageFileName(String newFileName) {
		String oldFileName = imageFileName;
		imageFileName = newFileName;
		notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldFileName, newFileName));
	}

	@Override
	public String getImageFileName() {
		return imageFileName;
	}

}
