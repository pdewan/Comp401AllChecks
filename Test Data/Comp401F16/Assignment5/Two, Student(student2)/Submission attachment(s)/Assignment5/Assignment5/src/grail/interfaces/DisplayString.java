package grail.interfaces;
import util.annotations.Tags;

@Tags({"StringShape"})
public interface DisplayString {
	public String getText();
	public void setText(String newText);
	public int getX ();
	public void setX(int newX);
	public int getY();
	public void setY(int newY);
	public void moveString(int dX, int dY);
}
