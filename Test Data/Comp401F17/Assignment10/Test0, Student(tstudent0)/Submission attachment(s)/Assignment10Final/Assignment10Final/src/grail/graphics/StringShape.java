package grail.graphics;

import java.beans.PropertyChangeEvent;

import grail.interfaces.StringShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})
public class StringShape extends ObservableLocatableObject implements StringShapeInterface {

	private String text;
	
	public StringShape(int xPos, int yPos, String text){
		super(xPos, yPos);
		this.text = text;
	}
	
	@Override
	public void setText(String newString) {
		String oldString = text;
		text = newString;
		notifyAllListeners(new PropertyChangeEvent(this, "Text", oldString, newString));
	}

	@Override
	public String getText() {
		return text;
	}

}
