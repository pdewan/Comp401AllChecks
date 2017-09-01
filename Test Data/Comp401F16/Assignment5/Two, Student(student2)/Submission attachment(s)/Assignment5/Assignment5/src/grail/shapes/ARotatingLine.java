package grail.shapes;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import grail.interfaces.RotatingLine;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"x", "y", "height", "width", "radius", "angle"})
@EditablePropertyNames({"x", "y", "height", "width", "radius", "angle"})

public class ARotatingLine implements RotatingLine {
	private int x;
	private int y;
	private int height;
	private int width;
	
	private double radius;
	private double angle;
	
	@Tags({"rotate"})
	public void rotate (int dAngle) {
		setAngle(angle + (dAngle*Math.PI/32));
	}
	
	public void moveLine (int dX, int dY) {
		setX(x + dX);
		setY(y + dY);
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double newRadius) {
		radius = newRadius;
		height = (int) (radius * Math.sin(angle));
		width = (int) (radius * Math.cos(angle));
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double newAngle) {
		while (newAngle >= 2*Math.PI) {
			newAngle -= 2*Math.PI;
		}
		angle = newAngle;
		width = (int) (radius * Math.cos(angle));
		height = (int) (radius * Math.sin(angle));
	}

	public int getX() {
		return x;
	}
	public void setX(int newX) {
		x = newX;
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		y = newY;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int newHeight) {
		height = newHeight;
		radius = Math.sqrt((double) width * width + (double) height * height);
//		angle = Math.atan((double) (height/width));
		if (width == 0) {
			if (newHeight > 0) {
				angle = Math.PI/2;
			} else {
				angle = 3*(Math.PI/2);
			}
		}
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
		radius = Math.sqrt((double) width * width + (double) height * height);
		angle = Math.atan((double) height/width);
	}
	
	public ARotatingLine () {
	}
	public ARotatingLine(int newX, int newY, int newHeight, int newWidth) {
		x = newX;
		y = newY;
		height = newHeight;
		width = newWidth;
		radius = Math.sqrt((double) width * width + (double) height * height);
		// angle = Math.atan((double) (height/width));
		if (newHeight < 0) {
			if (newWidth < 0) {
				angle = Math.atan((double) height/width) + Math.PI;
			} else if (newWidth > 0) {
				angle = Math.atan((double) height/width);
			} else {
				angle = (3/2) * Math.PI;
			}
		} else if (newHeight > 0) {
			if (newWidth < 0) {
				angle = Math.atan((double) height/width) + Math.PI;
			} else if (newWidth > 0) {
				angle = Math.atan((double) height/width);
			} else {
				angle = Math.PI/2;
			}
		} else if (newHeight == 0) {
			if (newWidth < 0) {
				angle = Math.PI;
			} else if (newWidth > 0) {
				angle = 0;
			}
		}
			
	}
	public ARotatingLine(int newX, int newY, double initialRadius, double initialAngle) {
		x = newX;
		y = newY;
		radius = initialRadius;
		setAngle(initialAngle);
	}
	
}
