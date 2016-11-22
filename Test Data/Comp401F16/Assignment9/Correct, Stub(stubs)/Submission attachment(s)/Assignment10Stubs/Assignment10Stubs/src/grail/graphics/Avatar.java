package grail.graphics;

import java.beans.PropertyChangeListener;

import grail.interfaces.AvatarInterface;
import grail.interfaces.ImageInterface;
import grail.interfaces.RotatingLineInterface;
import grail.interfaces.StringShapeInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Avatar"})
@PropertyNames({"X", "Y","Head", "Legs", "Arms", "Torso", "StringShape"})
@EditablePropertyNames({"X", "Y"})
public class Avatar extends LocatableObject implements AvatarInterface {

	@Override
	public void setX(int newX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setY(int newY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringShapeInterface getStringShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageInterface getHead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VShapeInterface getArms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VShapeInterface getLegs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RotatingLineInterface getTorso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(int changeInX, int changeInY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(double scalar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPropertyChangeListenerToAtomics(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
