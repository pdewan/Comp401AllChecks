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
public class NumberToken implements Number{
	
	private String input;
	private int value;
	
	public NumberToken(String input){
		setInput(input);
	}
	
	@Override
	public void setInput(String newString) {
		input = newString;
		value = Integer.parseInt(newString);
	}

	@Override
	public String getInput() {
		return input;
	}

	@Override
	public int getValue() {
		return value;
	}
}
