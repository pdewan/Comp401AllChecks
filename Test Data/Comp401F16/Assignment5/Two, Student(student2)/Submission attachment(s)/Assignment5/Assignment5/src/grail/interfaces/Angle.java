package grail.interfaces;
import util.annotations.Tags;

@Tags({"Angle"})
public interface Angle {
	@Tags({"move"})
	public void moveAngle(int dX, int dY);
	public RotatingLine getLeftLine();
	public RotatingLine getRightLine();
}
