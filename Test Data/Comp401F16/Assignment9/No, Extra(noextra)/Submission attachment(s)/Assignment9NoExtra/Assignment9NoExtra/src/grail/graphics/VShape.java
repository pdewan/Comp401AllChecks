package grail.graphics;

import java.beans.PropertyChangeListener;

import grail.interfaces.RotatingLineInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"X", "Y","LeftLine", "RightLine", "LinesLength"})
@EditablePropertyNames({"X", "Y", "LinesLength"})
public class VShape extends LocatableObject implements VShapeInterface {

	private RotatingLineInterface leftLine;
	private RotatingLineInterface rightLine;
	
	private static final double DEFAULT_LINE_LENGTH = 80;
	private static final double RIGHT_LINE_START_ANGLE = Math.PI/3;
	private static final double LEFT_LINE_START_ANGLE = 2*Math.PI/3;
	
	/**
	 * The only required constructor.
	 */
	public VShape(){
		rightLine = new RotatingLine(0, 0, DEFAULT_LINE_LENGTH, RIGHT_LINE_START_ANGLE);
		leftLine = new RotatingLine(0, 0, DEFAULT_LINE_LENGTH, LEFT_LINE_START_ANGLE);
		
		//Make the entire shape fit in the leftmost corner 
		setX(0 + Math.abs(leftLine.getWidth()));
		setY(0);
	}
	
	public VShape(int xPos, int yPos, double lineLengths){
		super(xPos, yPos);
		rightLine = new RotatingLine(xPos,yPos, lineLengths, RIGHT_LINE_START_ANGLE);
		leftLine = new RotatingLine(xPos,yPos, lineLengths, LEFT_LINE_START_ANGLE);
	}
	
	@Visible(false)
	@Override
	public void setX(int newX) {
		super.setX(newX);
		leftLine.setX(newX);
		rightLine.setX(newX);
	}

	@Visible(false)
	@Override
	public void setY(int newY) {
		super.setY(newY);
		leftLine.setY(newY);
		rightLine.setY(newY);
	}

	@Override
	public RotatingLineInterface getLeftLine() {
		return leftLine;
	}

	@Override
	public RotatingLineInterface getRightLine() {
		return rightLine;
	}

	@Override
	public void move(int changeInX, int changeInY) {
		setX(getX() + changeInX);
		setY(getY() + changeInY);
	}

	/**
	 * If line lengths differ, gives length of left line.
	 */
	@Override
	@Visible(false)
	public double getLinesLength() {
		return leftLine.getRadius();
	}

	@Override
	@Visible(false)
	public void setLinesLength(double newLength) {
		leftLine.setRadius(newLength);
		rightLine.setRadius(newLength);
	}
	
	@Override
	public void addPropertyChangeListenerToAtomics(PropertyChangeListener listener){
		getLeftLine().addPropertyChangeListener(listener);
		getRightLine().addPropertyChangeListener(listener);
	}
}
