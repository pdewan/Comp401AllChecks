package grail.shapes;
import util.annotations.EditablePropertyNames;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import grail.interfaces.*;

@Tags({"Head"})
@PropertyNames({"ImageFileName", "X", "Y", "Height", "Width"})
@EditablePropertyNames({"ImageFileName", "X", "Y", "Height", "Width"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class AHeadImage implements HeadImage {
	private String ImageFileName;
	private int Height;
	private int Width;
	private int X;
	private int Y;
	
	public void moveHead(int dX, int dY) {
		setX(X + dX);
		setY(Y + dY);
	}
	
	public String getImageFileName() {
		return ImageFileName;
	}
	public void setImageFileName(String newFile) {
		ImageFileName = newFile;
	}
	
	public int getHeight() {
		return Height;
	}
	public void setHeight(int newHeight) {
		Height = newHeight;
	}
	
	public int getWidth() {
		return Width;
	}
	public void setWidth(int newWidth) {
		Width = newWidth;
	}
	
	public int getX() {
		return X;
	}
	public void setX(int newX) {
		X = newX;
	}
	public int getY() {
		return Y;
	}
	public void setY(int newY) {
		Y = newY;
	}
	
	public AHeadImage (String initFile, int initX, int initY) {
		X = initX;
		Y = initY;
		ImageFileName = initFile;
		Icon headIcon = new ImageIcon(initFile);
		Height = headIcon.getIconHeight();
		Width = headIcon.getIconWidth();
	}
	public AHeadImage (String initFile, Point initLoc, int initHeight, int initWidth) {
		ImageFileName = initFile;
		Height = initHeight;
		Width = initWidth;
		X = initLoc.getX();
		Y = initLoc.getY();
	}
	public AHeadImage (String initFile, int initX, int initY, int initHeight, int initWidth) {
		ImageFileName = initFile;
		Height = initHeight;
		Width = initWidth;
		X = initX;
		Y = initY;
	}
}
