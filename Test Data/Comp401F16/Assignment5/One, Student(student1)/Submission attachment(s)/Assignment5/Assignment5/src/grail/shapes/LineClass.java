package grail.shapes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.LINE_PATTERN) 
@Tags({"Line"})

  public class LineClass implements LineClassInterface{
      int x = 100, y = 100;
      Point location;
      
      public LineClass (Point initialLocation, int initialX, int initialY) {
          location = initialLocation;
          x = initialX;
          y = initialY;  
      }
      
      public Point getLocation(){
        return location;
      }
      public void setLocation(Point newLocation){
        location = newLocation;
      }
      public int getWidth() {
        return x;
      }
      public void setWidth(int newVal) {
        x = newVal;
      }
      public int getHeight() {
        return y;
      }
      public void setHeight(int newHeight) {
        y = newHeight;
      }

  }


