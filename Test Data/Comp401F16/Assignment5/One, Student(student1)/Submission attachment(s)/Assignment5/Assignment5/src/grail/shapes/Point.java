package grail.shapes;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Tags({"Point"})


public class Point implements PointInterface {  
  protected int x, y;
  public Point(int movedX, int movedY) {
    x = movedX;
    y = movedY;
  }

  public int getX() {
    return x; 
  }
  public int getY() { 
    return y; 
  }
  public void setX(int newX) {
    x = newX;
  }
  public void setY(int newY) {
    y = newY;
  }
  public void movePoint(int newX, int newY){
    x = x + newX;
    y = y + newY;
  }
  
}