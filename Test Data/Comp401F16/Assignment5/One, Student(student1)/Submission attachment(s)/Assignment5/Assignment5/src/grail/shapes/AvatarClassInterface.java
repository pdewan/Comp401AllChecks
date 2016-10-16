package grail.shapes;

public interface AvatarClassInterface {
  public HeadPictures getHead();
  public Angle getArms();
  public LineClass getBody();
  public SpeechText getStringShape();
  public Angle getLegs();
  public void moveBody(Point point, int movedX, int movedY);
}
