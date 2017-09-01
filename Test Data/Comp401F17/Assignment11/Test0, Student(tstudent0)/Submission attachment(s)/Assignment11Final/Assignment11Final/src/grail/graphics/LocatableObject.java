package grail.graphics;

import grail.interfaces.Locatable;

public abstract class LocatableObject implements Locatable{


	private int x;
	private int y;
	
	public LocatableObject(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}
	
	// Empty constructor
	public LocatableObject(){}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setX(int newX) {
		x = newX;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setY(int newY) {
		y = newY;
	}

}
