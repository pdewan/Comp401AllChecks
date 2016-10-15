package grail.interfaces;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"RotatingLine"})
public interface RotatingLineInterface extends BoundedShapeInterface{

	public void setRadius(double r);
	public double getRadius();
	
	public void setAngle(double theta);
	public double getAngle();
	
	@Tags({"rotate"})
	public void rotateByClockwiseDegrees(int degrees);
}
