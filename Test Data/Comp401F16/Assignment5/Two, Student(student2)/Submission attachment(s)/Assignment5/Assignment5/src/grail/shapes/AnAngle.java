package grail.shapes;
import util.annotations.Tags;
import grail.interfaces.*;

@Tags({"Angle"})
public class AnAngle implements Angle {
	private RotatingLine LeftLine;
	private RotatingLine RightLine;
	
	private final int defaultAngleX = 250;
	private final int defaultAngleY = 250;
	private final int defaultLeftHeight = 50;
	private final int defaultLeftWidth = -50;
	private final int defaultRightHeight = 100;
	private final int defaultRightWidth = 100;
	
	@Tags({"move"})
	public void moveAngle (int dX, int dY) {
		LeftLine.moveLine(dX, dY);
		RightLine.moveLine(dX, dY);
	}
	
	public RotatingLine getLeftLine() {
		return LeftLine;
	}
	public RotatingLine getRightLine() {
		return RightLine;
	}
	
	public AnAngle () {
		LeftLine = new ARotatingLine(defaultAngleX, defaultAngleY, defaultLeftHeight, defaultLeftWidth);
		RightLine = new ARotatingLine(defaultAngleX, defaultAngleY, defaultRightHeight, defaultRightWidth);	
	}
	
	public AnAngle(int initX, int initY, int initHeight, int initWidth) {
		LeftLine = new ARotatingLine(initX, initY, initHeight, -initWidth);
		RightLine = new ARotatingLine(initX, initY, initHeight, initWidth);
	}
}
