package grail;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import javax.swing.Icon;
import javax.swing.ImageIcon;
@StructurePattern(StructurePatternNames.LABEL_PATTERN)
public class AHeadImage implements HeadImage {
	String imageFileName;
    int x, y, height, width;
     
    public AHeadImage(String initImageFileName, int initX, int initY) {
    	imageFileName = initImageFileName;
    	Icon icon = new ImageIcon(imageFileName);
        height = icon.getIconHeight();
        width = icon.getIconWidth();
    	x = initX;
    	y = initY;    
    }
    
    public int getX() {
    	return x;
    }
 	public void setX(int newX) {
 		x = newX;
 	}
 	public int getY() { 
 		return y; 
 	}
 	public void setY(int newY) {
 		y = newY;
 	}
 	public int getHeight() { 
 		return height; 
 	}
 	public int getWidth() {
 		return width;
 	}
    public String getImageFileName() {
    	return imageFileName;
    }  
    public void setImageFileName(String newVal) {
    	imageFileName = newVal;
    }     

}
