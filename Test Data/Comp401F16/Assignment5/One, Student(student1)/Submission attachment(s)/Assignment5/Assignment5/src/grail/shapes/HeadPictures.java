package grail.shapes;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class HeadPictures implements HeadPicturesInterface {
  String imageFileName;
  int x, y, height, width;
  
  public HeadPictures(String initialImageFileName, int initialX, int initialY, int initialHeight, int initialWidth){
    imageFileName = initialImageFileName;
    x = initialX;
    y = initialY;    
    height = initialHeight;
    width = initialWidth;
    
  }
  
  public void setImageFileName(String newImage){
    imageFileName = newImage;
  }
  
  public String getImageFileName(){
    return imageFileName;
  }
  
  public void setX (int newX) {
    x = newX;
  }
  
  public int getX (){
    return x;
  }
  
  public void setY(int newY){
    y = newY;
  }
  
  public int getY(){
    return y;
  }
 
  public void setHeight(int newHeight){
    height = newHeight;
  }
  
  public int getHeight(){
    return height;
  }
  
  public void setWidth(int newWidth){
    width = newWidth;
  }
  
  public int getWidth(){
    return width;
  }
  
  public void movePicture(int movedX, int movedY){
    x = x + movedX;
    y = y + movedY;
  }
}
  