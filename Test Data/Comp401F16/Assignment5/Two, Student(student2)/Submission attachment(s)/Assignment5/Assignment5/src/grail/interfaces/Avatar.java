package grail.interfaces;
import util.annotations.Tags;

@Tags({"Avatar"})
public interface Avatar {
	@Tags({"move"})
	public void moveAll(int dX, int dY);
	public HeadImage getHead();
	public DisplayString getStringShape();
	public Angle getArms();
	public Angle getLegs();
	public RotatingLine getBody();
	public RotatingLine getNeck();
	public void scaleAvatar(double scale);
}
