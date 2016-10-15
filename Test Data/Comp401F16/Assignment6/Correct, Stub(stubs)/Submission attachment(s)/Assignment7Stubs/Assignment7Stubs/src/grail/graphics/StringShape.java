package grail.graphics;

import grail.interfaces.StringShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})
public class StringShape extends LocatableObject implements StringShapeInterface {

	@Override
	public void setText(String newString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

}
