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

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
