package grail.shapes;

import util.annotations.StructurePattern;
import util.annotations.Tags;

@StructurePattern("Bean Pattern")
@Tags({"Avatar"})

public class AvatarClass implements AvatarClassInterface{
  HeadPictures headTest;
  Angle arms, legs;
  LineClass body;
  Point bodyPoint = new Point(300, 200);  
  Point armsPoint = new Point(300, 200);
  Point legsPoint = new Point(300, 300);
  SpeechText newText;


  public AvatarClass(String jpeg){
  headTest = new HeadPictures(jpeg, 250, 100, 100, 100);
  arms = new Angle(armsPoint);
  legs = new Angle(legsPoint);
  body = new LineClass(bodyPoint, 0, 100);
  newText = new SpeechText("Arthur takes a Walk", 450, 50);
    }
  
  
  public HeadPictures getHead(){
    return headTest;
    }
  public Angle getArms(){
    return arms;
  }
  public Angle getLegs(){
    return legs;
  }
  public LineClass getBody(){
    return body;
  }
  public SpeechText getStringShape(){
    return newText;
  }

  @Tags({"move"})
  public void moveBody(Point point, int movedX, int movedY){
    arms.moveVShape(armsPoint, movedX, movedY);
    legs.moveVShape(legsPoint, movedX, movedY);
    bodyPoint.movePoint(movedX, movedY);
    headTest.movePicture(movedX, movedY);
  }
  

  
  

 }
