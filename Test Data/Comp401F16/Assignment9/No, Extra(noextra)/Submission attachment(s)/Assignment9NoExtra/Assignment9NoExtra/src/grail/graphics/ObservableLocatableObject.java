package grail.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.interfaces.ObservableLocatable;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y"})
@EditablePropertyNames({"X", "Y"})
@Tags({"Locatable"})
public class ObservableLocatableObject extends LocatableObject implements ObservableLocatable{

	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
	public ObservableLocatableObject(int xPos, int yPos){
		super(xPos,yPos);
	}
	
	// Empty constructor
	public ObservableLocatableObject(){}
	
	@Override
	public void setX(int newX) {
		int oldX = getX();
		super.setX(newX);
		notifyAllListeners(new PropertyChangeEvent(this, "X", oldX, newX));
	}
	
	@Override
	public void setY(int newY) {
		int oldY = getY();
		super.setY(newY);
		notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY, newY));
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.add(listener);
	}
	
	protected void notifyAllListeners(PropertyChangeEvent e){
		for (PropertyChangeListener listener : listeners){
			listener.propertyChange(e);
		}
	}

}
