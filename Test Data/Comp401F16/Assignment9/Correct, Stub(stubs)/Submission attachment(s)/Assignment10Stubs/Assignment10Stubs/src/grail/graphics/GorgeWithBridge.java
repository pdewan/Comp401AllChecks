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

	@Override
	public RotatingLineInterface getLeftSide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RotatingLineInterface getRightSide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoundedShapeInterface getBridge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUpperY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUpperY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLeftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLeftX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRightX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRightX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBridgeWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBridgeWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGorgeLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setGorgeLength(int length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int moveX, int moveY) {
		// TODO Auto-generated method stub
		
	}
	
}
