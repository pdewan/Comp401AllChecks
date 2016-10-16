package grail.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"x", "y", "height", "width", "radius", "angle"})
@EditablePropertyNames({"x", "y", "height", "width", "radius", "angle"})
public interface RotatingLine extends Line {
		@Tags({"rotate"})
		public void rotate(int dAngle);
		public double getRadius();
		public void setRadius(double newRadius);
		public double getAngle();
		public void setAngle(double newAngle);
		public void moveLine(int dX, int dY);
}
