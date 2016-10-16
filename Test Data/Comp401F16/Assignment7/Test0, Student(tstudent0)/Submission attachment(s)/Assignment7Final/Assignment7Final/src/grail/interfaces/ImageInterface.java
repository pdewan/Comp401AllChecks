package grail.interfaces;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public interface ImageInterface extends BoundedShapeInterface{
	public void setImageFileName(String imageFileName);
	public String getImageFileName();
}
