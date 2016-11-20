package grail.interfaces;


public interface GorgeWithBridgeInterface {

	public RotatingLineInterface getLeftSide();
	public RotatingLineInterface getRightSide();
	public BoundedShapeInterface getBridge();

	public int getUpperY();
	public void setUpperY(int y);

	public int getLeftX();
	public void setLeftX(int x);

	public int getRightX();
	public void setRightX(int x);

	public int getBridgeWidth();
	public void setBridgeWidth(int width);

	public int getGorgeLength();
	public void setGorgeLength(int length);
	
	public void move(int moveX, int moveY);
}