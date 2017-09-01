package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class NumberToken{
	
	private String input;
	private int value;
	
	public NumberToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
		value = Integer.parseInt(newString);
	}

	public String getInput() {
		return input;
	}

	public int getValue() {
		return value;
	}
}
