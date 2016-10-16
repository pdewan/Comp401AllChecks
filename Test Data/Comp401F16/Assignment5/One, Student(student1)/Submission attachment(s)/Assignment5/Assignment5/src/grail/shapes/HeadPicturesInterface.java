package grail.shapes;

public interface HeadPicturesInterface {
  public String getImageFileName();
  public void setImageFileName(String newImage);
  public int getX();
  public void setX (int newX);
  public int getY();
  public void setY(int newY);
  public int getHeight();
  public void setHeight(int newHeight);
  public int getWidth();
  public void setWidth(int newWidth);
  public void movePicture(int movedX, int movedY);
}
