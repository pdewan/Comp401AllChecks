package grail.tokenBeans;

import grail.interfaces.Number;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class NumberToken extends GenericToken implements Number{
	
	private int value;
	
	public NumberToken(String input){
		super(input);
		value = Integer.parseInt(input);
	}
	
	@Override
	public void setInput(String newString) {
		super.setInput(newString);
		value = Integer.parseInt(newString);
	}

	@Override
	public int getValue() {
		return value;
	}
}
