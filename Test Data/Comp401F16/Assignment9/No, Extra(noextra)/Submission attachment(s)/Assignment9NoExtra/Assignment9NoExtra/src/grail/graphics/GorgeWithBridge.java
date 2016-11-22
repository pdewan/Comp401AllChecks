package grail.graphics;

import grail.interfaces.GorgeWithBridgeInterface;
import grail.interfaces.BoundedShapeInterface;
import grail.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftSide", "RightSide", "Bridge", "LeftX", "RightX", "UpperY", "BridgeWidth", "GorgeLength"})
@EditablePropertyNames({"LeftX", "RightX", "UpperY", "BridgeWidth", "GorgeLength"})
public class GorgeWithBridge implements GorgeWithBridgeInterface {
	
	private static final int DEFAULT_UPPER_Y = -1000;
	private static final int DEFAULT_LENGTH = 4000;
	private static final double ANGLE_DOWNWARD = Math.PI/2;
	
	private RotatingLineInterface leftSide;
	private RotatingLineInterface rightSide;
	private BoundedShapeInterface bridge;
	
	// Constructors
	public GorgeWithBridge(int leftX, int rightX, int bridgeY, int bridgeWidth){
		leftSide = new RotatingLine(leftX, DEFAULT_UPPER_Y, DEFAULT_LENGTH, ANGLE_DOWNWARD);
		rightSide = new RotatingLine(rightX, DEFAULT_UPPER_Y, DEFAULT_LENGTH, ANGLE_DOWNWARD);
		
		// bridgeWidth refers to the width of the bridge, which is the height of the rectangle
		bridge = new Rectangle(leftX, bridgeY, rightX-leftX, bridgeWidth);
	}
	
	public GorgeWithBridge(int leftX, int rightX, int y, int gorgeLength, int bridgeY, int bridgeWidth){
		leftSide = new RotatingLine(leftX, y, gorgeLength, ANGLE_DOWNWARD);
		rightSide = new RotatingLine(rightX, y, gorgeLength, ANGLE_DOWNWARD);
		
		bridge = new Rectangle(leftX, bridgeY, rightX-leftX, bridgeWidth);
	}
	
	@Override
	public RotatingLineInterface getLeftSide(){
		return leftSide;
	}
	
	@Override
	public RotatingLineInterface getRightSide(){
		return rightSide;
	}
	
	@Override
	public BoundedShapeInterface getBridge(){
		return bridge;
	}
	
	@Override
	@Visible(false)
	public int getUpperY(){
		return leftSide.getY();
	}
	@Override
	@Visible(false)
	public void setUpperY(int y){
		leftSide.setY(y);
		rightSide.setY(y);
	}
	
	@Override
	@Visible(false)
	public int getLeftX(){
		return leftSide.getX();
	}
	@Override
	@Visible(false)
	public void setLeftX(int x){
		leftSide.setX(x);
		bridge.setX(x);
		bridge.setWidth(rightSide.getX() - x);
	}
	
	@Override
	@Visible(false)
	public int getRightX(){
		return rightSide.getX();
	}
	@Override
	@Visible(false)
	public void setRightX(int x){
		rightSide.setX(x);
		bridge.setWidth(x- leftSide.getX());
	}
	
	@Override
	@Visible(false)
	public int getBridgeWidth(){
		return bridge.getHeight();
	}
	@Override
	@Visible(false)
	public void setBridgeWidth(int width){
		bridge.setHeight(width);
	}
	
	@Override
	@Visible(false)
	public int getGorgeLength(){
		return (int)leftSide.getRadius();
	}
	@Override
	@Visible(false)
	public void setGorgeLength(int length){
		leftSide.setRadius(length);
		rightSide.setRadius(length);
	}

	@Override
	public void move(int moveX, int moveY) {
		leftSide.setX(leftSide.getX() + moveX);
		leftSide.setY(leftSide.getY() + moveY);
		rightSide.setX(rightSide.getX() + moveX);
		rightSide.setY(rightSide.getY() + moveY);
		bridge.move(moveX, moveY);
	}
	
}
