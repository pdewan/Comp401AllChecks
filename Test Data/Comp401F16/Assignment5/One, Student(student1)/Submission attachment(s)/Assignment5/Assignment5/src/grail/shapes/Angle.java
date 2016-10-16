package grail.shapes;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
@Tags({"Angle"})

public class Angle implements VAngleShapeInterface {

  LineClass testLine, testLine1, testLine2, testLine3;


  public Angle(Point pointTheLinesMeet){
    testLine1 = new LineClass(pointTheLinesMeet, 75,75);
    testLine = new LineClass(pointTheLinesMeet, -75, 75);
  }
  
  public LineClass getLeftLine(){
    return testLine;
  }
  public LineClass getRightLine(){
    return testLine1;
  }
  public void moveVShape(Point pointTheLinesMeet, int movedX, int movedY){
    pointTheLinesMeet.movePoint(movedX, movedY);
  }
  
  

}
