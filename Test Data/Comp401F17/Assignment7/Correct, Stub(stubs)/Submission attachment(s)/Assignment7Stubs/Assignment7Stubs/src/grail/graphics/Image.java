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
public class Image extends Rectangle implements ImageInterface {

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
